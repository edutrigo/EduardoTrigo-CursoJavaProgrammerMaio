package interfaceGrafica.cachorro;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.cachorro.ControladorCachorroFormInsert;

public class CachorroFormInsert {

	public void montaCachorroForm() {

		GridLayout grid = new GridLayout(0, 1);

		String v_campo_01 = "Nome";
		String v_campo_02 = "CAF";
		String v_campo_03 = "Cor do Pelo";
		String v_campo_04 = "Peso";
		String v_campo_05 = "CEP";

		// CRIANDO FRAME
		JFrame frmCachorroForm = new JFrame();
		frmCachorroForm.setSize(150, 300);

		// CRIANDO PANEL
		JPanel panelCachorroForm = new JPanel();
		panelCachorroForm.setLayout(grid);

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
		//
		JLabel labelCampo04 = new JLabel(v_campo_04);
		panelCachorroForm.add(labelCampo04);

		JTextField InputCampo04 = new JTextField(10);
		panelCachorroForm.add(InputCampo04);
		//
		JLabel labelCampo05 = new JLabel(v_campo_05);
		panelCachorroForm.add(labelCampo05);

		JTextField InputCampo05 = new JTextField(10);
		panelCachorroForm.add(InputCampo05);

		// CRIANDO BOTAO e agrupando no PANEL
		JButton saveBottom = new JButton("Save Cachorro");
		panelCachorroForm.add(saveBottom);

		// CRIANDO UM CONTROLADOR (LISTENER) PARA O BOTAO
		ControladorCachorroFormInsert controladorCachorroForm = new ControladorCachorroFormInsert(InputCampo01,
				InputCampo02, InputCampo03, InputCampo04, InputCampo05);

		saveBottom.addActionListener(controladorCachorroForm);

		// TORNANDO O FRAME VISIVEL
		frmCachorroForm.setVisible(true);
	}
}
