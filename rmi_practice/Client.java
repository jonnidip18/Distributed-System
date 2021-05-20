package rmi_practice;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;

public class Client {

	public static void main(String[] args) {
		try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
            ServerService stub = (ServerService) registry.lookup("ServerService"); // same name when server register to RMI server
            System.out.println("Client ready");
            stub.addBook("haha","hihi");
            stub.addNewspaper("hahi","hiha");
            System.out.println("sended");
            List<Book> books = stub.getBook();
            for(Book b : books) {
            	System.out.println("Name: " + b.getName() + "\tAuthor: " + b.getAuthor());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
