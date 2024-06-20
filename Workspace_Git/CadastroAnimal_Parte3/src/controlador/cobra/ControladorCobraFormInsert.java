package controlador.cobra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.Cachorro;
import entidade.Cobra;
import manipulaArq.ManipulaArquivo;
import repositorio.cobra.CobraRepositorioImplementacao;
import servico.client.EnderecoCliente;

public class ControladorCobraFormInsert implements ActionListener {

	JTextField campo_01;
	JTextField campo_02;
	JTextField campo_03;
	JTextField campo_04;
	JTextField campo_05;

	CobraRepositorioImplementacao cobraRepositorioImplemetacao = new CobraRepositorioImplementacao();

	// Construtor
	public ControladorCobraFormInsert(JTextField campo_01, JTextField campo_02, JTextField campo_03,
			JTextField campo_04, JTextField campo_05) {
		this.campo_01 = campo_01;
		this.campo_02 = campo_02;
		this.campo_03 = campo_03;
		this.campo_04 = campo_04;
		this.campo_05 = campo_05;
	}

	// POPULA CACHORRO
	public Cobra populaCobra() {

		Cobra cobra = new Cobra();
		EnderecoCliente enderecoCliente = new EnderecoCliente(); // OBJETO DO API

		cobra.setNome(campo_01.getText());
		cobra.setCaf(Integer.parseInt(campo_02.getText()));
		cobra.setTipoVeneno(campo_03.getText());

		try {
			cobra.setEndereco(enderecoCliente.buscarEnderecoPeloCep(campo_05.getText()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cobra;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (campo_01.getText().equals("")) {

			JOptionPane.showMessageDialog(null, "Campo 'NOME' não pode ficar" + "\n" + "em branco!");

		} else if (campo_02.getText().equals("")) {

			JOptionPane.showMessageDialog(null, "Campo 'CAF' não pode ficar" + "\n" + "em branco!");

		} else if (campo_03.getText().equals("")) {

			JOptionPane.showMessageDialog(null, "Campo 'Tipo Veneno' não pode ficar" + "\n" + "em branco!");

		} else if (campo_04.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Campo 'Peso' não pode ficar" + "\n" + "em branco!");

		} else if (campo_05.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Campo 'CEP' não pode ficar" + "\n" + "em branco!");

		} else {
			Cobra populaCobra = populaCobra();

			int confirmacao = JOptionPane.showConfirmDialog(null,
					"Confirma os dados:" + "\n" + populaCobra.getNome() + "\n" + populaCobra.getCaf() + "\n"
							+ populaCobra.getEndereco().getBairro() + "\n" + populaCobra.getEndereco().getLocalidade()
							+ "\n" + populaCobra.getEndereco().getLogradouro() + "\n"
							+ populaCobra.getEndereco().getUf() + "\n");

			if (confirmacao == 0) {
				// SALVA COBRA EM ARQUIVO
				ManipulaArquivo regCobra = new ManipulaArquivo();
				regCobra.InsereCobra(populaCobra);

				// SALVE EM BANCO DE DADOS - ATRAVES DA INTERFACE
				if (cobraRepositorioImplemetacao.saveCobraBD(populaCobra, campo_04.getText())) {
					JOptionPane.showMessageDialog(null, "Cadastro de Cobra" + "\n" + "efetuado com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao registrar Cobra..." + "\n" + "Processo cancelado.!");
				}
			}
		}
	}
}
