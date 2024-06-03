package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ControladorMainForm implements ActionListener {

	JTextField boxTextOption;

	public ControladorMainForm(JTextField boxTextOption) {
		this.boxTextOption = boxTextOption;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (boxTextOption.getText()) {
		case "1": {
			JOptionPane.showMessageDialog(null, "ESCOLHEU OPCAO 1...");
			break;
		}
		case "2": {
			JOptionPane.showMessageDialog(null, "ESCOLHEU OPCAO 2...");
			break;
		}
		case "3": {
			JOptionPane.showMessageDialog(null, "ESCOLHEU OPCAO 3...");
			System.exit(0);
			break;
		}
		default:
			JOptionPane.showMessageDialog(null, "Somente 1 ou 2 é Valido");
			boxTextOption.setText(null);
		}
	}
}
