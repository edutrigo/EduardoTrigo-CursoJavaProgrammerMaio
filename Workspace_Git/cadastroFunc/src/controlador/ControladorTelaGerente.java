package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import interfaceGrafica.TelaCadastroGerente;

public class ControladorTelaGerente implements ActionListener {

	JTextField opcapMenuGerente;
	JFrame frameMenuGerente;
	
	TelaCadastroGerente cadastroGerente = new TelaCadastroGerente();
	
	
	
	public ControladorTelaGerente(JTextField opcapMenuGerente, JFrame frameMenuGerente) {
		this.opcapMenuGerente = opcapMenuGerente;
		this.frameMenuGerente = frameMenuGerente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String opcao = opcapMenuGerente.getText();

		if (opcao.equals("1") || opcao.equals("2")) {

			switch (opcao) {
				case "1": {
					cadastroGerente.formularioGerente();
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
