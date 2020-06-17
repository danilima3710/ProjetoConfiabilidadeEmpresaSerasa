package Model;

import java.util.ArrayList;

public class EmpresaImport {
	
	private EmpresasDAOJSON empresasDAODJSON = null;
	private EmpresasDAOSQLite empresasDAOSQLite = null;
	
	public EmpresaImport(EmpresasDAOJSON empresasDAODJSON, EmpresasDAOSQLite empresasDAOSQLite) {
		super();
		this.empresasDAODJSON = empresasDAODJSON;
		this.empresasDAOSQLite = empresasDAOSQLite;
	}

	public void importarDadosEmpresas(String nomeArquivo) {
		empresasDAODJSON.setNomeArquivoJSON(nomeArquivo);
		ArrayList<Empresa> arrayEmpresas = empresasDAODJSON.getEmpresas();
		for (Empresa empresaJSON : arrayEmpresas) {
			Empresa empresaDB = empresasDAOSQLite.getEmpresa(empresaJSON.getID());
			if (empresaDB != null) {
				empresaDB.setQntdDebitoPendente(empresaJSON.getQntdDebitoPendente());
				empresaDB.setQtdNotasEmitidas(empresaJSON.getQtdNotasEmitidas());
				empresasDAOSQLite.alterar(empresaDB);
			}
		}
	}
	
	public void importarDadosDeUmaEmpresa(String nomeArquivo, int id) {
		empresasDAODJSON.setNomeArquivoJSON(nomeArquivo);
		ArrayList<Empresa> arrayEmpresas = empresasDAODJSON.getEmpresas();
		for (Empresa empresaJSON : arrayEmpresas) {
			Empresa empresaDB = empresasDAOSQLite.getEmpresa(id);
			if (empresaDB != null) {
				empresaDB.setQntdDebitoPendente(empresaJSON.getQntdDebitoPendente());
				empresaDB.setQtdNotasEmitidas(empresaJSON.getQtdNotasEmitidas());
				if(empresaDB.getID() == empresaJSON.getID()) {
					empresasDAOSQLite.alterar(empresaDB);
				}
			}
		}
		
		
	}
}
