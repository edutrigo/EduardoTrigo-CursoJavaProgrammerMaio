package controller.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import form.FrmInclusaoCorrentistaBasico;

public class CtlFrmMainMenuCorrentistaBasico implements ActionListener {

	JTextField opcaoMenu;
	JFrame frameRetornar;

	public CtlFrmMainMenuCorrentistaBasico(JTextField opcaoMenu, JFrame frameRetornar) {
		this.opcaoMenu = opcaoMenu;
		this.frameRetornar = frameRetornar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (opcaoMenu.getText()) {
		case "1": {
			FrmInclusaoCorrentistaBasico frmInclusaoCorrentistaBasico = new FrmInclusaoCorrentistaBasico();
			frmInclusaoCorrentistaBasico.inclusao();
			// INCLUSAO
			break;
		}
		case "2": {
			// CONSULTA/PDF
			break;
		}
		case "3": {
			// EXCLUSAO
			break;
		}
		case "4": {
			// ATUALIZACAO
			break;
		}
		case "X": {
			// RETORNAR MENU PRINCIPAL
			frameRetornar.setVisible(false);
			break;
		}
		case "x": {
			// RETORNAR MENU PRINCIPAL
			frameRetornar.setVisible(false);
			break;
		}
		default:
			opcaoMenu.setText(null);
			JOptionPane.showMessageDialog(null, "Somente as opções [1-4] ou 'X' são válidas...");
		}

	}
}