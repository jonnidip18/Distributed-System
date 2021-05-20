package rmi_practice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface ServerService extends Remote{
	public void addBook(String name, String author) throws RemoteException;
}
