package interfaceGrafica;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.ControladorTelaCadastroGerente;

public class TelaCadastroGerente {
	
	public void formularioGerente() {
		
		String nomeGerente = "Digite o nome do Gerente:";
		String cpfGerente = "Digite o cpf do gerente:";
		String gerenciaGerente = "Digite a Gerencia:";
		
		JFrame frameCadastroGerente = new JFrame();
		frameCadastroGerente.setSize(300, 300);
		
		JPanel panelGerente = new JPanel();
		
		JLabel labelnome = new JLabel(nomeGerente);
		panelGerente.add(labelnome);
		
		JTextField nomeText = new JTextField(10);
		panelGerente.add(nomeText);
		
		JLabel labelCpfGerente = new JLabel(cpfGerente);
		panelGerente.add(labelCpfGerente);
		
		JTextField cpfText = new JTextField(10);
		panelGerente.add(cpfText);
		
		JLabel labelGerenciaGerente = new JLabel(gerenciaGerente);
		panelGerente.add(labelGerenciaGerente);
		
		JTextField gerenciaText = new JTextField(10);
		panelGerente.add(gerenciaText);
		
		
		JButton botaoCadastroGerente = new JButton("Enviar");
		panelGerente.add(botaoCadastroGerente);
		
		
		frameCadastroGerente.add(panelGerente);
		frameCadastroGerente.setVisible(true);
		
		ControladorTelaCadastroGerente cadastroGerente = new ControladorTelaCadastroGerente(nomeText ,cpfText, gerenciaText);
		botaoCadastroGerente.addActionListener(cadastroGerente);
		
		
		
		
		
		
		
		
	}

}
