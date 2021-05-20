package rmi_practice;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Server {
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
	public static void main(String[] args) {
		 ServerServiceImp obj = new ServerServiceImp();

	        // Create an stub to store in RMI server
	        try {
	            ServerService stub = (ServerService) UnicastRemoteObject.exportObject(obj, 1099);

	            //  Register stub to RMI server
	            Registry registry = LocateRegistry.createRegistry(1099);
	            registry.bind("ServerService", stub); 
	            // ServerSevice will be the name in RMI server when client will lookup
	            
	            System.out.println("Sever ready");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}

}
