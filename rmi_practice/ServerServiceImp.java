package rmi_practice;

import java.rmi.RemoteException;
import java.sql.*;
import java.util.*;

public class ServerServiceImp implements ServerService{
	public ServerServiceImp() {}
	
	public static Connection connectToDB(String user, String pass) {
		// connect to database
        String databaseUrl = "jdbc:mysql://localhost:3306/database1?user=" + user + "&password=" + pass;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(databaseUrl);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return conn;
	}
	
	@Override
	public void addBook(String name, String author) throws RemoteException {
		Connection conn = connectToDB("root","Hiapro123");
		String query = "INSERT INTO Book(name, author) VALUE (?, ?)";
        try {
            PreparedStatement st = conn.prepareStatement(query); // create prepared statement
            st.setString(1, name);
            st.setString(2, author);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("added book");
	}

	@Override
	public void addNewspaper(String name, String type) throws RemoteException {
		Connection conn = connectToDB("root","Hiapro123");
		String query = "INSERT INTO Newspaper(name, type) VALUE (?, ?)";
        try {
            PreparedStatement st = conn.prepareStatement(query); // create prepared statement
            st.setString(1, name);
            st.setString(2, type);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("added newspaper");
	}

	@Override
	public List<Book> getBook() throws RemoteException {
		List<Book> books = new ArrayList<>();
		Connection conn = connectToDB("root","Hiapro123");
		String query = "Select * from Book";
		try {
            PreparedStatement st = conn.prepareStatement(query); // create prepared statement
            ResultSet res = st.executeQuery();
            while(res.next()) {
            	books.add(new Book(res.getString("name"),res.getString("author")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return books;
	}
	
}
