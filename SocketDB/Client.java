package SocketDB;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		Socket socket = null;
		String serverName = "localhost";
		int serverPort = 9999;
		ObjectOutputStream out = null;
		ObjectInputStream in = null;
		Scanner reader = new Scanner(System.in);
		try {
			socket = new Socket(serverName, serverPort);
			System.out.println("Connected");
			out = new ObjectOutputStream(socket.getOutputStream());
			System.out.println("Input name");
			String name = reader.nextLine();
			System.out.println("Input age");
			int age = Integer.parseInt(reader.nextLine());
			Student student = new Student(name,age);
			System.out.println("created student");
			out.writeObject(student);
			System.out.println("sended");
		}
		catch(IOException e){
			System.out.println("Unexpected exception: " + e.getMessage());
		}
	}

}
