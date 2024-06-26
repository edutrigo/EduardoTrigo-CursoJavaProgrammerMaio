package form.CorrentistaBasico;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.CorrentistaBasico.CtlFrmInclusaoCorrentistaBasico;

public class FrmInclusaoCorrentistaBasico {

	public void inclusao() {
		//
		GridLayout grid = new GridLayout(0, 1);
		JFrame frmCorrentista = new JFrame();
		frmCorrentista.setSize(200, 350);
		JPanel pnCorrentista = new JPanel();
		pnCorrentista.setLayout(grid);
		frmCorrentista.add(pnCorrentista);

		// NOME
		JLabel lbNome = new JLabel("Nome");
		pnCorrentista.add(lbNome);
		JTextField tfNome = new JTextField(10);
		pnCorrentista.add(tfNome);

		// CPF
		JLabel lbCpf = new JLabel("CPF");
		pnCorrentista.add(lbCpf);
		JTextField tfCpf = new JTextField(10);
		pnCorrentista.add(tfCpf);

		// CEP
		JLabel lbCep = new JLabel("CEP");
		pnCorrentista.add(lbCep);
		JTextField tfCep = new JTextField(10);
		pnCorrentista.add(tfCep);

		// EMAIL
		JLabel lbEmail = new JLabel("EMAIL");
		pnCorrentista.add(lbEmail);
		JTextField tfEmail = new JTextField(10);
		pnCorrentista.add(tfEmail);

		// QTD TRANSAÇÃO
		JLabel lbQtdTrans = new JLabel("QTD TRANSAÇÃO");
		pnCorrentista.add(lbQtdTrans);
		JTextField tfQtdTrans = new JTextField(10);
		pnCorrentista.add(tfQtdTrans);

		// LIMITE SAQUE
		JLabel lbLimSaque = new JLabel("LIM SAQUE");
		pnCorrentista.add(lbLimSaque);
		JTextField tfLimSaque = new JTextField(10);
		pnCorrentista.add(tfLimSaque);

		//
		JButton svBottom = new JButton("Salvar");
		pnCorrentista.add(svBottom);

		JButton bkBottom = new JButton("Voltar");
		pnCorrentista.add(bkBottom);

		CtlFrmInclusaoCorrentistaBasico ctlFrmInclusao = new CtlFrmInclusaoCorrentistaBasico(tfNome, tfCpf, tfCep,
				tfEmail, tfQtdTrans, tfLimSaque, frmCorrentista);

		svBottom.addActionListener(ctlFrmInclusao);
		bkBottom.addActionListener(ctlFrmInclusao);

		frmCorrentista.setVisible(true);
	}
}
