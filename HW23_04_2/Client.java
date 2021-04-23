package HW23_04_2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String args[]) {
		try {
			String serverName = "localhost";
			int serverPort = 1999;
			
			System.out.println("Establishing connection. Please wait ...");
			Socket socket = new Socket(serverName, serverPort);
			System.out.println("Connected: " + socket);

			BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
			DataOutputStream streamOut = new DataOutputStream(socket.getOutputStream());

			String line = "";
			while (!line.equals(".bye")) {
				try {
					// read data from users
					line = console.readLine();

					// send to server
					streamOut.writeUTF(line);
					streamOut.flush();
				} catch (IOException ioe) {
					System.out.println("Sending error: " + ioe.getMessage());
				}
			}

			console.close();
			streamOut.close();
			socket.close();
		} catch (UnknownHostException uhe) {
			System.out.println("Host unknown: " + uhe.getMessage());
		} catch (IOException ioe) {
			System.out.println("Unexpected exception: " + ioe.getMessage());
		}

	}
}
