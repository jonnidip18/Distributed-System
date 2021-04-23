package HW23_04_2;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String args[]) {
		try {
			int port = 1998;
			
			ServerSocket server = new ServerSocket(port);
			System.out.println("Server started: " + server);
			System.out.println("Waiting for a client ...");

			Socket socket = server.accept();
			System.out.println("Client accepted: " + socket);

			// open stream
			DataInputStream streamIn = new DataInputStream(socket.getInputStream());

			boolean done = false;
			while (!done) {
				try {
					// read data from client
					String line = streamIn.readUTF();
					System.out.println(line);

					// check if the program is over.
					done = line.equals(".bye");
				} catch (IOException ioe) {
					done = true;
				}
			}

			streamIn.close();
			socket.close();
			server.close();
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
	}
}
