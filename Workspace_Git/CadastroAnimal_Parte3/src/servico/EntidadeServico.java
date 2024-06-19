package servico;

import javax.swing.JOptionPane;

import entidade.Cachorro;
import entidade.Cobra;
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

	// CAPTURA O PRECO DA COBRA
	public Double buscaPrecoCobra(String peso) {
		Cobra cobra = new Cobra();
		EntidadeValidacao entidadeValidacao = new EntidadeValidacao();

		if (entidadeValidacao.validaPeso(peso) == null) {
			JOptionPane.showMessageDialog(null, "O peso " + peso + " não é valido...");
		} else {
			return cobra.calcularPreco(entidadeValidacao.validaPeso(peso));
		}
		return null;
	}

}