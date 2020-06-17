package Model;

public class EmpresaTable {

	public static String getSQLCreate() {
		StringBuilder sql = new StringBuilder();
		sql.append(" CREATE TABLE IF NOT EXISTS empresa (");
		sql.append(" ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,");
		sql.append(" nomeEmpresa VARCHAR (50) NOT NULL,");
		sql.append(" qntdDebitoPendente INTEGER NOT NULL,");
		sql.append(" qntdNotasEmitidas INTEGER NOT NULL,");
		sql.append(" scoreEmpresa INTEGER NOT NULL)");
		return sql.toString();
	}

}
