
import java.sql.*;

import java.util.Scanner;

public class Program {

	public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	public static final String CONNECTION_STRING = "jdbc:mysql://localhost/world?user=root&password=admin";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName(DRIVER_NAME);

		try (Connection connect = DriverManager.getConnection(CONNECTION_STRING)) {

			CallableStatement sp = connect.prepareCall("call countCity(?)");
			// Можем выставить параметры
			// sp.set...
			
			sp.execute();
			
			// OUT или INOUT параметры можем обрабатывать
			
			int count = sp.getInt(1);
			
			System.out.printf("Всего городов: %s\n", count);
			
			Scanner sc = new Scanner(System.in);
			System.out.print("Введите строку запроса: ");
			String search = sc.nextLine();
			System.out.println("");

			/*
			 * BAD - SQL injection Statement cmd = connect.createStatement(); String sql =
			 * "select Name, District, Population from world.city where Name like '%" +
			 * search + "%' order by Name"; ResultSet result = cmd.executeQuery(sql);
			 */

			String sql = "select Name, District, Population from world.city where Name like ? order by Name";
			PreparedStatement cmd = connect.prepareStatement(sql);
			cmd.setString(1, "%" + search + "%");
			ResultSet result = cmd.executeQuery();

			while (result.next()) {

				String name = result.getString("Name");
				String district = result.getString("District");
				int population = result.getInt(3);
				
				if(!result.wasNull())
					System.out.printf("%-25s | %-25s | %d\n", name, district, population);
				else
					System.out.printf("%-25s | %-25s\n", name, district);
			}
			result.close();
			sc.close();
		}

	}

}
