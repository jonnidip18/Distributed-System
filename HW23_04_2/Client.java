package HW23_04_2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Client {
	public static void main(String args[]) {
		try {
			String serverName = "localhost";
			int serverPort = 1998;
			
			System.out.println("Establishing connection. Please wait ...");
			Socket socket = new Socket(serverName, serverPort);
			System.out.println("Connected: " + socket);

			BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
			DataOutputStream streamOut = new DataOutputStream(socket.getOutputStream());

			String line = "";
			try {
				File file = new File("D:/Study/Distributed System/Distributed-System/HW23_04_2/advertising.csv");
				Scanner reader = new Scanner(file);
				while(reader.hasNextLine()) {
					String data = reader.nextLine();
					StringTokenizer tokens = new StringTokenizer(data,",");
					String TV = tokens.nextToken();
					String Radio = tokens.nextToken();
					String Newspaper = tokens.nextToken();
					String sales = tokens.nextToken();
					// send to server
					streamOut.writeUTF(TV +" , "+ Radio +" , "+ Newspaper +" , "+ sales);
					streamOut.flush();
				}
			} catch (IOException ioe) {
				System.out.println("Sending error: " + ioe.getMessage());
			}
			streamOut.writeUTF(".bye");
			streamOut.flush();
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
