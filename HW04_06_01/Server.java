package HW04_06_01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class Server {
	static ServerSocket socket = null;
	static int port = 9999;
	
	public static Connection connectToDatabase(String user, String password) {
        // connect to database
        String databaseUrl = "jdbc:mysql://localhost:3306/database1?user=" + user + "&password=" + password;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(databaseUrl);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return conn;
    }

	public static boolean addStudent(Connection conn, int id, String name, double grade) {
        String query = "INSERT INTO student(id,name,grade) VALUE (?, ?, ?)";
        try {
            PreparedStatement st = conn.prepareStatement(query); // create prepared statement
            st.setString(2, name);
            st.setInt(1, id);
            st.setDouble(3,grade);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
	
	public static List<Student> getStudents(Connection conn) {
		List<Student> students = new ArrayList<Student>();
		
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("Select * from student");
			while(rs.next()) {
				Student student = new Student(rs.getInt(1),rs.getString(2),rs.getDouble(3));
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}
	
	public static Student getStudent(Connection conn, int id) {
		Student student = null;
		
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("Select * from student where id="+id);
			student = new Student(rs.getInt(1),rs.getString(2),rs.getDouble(3));
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return student;
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, ParserConfigurationException, TransformerException {
		socket = new ServerSocket(port);
		Socket client = socket.accept();
		System.out.println("accepted client");
		
		Student student = null;
		Connection conn = connectToDatabase("root","Hiapro123");
		DataInputStream in = new DataInputStream(client.getInputStream());
		String getXML = in.readUTF();
		student = Doc2Object.XMLtoStudent(getXML);
		if(addStudent(conn, student.getId(), student.getName(), student.getGrade()))
			System.out.println("student has been added.");
		else
			System.out.println("add student failed");
		
		DataOutputStream out = new DataOutputStream(client.getOutputStream());
		List<Student> students = getStudents(conn);
		for(Student stud: students) {
			System.out.println(stud);
		}
		String setXML = Object2Doc.convertObjects2Doc(students);
		out.writeUTF(setXML);
		out.flush();
		System.out.println("sent");
	}

}
