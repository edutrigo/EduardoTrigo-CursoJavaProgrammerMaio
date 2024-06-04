package interfaceGrafica;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.ControladorCobraForm;

public class CobraForm {

	public void montaCobraForm() {

		String v_campo_01 = "Nome";
		String v_campo_02 = "CAF";
		String v_campo_03 = "Tipo Veneno";

		// CRIANDO FRAME
		JFrame frmCobraForm = new JFrame();
		frmCobraForm.setSize(150, 250);

		// CRIANDO PANEL
		JPanel panelCobraForm = new JPanel();

		// Agrupando o PANEL ao FRAME
		frmCobraForm.add(panelCobraForm);

		// CRIANDO LABELS e agrupando no PANEL
		// CRIANDO CAIXA TEXTO PARA PERMITIR INPUT DE DADOS e agrupando no PANEL
		JLabel labelCampo01 = new JLabel(v_campo_01);
		panelCobraForm.add(labelCampo01);

		JTextField InputCampo01 = new JTextField(10);
		panelCobraForm.add(InputCampo01);
		//
		JLabel labelCampo02 = new JLabel(v_campo_02);
		panelCobraForm.add(labelCampo02);

		JTextField InputCampo02 = new JTextField(10);
		panelCobraForm.add(InputCampo02);
		//
		JLabel labelCampo03 = new JLabel(v_campo_03);
		panelCobraForm.add(labelCampo03);

		JTextField InputCampo03 = new JTextField(10);
		panelCobraForm.add(InputCampo03);

		// CRIANDO BOTAO e agrupando no PANEL
		JButton saveBottom = new JButton("Save Cobra");
		panelCobraForm.add(saveBottom);

		// CRIANDO UM CONTROLADOR (LISTENER) PARA O BOTAO
		ControladorCobraForm controladorCobraForm = new ControladorCobraForm(InputCampo01, InputCampo02, InputCampo03);

		saveBottom.addActionListener(controladorCobraForm);

		// TORNANDO O FRAME VISIVEL
		frmCobraForm.setVisible(true);
	}
}
