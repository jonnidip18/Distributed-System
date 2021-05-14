package practice_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class game {
	private String[][] game = new String[3][3];
	
	public game() {
		for (int i = 0 ; i < 3 ; i++) {
			for (int j = 0 ; j < 3 ; j++) {
				game[i][j]=" ";
			}
		}
	}
	public boolean check_win(String player,int x,int y) {
		if (game[x][0] == player && game[x][1] == player && game[x][2] == player) {
			return true;
		}
		if (game[0][y] == player && game[1][y] == player && game[2][y] == player) {
			return true;
		}
		if ((game[0][0] == player && game[1][1] == player && game[2][2] == player)||(game[2][0] == player && game[1][1] == player && game[0][2] == player)) {
			return true;
		}
		return false;
	}
	
	public boolean play(String player) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.print("Player '"+player+"', enter your move (row[1-3] column[1-3]): ");
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
				game[x][y] = player;
				System.out.println(" " + game[0][0] + " | " + game[0][1] + " | " + game[0][2]);
				System.out.println("-----------");
				System.out.println(" " + game[1][0] + " | " + game[1][1] + " | " + game[1][2]);
				System.out.println("-----------");
				System.out.println(" " + game[2][0] + " | " + game[2][1] + " | " + game[2][2]);
				if (check_win(player,x,y)) {
					System.out.println("Player '"+player+"' win");
					return true;
				}
				else return false;
			}
			else {
				System.out.println("The move at (" + x++ + "," + y++ + ") is not valid. Try again...");
				continue;
			}
		}
	}
}
