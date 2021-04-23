package HW1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		int serverPort = 1999;
		ServerSocket serverSocket = null;
		ObjectOutputStream toClient = null;
		ObjectInputStream fromClient = null;

		try {
			serverSocket = new ServerSocket(serverPort);
			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println("Just connected to " + socket.getRemoteSocketAddress());

				toClient = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
				fromClient = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
				Student msgRequest = (Student) fromClient.readObject();
				String name = msgRequest.getName();
				String id = msgRequest.getID();
				String dob = msgRequest.getDOB();

				toClient.writeObject(new Student(name, id, dob));
				toClient.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}