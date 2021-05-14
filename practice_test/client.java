package practice_test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class client {
	private client() {}
	
	public static void main(String[] args) {
        String host = "localhost";
        try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
            Registry registry = LocateRegistry.getRegistry(host);
            
            
        } catch (IOException ioe) {
			System.out.println("Unexpected exception: " + ioe.getMessage());
		}		
		catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
