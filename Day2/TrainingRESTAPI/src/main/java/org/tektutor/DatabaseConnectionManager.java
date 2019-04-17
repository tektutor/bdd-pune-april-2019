package org.tektutor;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnectionManager {

	private Connection connection = null;

	public Connection getConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection =
				DriverManager.getConnection(
						"jdbc:mysql://localhost/trainings?useSSL=false",
						"root",
						"root**12345"
			);

			System.out.println("connected");
		}
		catch(Exception e) {
			System.out.println(e);
		}

		return connection;
	    }

	}
