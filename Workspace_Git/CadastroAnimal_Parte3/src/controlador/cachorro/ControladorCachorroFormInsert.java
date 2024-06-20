package controlador.cachorro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.Cachorro;
import manipulaArq.ManipulaArquivo;
import repositorio.cachorro.CachorroRepositorioImplementacao;
import servico.client.EnderecoCliente;

public class ControladorCachorroFormInsert implements ActionListener {

	JTextField campo_01;
	JTextField campo_02;
	JTextField campo_03;
	JTextField campo_04;
	JTextField campo_05;

	CachorroRepositorioImplementacao cachorroRepositorio = new CachorroRepositorioImplementacao();

	// Construtor
	public ControladorCachorroFormInsert(JTextField campo_01, JTextField campo_02, JTextField campo_03,
			JTextField campo_04, JTextField campo_05) {
		this.campo_01 = campo_01;
		this.campo_02 = campo_02;
		this.campo_03 = campo_03;
		this.campo_04 = campo_04;
		this.campo_05 = campo_05;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (campo_01.getText().equals("")) {

			JOptionPane.showMessageDialog(null, "Campo 'NOME' não pode ficar" + "\n" + "em branco!");

		} else if (campo_02.getText().equals("")) {

			JOptionPane.showMessageDialog(null, "Campo 'CAF' não pode ficar" + "\n" + "em branco!");

		} else if (campo_03.getText().equals("")) {

			JOptionPane.showMessageDialog(null, "Campo 'CorPelo' não pode ficar" + "\n" + "em branco!");

		} else if (campo_04.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Campo 'Peso' não pode ficar" + "\n" + "em branco!");

		} else if (campo_05.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Campo 'CEP' não pode ficar" + "\n" + "em branco!");

		} else {

			Cachorro populaCachorro = populaCachorro();

			int confirmacao = JOptionPane.showConfirmDialog(null, "Confirma os dados:" + "\n" + populaCachorro.getNome()
					+ "\n" + populaCachorro.getCaf() + "\n" + populaCachorro.getEndereco().getBairro() + "\n"
					+ populaCachorro.getEndereco().getLocalidade() + "\n" + populaCachorro.getEndereco().getLogradouro()
					+ "\n" + populaCachorro.getEndereco().getUf() + "\n");

			if (confirmacao == 0) {
				// SALVA RM ARQUIVO
				ManipulaArquivo regCachorro = new ManipulaArquivo();
				regCachorro.InsereCachorro(populaCachorro);

				// SALVE EM BANCO DE DADOS - ATRAVES DA INTERFACE
				if (cachorroRepositorio.saveCachorroBD(populaCachorro, campo_04.getText())) {
					JOptionPane.showMessageDialog(null, "Cadastro de Cachorro" + "\n" + "efetuado com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null,
							"Erro ao registrar Cachorro..." + "\n" + "Processo cancelado.!");
				}
			}
		}
	}

	public Cachorro populaCachorro() {

		Cachorro cachorro = new Cachorro();
		EnderecoCliente enderecoCliente = new EnderecoCliente();

		cachorro.setNome(campo_01.getText());
		cachorro.setCaf(Integer.parseInt(campo_02.getText()));
		cachorro.setCorPelo(campo_03.getText());

		try {
			cachorro.setEndereco(enderecoCliente.buscarEnderecoPeloCep(campo_05.getText()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cachorro;
	}

}
