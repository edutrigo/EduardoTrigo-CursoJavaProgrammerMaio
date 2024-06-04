package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ControladorCachorroForm implements ActionListener {

	JTextField campo_01;
	JTextField campo_02;
	JTextField campo_03;

	public ControladorCachorroForm(JTextField campo_01, JTextField campo_02, JTextField campo_03) {
		this.campo_01 = campo_01;
		this.campo_02 = campo_02;
		this.campo_03 = campo_03;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JOptionPane.showMessageDialog(null, "TESTE: " + campo_01 + campo_02 + campo_03 );

		if (campo_01 == null) {
			JOptionPane.showMessageDialog(null, "Campo 'NOME' não pode ficar em branco!");
		} else if (campo_02 == null) {
			JOptionPane.showMessageDialog(null, "Campo 'CAF' não pode ficar em branco!");
		} else if (campo_03 == null) {
			JOptionPane.showMessageDialog(null, "Campo 'CorPelo' não pode ficar em branco!");
		}
	}
}
