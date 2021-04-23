package HW23_04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Copy {
	public static void main(String[] args) {
		try {
			File file = new File("src/HW23_04/names.txt");
			Scanner reader = new Scanner(file);
			FileWriter writer = new FileWriter("src/HW23_04/names_cp.txt");
			while (reader.hasNextLine()){
				String data = reader.nextLine();
				System.out.println(data);
				writer.write(data+"\n");
				System.out.println("write success");
			}
			reader.close();
			writer.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("An error occurred");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
}
