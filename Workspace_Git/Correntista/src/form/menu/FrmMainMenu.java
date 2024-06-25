package form.menu;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.menu.CtlFrmMainMenu;

public class FrmMainMenu {

	public void menu() {
		//
		GridLayout grid = new GridLayout(0, 1);

		JFrame frmMainForm = new JFrame();
		frmMainForm.setSize(200, 300);

		JPanel panelMainForm = new JPanel();
		panelMainForm.setLayout(grid);

		frmMainForm.add(panelMainForm);

		//
		JLabel lblCabecalho = new JLabel("[ MENU PRINCIPAL ]");
		panelMainForm.add(lblCabecalho);

		JLabel lblCad = new JLabel("[1] CORRENTISTA BASICO");
		panelMainForm.add(lblCad);

		JLabel lblCon = new JLabel("[2] CORRENTISTA PREMIUM");
		panelMainForm.add(lblCon);

		JLabel lblSair = new JLabel("X - SAIDA");
		panelMainForm.add(lblSair);

		JTextField tfBoxOption = new JTextField(5);
		panelMainForm.add(tfBoxOption);

		JButton btOption = new JButton("Enviar");
		panelMainForm.add(btOption);

		//
		CtlFrmMainMenu ctlFrmMain = new CtlFrmMainMenu(tfBoxOption);
		btOption.addActionListener(ctlFrmMain);

		frmMainForm.setVisible(true);
	}
}
