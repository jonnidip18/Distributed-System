package practice_test;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Statement;

public class Server {
	public Server() {}
	
	public account getAccount(String user, String pass) throws RemoteException{
		try {
			String url = "jdbc:mysql://localhost:3306/database1";
			Connection con = DriverManager.getConnection(url,"root","Hiapro123");
			String query = "select * from account where " + user + "=username and " + pass + "=password";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			account acc = new account(rs.getString(1),rs.getString(2));		
			con.close();
			return acc;
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		try {
			Server obj = new Server();
			Registry registry = LocateRegistry.getRegistry();
			
		}
		catch(Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
		}
	}
}
