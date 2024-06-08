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
		frmMainForm.setSize(130, 200);

		// CRIANDO PANEL
		JPanel panelMainForm = new JPanel();

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

		JLabel labelOpcao5 = new JLabel("5 - SAIDA");
		panelMainForm.add(labelOpcao5);

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
