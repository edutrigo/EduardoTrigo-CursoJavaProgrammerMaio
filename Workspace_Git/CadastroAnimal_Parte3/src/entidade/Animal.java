package entidade;

public abstract class Animal {
	// Variaveis PRIVADAS
	private String nome;
	private Integer caf; // cadastro animal fisico

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCaf() {
		return caf;
	}

	public void setCaf(Integer caf) {
		this.caf = caf;
	}

}
