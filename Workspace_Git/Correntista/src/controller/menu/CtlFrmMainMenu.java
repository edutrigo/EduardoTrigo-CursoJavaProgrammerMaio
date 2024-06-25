package controller.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import form.menu.FrmMainMenuCorrentistaBasico;
import form.menu.FrmMainMenuCorrentistaPremium;

public class CtlFrmMainMenu implements ActionListener {

	JTextField opcaoMenu;

	public CtlFrmMainMenu(JTextField opcaoMenu) {
		this.opcaoMenu = opcaoMenu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (opcaoMenu.getText()) {
		case "1": {
			// CORRENTISTA BASICO
			FrmMainMenuCorrentistaBasico frmMainCorrentistaBasico = new FrmMainMenuCorrentistaBasico();
			frmMainCorrentistaBasico.menu();
			break;
		}
		case "2": {
			// CORRENTISTA PREMIUM
			FrmMainMenuCorrentistaPremium frmMainCorrentistaPremium = new FrmMainMenuCorrentistaPremium();
			frmMainCorrentistaPremium.menu();
			break;
		}
		case "X": {
			// SAIR
			System.exit(0);
			break;
		}
		case "x": {
			// SAIR
			System.exit(0);
			break;
		}
		default:
			opcaoMenu.setText(null);
			JOptionPane.showMessageDialog(null, "Somente as opções [1-2] ou 'X' são válidas...");
		}
	}
}