package interfaceGrafica;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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

		// CRIANDO CAIXA TEXTO PARA PERMITIR INPUT DE DADOS e agrupando no PANEL
		JTextField boxOption = new JTextField(10);
		panelMainForm.add(boxOption);

		// CRIANDO BOTAO e agrupando no PANEL
		JButton sendBottom = new JButton("Enviar");
		panelMainForm.add(sendBottom);

		// TORNANDO O FRAME VISIVEL
		frmMainForm.setVisible(true);
	}
}
