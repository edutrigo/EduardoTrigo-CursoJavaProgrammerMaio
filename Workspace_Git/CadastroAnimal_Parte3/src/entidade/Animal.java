package entidade;

public abstract class Animal {
	// Variaveis PRIVADAS
	private String nome;
	private Integer caf; // cadastro animal fisico
	private Double preco;
	private Endereco endereco;

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	// CALCULA PRECO GENERICO ANIMAL
	public Double calcularPreco(int peso) {
		return peso * 100.0;
	}

}
