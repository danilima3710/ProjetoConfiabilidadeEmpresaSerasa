package Controller;

import java.awt.Toolkit;
import java.util.LinkedHashSet;

import Model.Empresa;
import Model.EmpresaImport;
import Model.EmpresasDAOJSON;
import Model.EmpresasDAOSQLite;

public class ControllerView {
	EmpresasDAOSQLite empresasDAOSQLitedaosqLite = new EmpresasDAOSQLite();
	Empresa empresa = new Empresa();
	EmpresaImport empresaImport = new EmpresaImport(new EmpresasDAOJSON(), new EmpresasDAOSQLite());
	EmpresaController empresaController = new EmpresaController();
	
	public void cadastrarEmpresa(String nomeEmpresa, int qtdNotasPendendtes, int qdtNotasEmitidas) {	
		empresa.setNome(nomeEmpresa);
		empresa.setQntdDebitoPendente(qtdNotasPendendtes);
		empresa.setQtdNotasEmitidas(qdtNotasEmitidas);
		empresa.setScoreEmpresa(50);	
		empresasDAOSQLitedaosqLite.inserir(empresa);
	}
	
	public LinkedHashSet<Empresa> carregaEmpresas(int tipoSelect) {
		LinkedHashSet<Empresa> empresas = new LinkedHashSet<Empresa>();
		empresas = empresasDAOSQLitedaosqLite.getTodasEmpresas(tipoSelect);
		return empresas;
	}

	public boolean importarArquivo(String diretorio, int id) {
		try {
			empresaImport.importarDadosDeUmaEmpresa(diretorio, id);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public Empresa carregaUmaEmpresa (int id) {
		empresa = empresasDAOSQLitedaosqLite.getEmpresa(id);
		return empresa;
	}
	
	public void atualizaEmpresa(Empresa empresa) {
		empresasDAOSQLitedaosqLite.alterar(empresa);
	}
	
	public void deletaEmpresa(Empresa empresa) {
		empresasDAOSQLitedaosqLite.deletar(empresa);
	}
	
	public int calcularRanking(Empresa empresa) {
		return empresaController.calcularScoreEmpresa(empresa);
	}
}
