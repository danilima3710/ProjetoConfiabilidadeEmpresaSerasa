package CalculoTest;



import org.junit.Test;

import Controller.EmpresaController;
import Model.Empresa;
import junit.framework.Assert;

public class EmpresaControllerTest {

	/* O caso testa a situa��o onde � c�lculado a confiabilidade da 
	empresa quando n�o tem nenhum valor em notas emitidas e d�bitos pendentes*/
	@Test
	public void calcularScoreEmpresaTest1() {
		EmpresaController empresaController = new EmpresaController();
		Empresa empresa = new Empresa();
		empresa.setScoreEmpresa(60);
		empresa.setQntdDebitoPendente(0);
		empresa.setQtdNotasEmitidas(0);
		int score = empresaController.calcularScoreEmpresa(empresa);
		Assert.assertEquals(60, score);		
	}
	
	/* O caso testa a situa��o onde � c�lculado a confiabilidade da 
	empresa quando n�o tem nenhum valor em notas emitidas e com 100 d�bitos pendentes*/
	@Test
	public void calcularScoreEmpresaTest2() {
		EmpresaController empresaController = new EmpresaController();
		Empresa empresa = new Empresa();
		empresa.setScoreEmpresa(60);
		empresa.setQntdDebitoPendente(100);
		empresa.setQtdNotasEmitidas(0);
		int score = empresaController.calcularScoreEmpresa(empresa);
		Assert.assertEquals(24, score);		
	}
	
	/* O caso testa a situa��o onde � c�lculado a confiabilidade da 
	empresa quando se tem 100 notas emitidas e nenhum d�bitos pendentes*/
	@Test
	public void calcularScoreEmpresaTest3() {
		EmpresaController empresaController = new EmpresaController();
		Empresa empresa = new Empresa();
		empresa.setScoreEmpresa(60);
		empresa.setQntdDebitoPendente(0);
		empresa.setQtdNotasEmitidas(100);
		int score = empresaController.calcularScoreEmpresa(empresa);
		Assert.assertEquals(100, score);		
	}
	
	/* O caso testa a situa��o onde � c�lculado a confiabilidade da 
	empresa quando se tem 10 notas emitidas e 10 d�bitos pendentes*/
	@Test
	public void calcularScoreEmpresaTest4() {
		EmpresaController empresaController = new EmpresaController();
		Empresa empresa = new Empresa();
		empresa.setScoreEmpresa(60);
		empresa.setQntdDebitoPendente(10);
		empresa.setQtdNotasEmitidas(10);
		int score = empresaController.calcularScoreEmpresa(empresa);
		Assert.assertEquals(50, score);		
	}
	
	

}
