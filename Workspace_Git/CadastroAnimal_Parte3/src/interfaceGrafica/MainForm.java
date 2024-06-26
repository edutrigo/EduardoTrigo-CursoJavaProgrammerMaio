package interfaceGrafica;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.ControladorMainForm;

public class MainForm {

	public void mainFormMenu() {

		GridLayout grid = new GridLayout(0, 1);
		
		// CRIANDO FRAME
		JFrame frmMainForm = new JFrame();
		frmMainForm.setSize(130, 300);

		// CRIANDO PANEL
		JPanel panelMainForm = new JPanel();
		panelMainForm.setLayout(grid);

		// Agrupando o PANEL ao FRAME
		frmMainForm.add(panelMainForm);

		// CRIANDO LABELS e agrupando no PANEL
		JLabel labelOpcao1 = new JLabel("1 - CAD CACHORRO");
		panelMainForm.add(labelOpcao1);

		JLabel labelOpcao2 = new JLabel("2 - CAD COBRA");
		panelMainForm.add(labelOpcao2);

		JLabel labelOpcao3 = new JLabel("3 - LST CACHORRO");
		panelMainForm.add(labelOpcao3);

		JLabel labelOpcao4 = new JLabel("4 - LST  COBRA");
		panelMainForm.add(labelOpcao4);

		JLabel labelOpcao5 = new JLabel("5 - DEL CACHORRO");
		panelMainForm.add(labelOpcao5);

		JLabel labelOpcao6 = new JLabel("6 - DEL COBRA");
		panelMainForm.add(labelOpcao6);

		JLabel labelOpcao7 = new JLabel("7 - ATU CACHORRO");
		panelMainForm.add(labelOpcao7);

		JLabel labelOpcao8 = new JLabel("8 - ATU COBRA");
		panelMainForm.add(labelOpcao8);

		JLabel labelOpcaoX = new JLabel("X - SAIDA");
		panelMainForm.add(labelOpcaoX);

		// CRIANDO CAIXA TEXTO PARA PERMITIR INPUT DE DADOS e agrupando no PANEL
		JTextField boxOption = new JTextField(10);

		panelMainForm.add(boxOption);

		// CRIANDO BOTAO e agrupando no PANEL
		JButton sendBottom = new JButton("Send");
		panelMainForm.add(sendBottom);

		// CRIANDO UM CONTROLADOR (LISTENER) PARA O BOTAO
		ControladorMainForm controladorMainForm = new ControladorMainForm(boxOption);
		sendBottom.addActionListener(controladorMainForm);

		// TORNANDO O FRAME VISIVEL
		frmMainForm.setVisible(true);
	}
}
