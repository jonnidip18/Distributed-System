package SocketThread;

import java.net.*;
import java.util.ArrayList;
import java.io.*;

public class Client {
	public static void main(String[] args) {
		Socket socket = null;
		String serverName = "localhost";
		int serverPort = 9999;
		DataInputStream in = null;
		
		try {
			socket = new Socket(serverName, serverPort);
			System.out.println("Connected");
			in = new DataInputStream(socket.getInputStream());
			while(true) {
				System.out.println(in.readUTF());
			}
		}
		catch(IOException e){
			System.out.println("Unexpected exception: " + e.getMessage());
		}
	}
}
