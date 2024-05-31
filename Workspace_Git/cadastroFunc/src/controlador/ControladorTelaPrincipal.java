package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import interfaceGrafica.TelaGerente;

public class ControladorTelaPrincipal implements ActionListener {

	JTextField opcaoDigitada;
	JFrame frameTelaPrincipalFrame;
	TelaGerente telaGerente = new TelaGerente();

	public ControladorTelaPrincipal(JTextField caixaTextoOpcao, JFrame frameMenuprincipal) {
		this.opcaoDigitada = caixaTextoOpcao;
		this.frameTelaPrincipalFrame = frameMenuprincipal;
	}

	@Override
	public void actionPerformed(ActionEvent eventoBotao) {
		String opcao = opcaoDigitada.getText();

		if (opcao.equals("1") || opcao.equals("2")) {

			switch (opcao) {
				case "1": {
					telaGerente.menuGerente();
					frameTelaPrincipalFrame.setVisible(false);
					System.out.println("Digitou a opçao 1");
					break;
				}
				case "2": {
					System.out.println("Digitou a opçao 2");
					break;
				}
			}

		} else {
			JOptionPane.showMessageDialog(null, "Somente 1 ou 2 é Valido");
		}

	}

}
