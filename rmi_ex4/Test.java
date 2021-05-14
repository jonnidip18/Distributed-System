package rmi_ex4;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class Test {
	public static void main(String args[]) {
		try {
			int result = 0;
			//Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = 
			DriverManager.getConnection("jdbc:mysql://localhost:3306/database1", "root", "Hiapro123");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from student");
			while (rs.next()) {
				System.out.println(rs.getString(1) + "  " + rs.getInt(2));
				result++;
			}

			System.out.println("Numbers of rows: " + result);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
