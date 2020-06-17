package Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseProvider {

	private Connection connection;
	private Statement statement;

	public void conectDataBase() {
		try {
			connection = ConnectionSQLite.getInstanceConnection();
			statement = ConnectionSQLite.getInstanceStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		createDataBase();
	}

	private void createDataBase() {
		try {
			// statement.executeQuery(EmpresaTable.getSQLCreate());
			statement.execute(EmpresaTable.getSQLCreate());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void disconectDataBase() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
