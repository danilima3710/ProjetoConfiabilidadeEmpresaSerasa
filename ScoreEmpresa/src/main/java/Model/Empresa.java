package Model;

public class Empresa {


	private int ID;
	private String nome;
	private int qtdNotasEmitidas, qntdDebitoPendente;
	private int scoreEmpresa;

	public Empresa(int iD, String nome, int qtdNotasEmitidas, int qntdDebitoPendente, int scoreEmpresa) {
		super();
		ID = iD;
		this.nome = nome;
		this.qtdNotasEmitidas = qtdNotasEmitidas;
		this.qntdDebitoPendente = qntdDebitoPendente;
		this.scoreEmpresa = scoreEmpresa;
	}
	
	public Empresa() {
		super();
	}
	
	@Override
	public String toString() {
		return "Empresa: "+ nome + " Confiabilidade " + scoreEmpresa + "%";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		if (ID != other.ID)
			return false;
		return true;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtdNotasEmitidas() {
		return qtdNotasEmitidas;
	}

	public void setQtdNotasEmitidas(int qtdNotasEmitidas) {
		this.qtdNotasEmitidas = qtdNotasEmitidas;
	}

	public int getQntdDebitoPendente() {
		return qntdDebitoPendente;
	}

	public void setQntdDebitoPendente(int qntdDebitoPendente) {
		this.qntdDebitoPendente = qntdDebitoPendente;
	}

	public int getScoreEmpresa() {
		return scoreEmpresa;
	}

	public void setScoreEmpresa(int scoreEmpresa) {
		this.scoreEmpresa = scoreEmpresa;
	}
}
