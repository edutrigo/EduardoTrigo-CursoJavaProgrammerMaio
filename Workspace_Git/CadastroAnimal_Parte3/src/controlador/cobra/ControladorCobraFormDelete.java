package controlador.cobra;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import repositorio.cobra.CobraRepositorioImplementacao;

public class ControladorCobraFormDelete implements ActionListener {

	TextField cafRecebido;
	JFrame frameDeletar;
	CobraRepositorioImplementacao cobraRepositorioImplementacao = new CobraRepositorioImplementacao();

	public ControladorCobraFormDelete(TextField cafRecebido, JFrame frameDeletar) {
		this.cafRecebido = cafRecebido;
		this.frameDeletar = frameDeletar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (cobraRepositorioImplementacao.delCobraBD(cafRecebido.getText())) {
			JOptionPane.showMessageDialog(null, "A cobra de CAF " + cafRecebido.getText() + " Foi deletada...");
			frameDeletar.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(null, "A cobra de CAF " + cafRecebido.getText() + " Não foi deletada...");
		}

	}

}
