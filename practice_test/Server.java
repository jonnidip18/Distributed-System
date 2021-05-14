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
	
	public boolean checkAccount(String user, String pass) throws RemoteException{
		try {
			String url = "jdbc:mysql://localhost:3306/database1";
			Connection con = DriverManager.getConnection(url,"root","Hiapro123");
			PreparedStatement st = con.prepareStatement("SELECT * FROM login WHERE username = ? AND password = ?");
            st.setString(1, user);
            st.setString(2, pass);
            System.out.println(st);
            ResultSet rs = st.executeQuery();
			con.close();

            if (rs.next())
                return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
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
