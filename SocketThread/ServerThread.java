package SocketThread;

import java.net.*;
import java.io.*;

import HW27_04.ChatServer;

public class ServerThread extends Thread{
	private Server server;
	private Socket socket;
	private DataOutputStream out;
	private int ID;
	
	public ServerThread(Server server, Socket socket) {
		this.server = server;
		this.socket = socket;
		this.ID = socket.getPort();
	}
	
	public void run() {
		System.out.println("Server Thread " + ID + " running.");
		int i = 0;
		while (i<100) {
			try {
				String line = "Hello";
				out.writeUTF(line + i);
				out.flush();
				i++;
			} catch (IOException ioe) {
			}
		}
	}
	
	public void open() throws IOException {
		out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
	}
	
	public void close() throws IOException {
		if (socket != null)
			socket.close();
		if (out != null)
			out.close();
	}
}
