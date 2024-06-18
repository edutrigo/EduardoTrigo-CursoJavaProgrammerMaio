package entidade;

public class Cachorro extends Animal {
	private String CorPelo;

	public String getCorPelo() {
		return CorPelo;
	}

	public void setCorPelo(String corPelo) {
		CorPelo = corPelo;
	}

	// CALCULA PRECO ESPECIFICO CACHORRRO
	@Override 
	public Double calcularPreco(int peso) {
		return peso * 120.0;
	}

}
