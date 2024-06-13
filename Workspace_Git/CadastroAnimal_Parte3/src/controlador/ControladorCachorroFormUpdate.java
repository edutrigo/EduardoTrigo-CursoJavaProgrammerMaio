package controlador;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import entidade.Cachorro;
import repositorio.CachorroRepositorioImplementacao;

public class ControladorCachorroFormUpdate implements ActionListener {

	TextField campo_01; // CAF
	JFrame frameTela;

	CachorroRepositorioImplementacao cachorroRepositorio = new CachorroRepositorioImplementacao();

	// Construtor
	public ControladorCachorroFormUpdate(TextField campo_01, JFrame frameTela) {
		this.campo_01 = campo_01; // CAF
		this.frameTela = frameTela;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Cachorro cachorro = new Cachorro();

		cachorro = cachorroRepositorio.buscaCachorroPorCaf(campo_01.getText());

		if (cachorro == null) {
			JOptionPane.showMessageDialog(null, "CAF para Cachorro não encontrado! > " + campo_01.getText() );
		} else {

			frameTela.setVisible(false);
			JOptionPane.showMessageDialog(null, "CHAMAR AQUI A TELA PRA FAZER ALTERACAO");
		}
	}
}
