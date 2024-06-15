package interfaceGrafica.cobra;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.cobra.ControladorCobraFormUpdateManutencao;
import entidade.Cobra;

public class CobraFormUpdateManutencao {

	public void montaCobraFormManutencao(Cobra cobra) {

		String v_campo_02 = "CAF: " + cobra.getCaf();
		String v_campo_01 = "Nome";
		String v_campo_03 = "Tipo Veneno";

		// CRIANDO FRAME
		JFrame frmCobraForm = new JFrame();
		frmCobraForm.setSize(150, 250);

		// CRIANDO PANEL
		JPanel panelCobraForm = new JPanel();

		// Agrupando o PANEL ao FRAME
		frmCobraForm.add(panelCobraForm);

		// SO VISUALIZACAO DO CAMPO "CAF" (PK)
		JLabel labelCampo02 = new JLabel(v_campo_02);
		panelCobraForm.add(labelCampo02);

		// NOME
		JLabel labelCampo01 = new JLabel(v_campo_01);
		panelCobraForm.add(labelCampo01);
		JTextField InputCampo01 = new JTextField(10);
		panelCobraForm.add(InputCampo01);
		InputCampo01.setText(cobra.getNome());

		// TIPO VENENO
		JLabel labelCampo03 = new JLabel(v_campo_03);
		panelCobraForm.add(labelCampo03);
		JTextField InputCampo03 = new JTextField(10);
		panelCobraForm.add(InputCampo03);
		InputCampo03.setText(cobra.getTipoVeneno());

		// CRIANDO BOTAO e agrupando no PANEL
		JButton saveBottom = new JButton("Atualiza Cobra");
		panelCobraForm.add(saveBottom);

		ControladorCobraFormUpdateManutencao controladorCobraFormUpdateManutencao = new ControladorCobraFormUpdateManutencao(
				InputCampo01, InputCampo03, cobra.getCaf(), frmCobraForm);

		saveBottom.addActionListener(controladorCobraFormUpdateManutencao);

		// TORNANDO O FRAME VISIVEL
		frmCobraForm.setVisible(true);
	}
}
