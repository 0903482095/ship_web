package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	static final String url = "jdbc:mysql://localhost:3306/btlweb?useUnicode=true&characterEncoding=utf-8";
	static final String user = "root";
	static final String password = "hoanghoi11123";

	public static Connection connect() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, user, password);
			return connection;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		if(connect() != null) {
			System.out.println("ket noi thanh cong!!!");
		} else {
			System.out.println("ket noi that bai!!!");
		}
	}

}
