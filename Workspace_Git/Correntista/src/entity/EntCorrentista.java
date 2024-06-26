package entity;

public abstract class EntCorrentista {
	private String nome;
	private String cpf;
	private EntEndereco endereco;
	private String email;
	private int qtdTransacao;
	private Double valorAnuidade;

	// CALCULA ANUIDADE
	public Double CalcularAnuidade(int qtdTransacao) {
		return qtdTransacao * 0.5;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public EntEndereco getEndereco() {
		return endereco;
	}

	public void setEndereco(EntEndereco endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getQtdTransacao() {
		return qtdTransacao;
	}

	public void setQtdTransacao(int qtdTransacao) {
		this.qtdTransacao = qtdTransacao;
	}

	public Double getValorAnuidade() {
		return valorAnuidade;
	}

	public void setValorAnuidade(Double valorAnuidade) {
		this.valorAnuidade = valorAnuidade;
	}
}
