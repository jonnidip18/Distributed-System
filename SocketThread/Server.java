package SocketThread;

import java.net.*;
import java.util.ArrayList;

import HW27_04.ChatServerThread;

import java.io.*;


public class Server {	
	private ServerThread client = null;
	private ServerSocket server = null;
	public Server(int port) throws IOException {
		server = new ServerSocket(port);
		System.out.println("Server waiting...");
		while (true) {
			System.out.println("Waiting for a client ...");
			addThread(server.accept());
		}
	}
	
	public void addThread(Socket socket) {
		System.out.println("Client accepted: " + socket);
		client = new ServerThread(this, socket);
		try {
			client.open();
			client.start();
		} catch (IOException ioe) {
			System.out.println("Error opening thread: " + ioe);
		}
	}
	
	public static void main(String[] args) throws IOException {
		Server server = new Server(9999);
	}
}
