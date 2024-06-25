package form.menu;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.menu.CtlFrmMainMenuCorrentistaBasico;

public class FrmMainMenuCorrentistaBasico {
	public void menu() {
		//
		GridLayout grid = new GridLayout(0, 1);

		JFrame frmMainForm = new JFrame();
		frmMainForm.setSize(250, 300);

		JPanel panelMainForm = new JPanel();
		panelMainForm.setLayout(grid);

		frmMainForm.add(panelMainForm);

		//
		JLabel lblCabecalho = new JLabel("[ MENU CORRENTISTA BASICO ]");
		panelMainForm.add(lblCabecalho);

		JLabel lblCad = new JLabel("[1] INCLUSÃO");
		panelMainForm.add(lblCad);

		JLabel lblCon = new JLabel("[2] CONSULTA / PDF");
		panelMainForm.add(lblCon);

		JLabel lblExc = new JLabel("[3] EXCLUSÃO");
		panelMainForm.add(lblExc);

		JLabel lblAtu = new JLabel("[4] ATUALIZAÇÃO");
		panelMainForm.add(lblAtu);

		JLabel lblSair = new JLabel("[X] VOLTAR MENU PRINCIPAL");
		panelMainForm.add(lblSair);

		JTextField tfBoxOption = new JTextField(5);
		panelMainForm.add(tfBoxOption);

		JButton btOption = new JButton("Enviar");
		panelMainForm.add(btOption);

		//
		CtlFrmMainMenuCorrentistaBasico ctlFrmMainCorrentistaBasico = new CtlFrmMainMenuCorrentistaBasico(tfBoxOption,
				frmMainForm);
		btOption.addActionListener(ctlFrmMainCorrentistaBasico);

		frmMainForm.setVisible(true);
	}
}