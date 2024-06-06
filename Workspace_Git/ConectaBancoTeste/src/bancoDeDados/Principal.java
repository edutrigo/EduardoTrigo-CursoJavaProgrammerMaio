package bancoDeDados;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {

		DaoPessoa daoPessoa = new DaoPessoa();
		Pessoa pessoa = new Pessoa();

		pessoa.setCpf("001");
		pessoa.setNome("TESTE 001");
		pessoa.setEmail("TESTE001@gmail.com");

		boolean resultado = daoPessoa.SavePessoaBD(pessoa);

		if (resultado) {
			JOptionPane.showMessageDialog(null, "Insert OK no BD");
		} else {
			JOptionPane.showMessageDialog(null, "Insert com ERRO...");
		}
	}
}
