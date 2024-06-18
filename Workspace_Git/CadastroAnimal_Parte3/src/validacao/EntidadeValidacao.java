package validacao;

public class EntidadeValidacao {

	// VALIDA SE O "PESO" FOI DIGITADO SOMENTE NÚMEROS
	public Integer validaPeso(String pesoString) {

		int pesoInt;
		try {
			pesoInt = Integer.parseInt(pesoString);
		} catch (Exception e) {
			return null;
		}
		return pesoInt;
	}
}