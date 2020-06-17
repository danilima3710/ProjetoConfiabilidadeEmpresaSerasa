package Model;

import java.util.LinkedHashSet;

public interface EmpresaDAO {

	public void inserir(Empresa empresa);

	public void deletar(Empresa empresa);

	public void alterar(Empresa empresa);

	public Empresa getEmpresa(int id);

	public LinkedHashSet<Empresa> getTodasEmpresas(int tipoSelect);

}
