package HW27_04;

import java.net.*;
import java.util.ArrayList;
import java.io.*;

public class ChatServerThread extends Thread {
	private Socket socket = null;
	private ChatServer server = null;
	private int ID;
	private DataInputStream streamIn = null;
	private DataOutputStream streamOut = null;
	ArrayList<Socket> socketList;

	public ChatServerThread(ChatServer server, Socket socket) {
		this.server = server;
		this.socket = socket;
		this.ID = socket.getPort();
	}
	
	public void run() {
		System.out.println("Server Thread " + ID + " running.");
		while (true) {
			try {
				String line = streamIn.readUTF();
				System.out.println(line);
				streamOut.writeUTF(line);
				streamOut.flush();
			} catch (IOException ioe) {
			}
		}
	}

	public void open() throws IOException {
		streamIn = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
		streamOut = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
	}

	public void close() throws IOException {
		if (socket != null)
			socket.close();
		if (streamIn != null)
			streamIn.close();
		if (streamOut != null)
			streamOut.close();
	}
}