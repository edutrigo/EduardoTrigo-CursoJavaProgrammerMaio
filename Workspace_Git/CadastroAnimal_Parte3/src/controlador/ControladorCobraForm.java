package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.Cobra;
import manipulaArq.ManipulaArquivo;
import repositorio.CobraRepositorioImplemetacao;

public class ControladorCobraForm implements ActionListener {

	JTextField campo_01;
	JTextField campo_02;
	JTextField campo_03;

	CobraRepositorioImplemetacao cobraRepositorioImplemetacao = new CobraRepositorioImplemetacao();

	// Construtor
	public ControladorCobraForm(JTextField campo_01, JTextField campo_02, JTextField campo_03) {
		this.campo_01 = campo_01;
		this.campo_02 = campo_02;
		this.campo_03 = campo_03;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (campo_01.getText().equals("")) {

			JOptionPane.showMessageDialog(null, "Campo 'NOME' não pode ficar" + "\n" + "em branco!");

		} else if (campo_02.getText().equals("")) {

			JOptionPane.showMessageDialog(null, "Campo 'CAF' não pode ficar" + "\n" + "em branco!");

		} else if (campo_03.getText().equals("")) {

			JOptionPane.showMessageDialog(null, "Campo 'Tipo Veneno' não pode ficar" + "\n" + "em branco!");

		} else {
			Cobra cobra = new Cobra();

			cobra.setNome(campo_01.getText());
			cobra.setCaf(Integer.parseInt(campo_02.getText()));
			cobra.setTipoVeneno(campo_03.getText());

			// SALVA COBRA EM ARQUIVO
			ManipulaArquivo regCobra = new ManipulaArquivo();
			regCobra.InsereCobra(cobra);

			// SALVA EM BANCO DE DADOS - USANDO INTERFACE
			cobraRepositorioImplemetacao.saveCobraBD(cobra);

			JOptionPane.showMessageDialog(null, "Cadastro de Cobra" + "\n" + "efetuado com sucesso!");
		}
	}
}
