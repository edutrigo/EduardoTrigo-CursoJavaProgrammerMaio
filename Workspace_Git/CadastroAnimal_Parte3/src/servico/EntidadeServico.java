package servico;

import javax.swing.JOptionPane;

import entidade.Cachorro;
import validacao.EntidadeValidacao;

public class EntidadeServico {

	// CAPTURA O PRECO DO CACHORRO
	public Double buscaPrecoCachorro(String peso) {
		Cachorro cachorro = new Cachorro();
		EntidadeValidacao entidadeValidacao = new EntidadeValidacao();

		if (entidadeValidacao.validaPeso(peso) == null) {
			JOptionPane.showMessageDialog(null, "O peso " + peso + " não é valido...");
		} else {
			return cachorro.calcularPreco(entidadeValidacao.validaPeso(peso));
		}
		return null;
	}
}