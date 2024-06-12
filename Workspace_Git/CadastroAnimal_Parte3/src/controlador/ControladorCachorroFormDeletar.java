package controlador;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import repositorio.CachorroRepositorioImplementacao;

public class ControladorCachorroFormDeletar implements ActionListener {

	TextField cafRecebido;
	JFrame frameDeletar;
	CachorroRepositorioImplementacao cachorroRepositorioImplementacao = new CachorroRepositorioImplementacao();

	public ControladorCachorroFormDeletar(TextField cafRecebido, JFrame frameDeletar) {
		this.cafRecebido = cafRecebido;
		this.frameDeletar = frameDeletar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (cachorroRepositorioImplementacao.delCachorroBD(cafRecebido.getText())) {
			JOptionPane.showMessageDialog(null, "O cachorro de CAF " + cafRecebido.getText() + " Foi deletado...");
			frameDeletar.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(null, "O cachorro de CAF " + cafRecebido.getText() + " Não foi deletado...");
		}

	}

}
