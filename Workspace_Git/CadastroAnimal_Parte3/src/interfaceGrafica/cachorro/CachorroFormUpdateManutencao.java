package interfaceGrafica.cachorro;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.cachorro.ControladorCachorroFormUpdateManutencao;
import entidade.Cachorro;

public class CachorroFormUpdateManutencao {

	public void montaCachorroFormManutencao(Cachorro cachorro) {

		String v_campo_02 = "CAF: " + cachorro.getCaf();
		String v_campo_01 = "Nome";
		String v_campo_03 = "Cor do Pelo";

		// CRIANDO FRAME
		JFrame frmCachorroForm = new JFrame();
		frmCachorroForm.setSize(150, 250);

		// CRIANDO PANEL
		JPanel panelCachorroForm = new JPanel();

		// Agrupando o PANEL ao FRAME
		frmCachorroForm.add(panelCachorroForm);

		// SO VISUALIZACAO DO CAMPO "CAF" (PK)
		JLabel labelCampo02 = new JLabel(v_campo_02);
		panelCachorroForm.add(labelCampo02);

		// NOME
		JLabel labelCampo01 = new JLabel(v_campo_01);
		panelCachorroForm.add(labelCampo01);
		JTextField InputCampo01 = new JTextField(10);
		panelCachorroForm.add(InputCampo01);
		InputCampo01.setText(cachorro.getNome());

		// COR DO PELO
		JLabel labelCampo03 = new JLabel(v_campo_03);
		panelCachorroForm.add(labelCampo03);
		JTextField InputCampo03 = new JTextField(10);
		panelCachorroForm.add(InputCampo03);
		InputCampo03.setText(cachorro.getCorPelo());

		// CRIANDO BOTAO e agrupando no PANEL
		JButton saveBottom = new JButton("Atualiza Cachorro");
		panelCachorroForm.add(saveBottom);

		// Carrega objeto para passar como parametro
		// cachorroUpdate.setCaf(cachorro.getCaf());
		// cachorroUpdate.setNome(InputCampo01.getText());
		// cachorroUpdate.setCorPelo(InputCampo03.getText());

		// JOptionPane.showMessageDialog(null, ">>> " + cachorro.getCaf() + " | " +
		// InputCampo01.getText() + " | " + InputCampo03.getText() );
		// JOptionPane.showMessageDialog(null, ">>> " + cachorroUpdate.getCaf() + " | "
		// + cachorroUpdate.getCorPelo() + " | " + cachorroUpdate.getNome() );

		ControladorCachorroFormUpdateManutencao controladorCachorroFormUpdateManutencao = new ControladorCachorroFormUpdateManutencao(
				InputCampo01, InputCampo03, cachorro.getCaf(), frmCachorroForm);

		saveBottom.addActionListener(controladorCachorroFormUpdateManutencao);

		// CRIANDO UM CONTROLADOR (LISTENER) PARA O BOTAO
		// ControladorCachorroFormInsert controladorCachorroForm = new
		// ControladorCachorroFormInsert(InputCampo01, InputCampo02, InputCampo03);
		// saveBottom.addActionListener(controladorCachorroForm);

		// TORNANDO O FRAME VISIVEL
		frmCachorroForm.setVisible(true);
	}
}
