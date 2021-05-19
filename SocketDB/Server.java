package SocketDB;

import java.io.*;
import java.net.*;
import java.sql.*;

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
	
	 public static boolean updateDatabase(Connection conn, String name, int age) {
	        String query = "INSERT INTO student(name, id) VALUE (?, ?)";
	        try {
	            PreparedStatement st = conn.prepareStatement(query); // create prepared statement
	            st.setString(1, name);
	            st.setInt(2, age);
	            st.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }

	        return true;
	    }
	 
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		socket = new ServerSocket(port);
		Socket client = socket.accept();
		System.out.println("accepted client");
		Connection conn = connectToDatabase("root","Hiapro123");
		ObjectInputStream in = new ObjectInputStream(client.getInputStream());
		ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
		Student student = (Student) in.readObject();
		updateDatabase(conn, student.getName(), student.getAge());
		System.out.println("student has been added.");
	}

}
