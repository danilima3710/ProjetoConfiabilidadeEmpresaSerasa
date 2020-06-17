package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionSQLite {

	private static final String DB_NAME = "ScoreEmpresa.DB";
	private static Connection instanceConnection = null;
	private static Statement instanceStatement = null;

	public static Connection getInstanceConnection() {
		if (instanceConnection == null) {
			try {
				instanceConnection = DriverManager.getConnection("jdbc:sqlite:" + DB_NAME);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println(e.getMessage());
			}
		}
		return instanceConnection;
	}

	public static Statement getInstanceStatement() throws SQLException {
		if (instanceStatement == null) {
			instanceStatement = getInstanceConnection().createStatement();
			instanceStatement.setQueryTimeout(30);
		}
		return instanceStatement;

	}

}
