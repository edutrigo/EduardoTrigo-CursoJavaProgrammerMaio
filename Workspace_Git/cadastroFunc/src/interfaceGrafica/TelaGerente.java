package interfaceGrafica;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.ControladorTelaGerente;
import controlador.ControladorTelaPrincipal;

public class TelaGerente {
	
	
	public void menuGerente() {
		
		JFrame frameMenuGerente = new JFrame();
		frameMenuGerente.setSize(200,200);
		
		JPanel panelMenuGerente = new JPanel();
		
		JLabel opcaoGerente1 = new JLabel("1 - Cadastrar Gerente");
		panelMenuGerente.add(opcaoGerente1);
		
		JLabel opcaoGerente2 = new JLabel("2 - Listar Gerente");
		panelMenuGerente.add(opcaoGerente2);
		
		JTextField opcapMenuGerente = new JTextField(10);
		panelMenuGerente.add(opcapMenuGerente);
		
		JButton botaoEnviarGerente = new JButton("Enviar");
		panelMenuGerente.add(botaoEnviarGerente);
		
		frameMenuGerente.add(panelMenuGerente);
		frameMenuGerente.setVisible(true);
		
		ControladorTelaGerente controladorTelaGerente = new ControladorTelaGerente(opcapMenuGerente, frameMenuGerente);
		botaoEnviarGerente.addActionListener(controladorTelaGerente);
		
		
	}

}
