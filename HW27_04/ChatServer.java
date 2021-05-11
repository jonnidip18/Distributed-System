package HW27_04;

import java.net.*;
import java.io.*;

public class ChatServer {
	private ServerSocket server = null;
	private ChatServerThread client = null;

	public ChatServer(int port) {
		try {
			System.out.println("Binding to port " + port + ", please wait  ...");
			server = new ServerSocket(port);
			System.out.println("Server started: " + server);

			// listening coming connections
			while (true) {
				System.out.println("Waiting for a client ...");
				addThread(server.accept());
			}
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
	}

	public void addThread(Socket socket) {
		System.out.println("Client accepted: " + socket);
		client = new ChatServerThread(this, socket);
		try {
			client.open();
			client.start();
		} catch (IOException ioe) {
			System.out.println("Error opening thread: " + ioe);
		}
	}

	public static void main(String args[]) {
		ChatServer server = new ChatServer(1999);
	}
}