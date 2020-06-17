package Controller;

import java.util.LinkedHashSet;

import Model.Empresa;
import Model.EmpresasDAOSQLite;

public class EmpresaController {
	private double score;

	public int calcularScoreEmpresa(Empresa empresa) {
		score = empresa.getScoreEmpresa();

		for (int i = 1; i <= empresa.getQtdNotasEmitidas(); i++) {
			score += score * 0.02;
			score = (int) Math.floor(score);
		}

		for (int i = 1; i <= empresa.getQntdDebitoPendente(); i++) {
			score -= score * 0.04;
			score = (int) Math.ceil(score);
		}

		if (score > 100) {
			return 100;
		}

		if (score < 1) {
			return 1;
		}
		return (int) score;
	}

	public LinkedHashSet<Empresa> listarRanking() {
		EmpresasDAOSQLite empresasDAOSQLite = new EmpresasDAOSQLite();
		LinkedHashSet<Empresa> empresas = empresasDAOSQLite.getTodasEmpresas(1);
		return empresas;
	}

}
