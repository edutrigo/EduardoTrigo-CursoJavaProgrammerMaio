package entity;

public class EntCorrentistaPremium extends EntCorrentista {
	Double LimiteDeCredito;

	public Double getLimiteDeCredito() {
		return LimiteDeCredito;
	}

	public void setLimiteDeCredito(Double limiteDeCredito) {
		LimiteDeCredito = limiteDeCredito;
	}

	// CALCULA ANUIDADE
	@Override
	public Double CalcularAnuidade(int qtdTransacao) {
		return qtdTransacao * 0.7;
	}

}
