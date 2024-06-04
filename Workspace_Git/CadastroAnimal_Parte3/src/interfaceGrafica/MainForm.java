package interfaceGrafica;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.ControladorMainForm;

public class MainForm {

	public void mainFormMenu() {

		// CRIANDO FRAME
		JFrame frmMainForm = new JFrame();
		frmMainForm.setSize(200, 200);

		// CRIANDO PANEL
		JPanel panelMainForm = new JPanel();

		// Agrupando o PANEL ao FRAME
		frmMainForm.add(panelMainForm);

		// CRIANDO LABELS e agrupando no PANEL
		JLabel labelOpcao1 = new JLabel("1 - CACHORRO");
		panelMainForm.add(labelOpcao1);

		JLabel labelOpcao2 = new JLabel("2 - COBRA");
		panelMainForm.add(labelOpcao2);

		JLabel labelOpcao3 = new JLabel("3 - SAIDA");
		panelMainForm.add(labelOpcao3);

		// CRIANDO CAIXA TEXTO PARA PERMITIR INPUT DE DADOS e agrupando no PANEL
		JTextField boxOption = new JTextField(10);

		//boxOption.setName("SET NAME"); Date d = new Date()
		
		//date = new Date()
		
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
