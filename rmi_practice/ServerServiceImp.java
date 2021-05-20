package rmi_practice;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
		
	}
}
