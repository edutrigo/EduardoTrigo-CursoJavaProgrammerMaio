package controlador.cachorro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.Cachorro;
import manipulaArq.ManipulaArquivo;
import repositorio.cachorro.CachorroRepositorioImplementacao;

public class ControladorCachorroFormInsert implements ActionListener {

	JTextField campo_01;
	JTextField campo_02;
	JTextField campo_03;

	CachorroRepositorioImplementacao cachorroRepositorio = new CachorroRepositorioImplementacao();

	// Construtor
	public ControladorCachorroFormInsert(JTextField campo_01, JTextField campo_02, JTextField campo_03) {
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

			JOptionPane.showMessageDialog(null, "Campo 'CorPelo' não pode ficar" + "\n" + "em branco!");

		} else {
			Cachorro cachorro = new Cachorro();

			cachorro.setNome(campo_01.getText());
			cachorro.setCaf(Integer.parseInt(campo_02.getText()));
			cachorro.setCorPelo(campo_03.getText());

			// SALVA RM ARQUIVO
			ManipulaArquivo regCachorro = new ManipulaArquivo();
			regCachorro.InsereCachorro(cachorro);

			// SALVE EM BANCO DE DADOS - ATRAVES DA INTERFACE
			cachorroRepositorio.saveCachorroBD(cachorro);

			JOptionPane.showMessageDialog(null, "Cadastro de Cachorro" + "\n" + "efetuado com sucesso!");
		}
	}
}
