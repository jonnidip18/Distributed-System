package HW04_06_01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
public class Client {

	public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException {
		Socket socket = null;
		String serverName = "localhost";
		int serverPort = 9999;
		DataOutputStream out = null;
		DataInputStream in = null;
		Scanner reader = new Scanner(System.in);
		socket = new Socket(serverName, serverPort);
		System.out.println("Connected");
		
		out = new DataOutputStream(socket.getOutputStream());
		System.out.println("Input id");
		int id = Integer.parseInt(reader.nextLine());
		System.out.println("Input name");
		String name = reader.nextLine();
		System.out.println("Input grade");
		Double grade = Double.parseDouble(reader.nextLine());
		Student student = new Student(id,name,grade);
		System.out.println("created student");
		String xml = Object2Doc.convertObject2Doc(student);
		out.writeUTF(xml);
		out.flush();
		reader.close();
		System.out.println("sended");
		
		in = new DataInputStream(socket.getInputStream());
		String getXML = in.readUTF();
		List<Student> students = Doc2Object.XMLtoStudents(getXML);
		for(Student stud: students) {
			System.out.println(stud);
		}
		socket.close();
	}
}
