package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashSet;

public class EmpresasDAOSQLite implements EmpresaDAO {

	public void inserir(Empresa empresa) {
		Statement statement;

		try {
			statement = ConnectionSQLite.getInstanceStatement();
			StringBuilder xSQLQuery = new StringBuilder();
			xSQLQuery.append("insert into empresa (nomeEmpresa, qntdDebitoPendente, qntdNotasEmitidas, scoreEmpresa)");
			xSQLQuery.append("values (");
			xSQLQuery.append("\"" + empresa.getNome() + "\", ");
			xSQLQuery.append(empresa.getQntdDebitoPendente() + ", ");
			xSQLQuery.append(empresa.getQtdNotasEmitidas() + ",");
			xSQLQuery.append(empresa.getScoreEmpresa() + ")");
			statement.execute(xSQLQuery.toString());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deletar(Empresa empresa) {
		Statement statement;
		try {
			statement = ConnectionSQLite.getInstanceStatement();
			String xSQLDelete = "delete from empresa where ID = " + empresa.getID();
			statement.execute(xSQLDelete);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void alterar(Empresa empresa) {
		Statement statement;
		try {
			statement = ConnectionSQLite.getInstanceStatement();
			StringBuilder xSQLUpdate = new StringBuilder();
			xSQLUpdate.append("update empresa set nomeEmpresa = \"" + empresa.getNome() + "\",");
			xSQLUpdate.append("qntdDebitoPendente = " + empresa.getQntdDebitoPendente() + ",");
			xSQLUpdate.append("qntdNotasEmitidas = " + empresa.getQtdNotasEmitidas() + ",");
			xSQLUpdate.append("scoreEmpresa = " + empresa.getScoreEmpresa());
			xSQLUpdate.append(" where ID = " + empresa.getID());
			statement.execute(xSQLUpdate.toString());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Empresa getEmpresa(int id) {
		Statement statement;
		try {
			statement = ConnectionSQLite.getInstanceStatement();
			ResultSet rs = statement.executeQuery("select * from empresa where id = " + id);

			if (rs.next()) {
				Empresa empresa = new Empresa();
				empresa.setID(rs.getInt("ID"));
				empresa.setNome(rs.getString("nomeEmpresa"));
				empresa.setQntdDebitoPendente(rs.getInt("qntdDebitoPendente"));
				empresa.setQtdNotasEmitidas(rs.getInt("qntdNotasEmitidas"));
				empresa.setScoreEmpresa(rs.getInt("scoreEmpresa"));
				return empresa;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public LinkedHashSet<Empresa> getTodasEmpresas(int tipoSelect) {
		LinkedHashSet<Empresa> empresas = new LinkedHashSet<Empresa>();
		Statement statement;
		try {
			statement = ConnectionSQLite.getInstanceStatement();
			String query = "select * from empresa ";
			if (tipoSelect == 0) {
				query = query + "";
			}else {
				if (tipoSelect == 1) {
					query = query + " order by scoreEmpresa desc";
				}else{
					if (tipoSelect == 2) {
						query = query + " order by qntdNotasEmitidas desc";
					}else {
						if (tipoSelect == 3) {
							query = query + " order by qntdDebitoPendente desc";
						}else {
							if (tipoSelect == 4) {
								query = query + " order by ID asc";
							}
						}
					}
				}
			}
			ResultSet rs = statement.executeQuery(query);
			
			while (rs.next()) {
				Empresa empresa = new Empresa();
				empresa.setID(rs.getInt("ID"));
				empresa.setNome(rs.getString("nomeEmpresa"));
				empresa.setQntdDebitoPendente(rs.getInt("qntdDebitoPendente"));
				empresa.setQtdNotasEmitidas(rs.getInt("qntdNotasEmitidas"));
				empresa.setScoreEmpresa(rs.getInt("scoreEmpresa"));
				empresas.add(empresa);
			}
			
			for (Empresa empresa : empresas) {
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empresas;
	}

}
