package interfaceGrafica;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.ControladorCachorroForm;

public class CachorroForm {

	public void montaCachorroForm() {

		String v_campo_01 = "Nome";
		String v_campo_02 = "CAF";
		String v_campo_03 = "Cor do Pelo";

		// CRIANDO FRAME
		JFrame frmCachorroForm = new JFrame();
		frmCachorroForm.setSize(150, 250);

		// CRIANDO PANEL
		JPanel panelCachorroForm = new JPanel();

		// Agrupando o PANEL ao FRAME
		frmCachorroForm.add(panelCachorroForm);

		// CRIANDO LABELS e agrupando no PANEL
		// CRIANDO CAIXA TEXTO PARA PERMITIR INPUT DE DADOS e agrupando no PANEL
		JLabel labelCampo01 = new JLabel(v_campo_01);
		panelCachorroForm.add(labelCampo01);

		JTextField InputCampo01 = new JTextField(10);
		panelCachorroForm.add(InputCampo01);
		//
		JLabel labelCampo02 = new JLabel(v_campo_02);
		panelCachorroForm.add(labelCampo02);

		JTextField InputCampo02 = new JTextField(10);
		panelCachorroForm.add(InputCampo02);
		//
		JLabel labelCampo03 = new JLabel(v_campo_03);
		panelCachorroForm.add(labelCampo03);

		JTextField InputCampo03 = new JTextField(10);
		panelCachorroForm.add(InputCampo03);

		// CRIANDO BOTAO e agrupando no PANEL
		JButton saveBottom = new JButton("Save");
		panelCachorroForm.add(saveBottom);

		// CRIANDO UM CONTROLADOR (LISTENER) PARA O BOTAO
		ControladorCachorroForm controladorCachorroForm = new ControladorCachorroForm(InputCampo01, InputCampo02, InputCampo03);

		saveBottom.addActionListener(controladorCachorroForm);

		// TORNANDO O FRAME VISIVEL
		frmCachorroForm.setVisible(true);
	}
}
