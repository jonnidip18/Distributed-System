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
            String[][] game = new String[3][3];
			for (int i = 0 ; i < 3 ; i++) {
				for (int j = 0 ; j < 3 ; j++) {
					game[i][j]=" ";
				}
			}
			while (true) {
				System.out.print("Player 'X', enter your move (row[1-3] column[1-3]): ");
				String line = reader.readLine();
				int x,y;
				String[] split = line.split(" ");
				x = Integer.parseInt(split[0]) - 1;
				y = Integer.parseInt(split[1]) - 1;
				if ((x>2) || (y>2) || (x<0) || (y<0)) {
					System.out.println("The input is not valid. Try again...");
					continue;
				}
				if(game[x][y] == " ") {
					game[x][y] = "X";
					System.out.println(" " + game[0][0] + " | " + game[0][1] + " | " + game[0][2]);
					System.out.println("-----------");
					System.out.println(" " + game[1][0] + " | " + game[1][1] + " | " + game[1][2]);
					System.out.println("-----------");
					System.out.println(" " + game[2][0] + " | " + game[2][1] + " | " + game[2][2]);
					if (game[x][0] == "X" && game[x][1] == "X" && game[x][2] == "X") {
						System.out.println("Player 'X' win.");
						break;
					}
					if (game[0][y] == "X" && game[1][y] == "X" && game[2][y] == "X") {
						System.out.println("Player 'X' win.");
						break;
					}
					if ((game[0][0] == "X" && game[1][1] == "X" && game[2][2] == "X")||(game[2][0] == "X" && game[1][1] == "X" && game[0][2] == "X")) {
						System.out.println("Player 'X' win.");
						break;
					}
				}
				else {
					System.out.println("The move at (" + split[0] + "," + split[1] + ") is not valid. Try again...");
					continue;
				}
			}
            
        } catch (IOException ioe) {
			System.out.println("Unexpected exception: " + ioe.getMessage());
		}		
		catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
