package HW23_04_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class List_Employee {
	public static List<Employee> readData(String fileName){
		List<Employee> employees= new ArrayList<Employee>();
		
		try {
			File file = new File(fileName);
			Scanner reader = new Scanner(file);
			while(reader.hasNextLine()) {
				String data = reader.nextLine();
				StringTokenizer tokens = new StringTokenizer(data,",");
				
				String name = tokens.nextToken();
				double salary = Double.parseDouble(tokens.nextToken());
				
				employees.add(new Employee(name,salary));
			}
			reader.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("error");
			e.printStackTrace();
		}
		return employees;
	}
	
	public static void main(String[] args) {
		List<Employee> list = List_Employee.readData("D:/Study/Distributed System/Distributed-System/HW23_04_1/employees.csv");
		System.out.println(list);
		
		List_Employee.writeData("D:/Study/Distributed System/Distributed-System/HW23_04_1/new_employees.csv",list);
	}
	
	public static void writeData(String fileName, List<Employee> employees) {
		try {
			FileWriter writer = new FileWriter(fileName);
			
			for (Employee employee:employees) {
				String name = employee.getName();
				double salary = employee.getSalary();
				writer.write(name+","+salary+"\n");	
			}
			writer.close();
			System.out.println("write success");
		}
		
		catch (IOException e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
	}
}
