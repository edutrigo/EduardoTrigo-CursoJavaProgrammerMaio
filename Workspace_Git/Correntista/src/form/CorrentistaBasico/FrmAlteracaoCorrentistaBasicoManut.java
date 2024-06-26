package form.CorrentistaBasico;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.CorrentistaBasico.CtlFrmAlteracaoCorrentistaBasicoManut;
import entity.EntCorrentistaBasico;
import entity.EntEndereco;

public class FrmAlteracaoCorrentistaBasicoManut {

	public void alteracao(EntCorrentistaBasico entCorrentista) {
		//
		GridLayout grid = new GridLayout(0, 1);
		JFrame frmCorrentista = new JFrame();
		frmCorrentista.setSize(200, 350);
		JPanel pnCorrentista = new JPanel();
		pnCorrentista.setLayout(grid);
		frmCorrentista.add(pnCorrentista);

		// CPF
		JLabel lbCpf = new JLabel("CPF: " + entCorrentista.getCpf());
		pnCorrentista.add(lbCpf);
		//
		JTextField tfCpf = new JTextField(10);
		pnCorrentista.add(tfCpf);
		tfCpf.setText(entCorrentista.getCpf());
		tfCpf.setVisible(false);

		// NOME
		JLabel lbNome = new JLabel("Nome");
		pnCorrentista.add(lbNome);
		JTextField tfNome = new JTextField(10);
		pnCorrentista.add(tfNome);
		tfNome.setText(entCorrentista.getNome());

		// CEP
		EntEndereco entEndereco = new EntEndereco();
		entEndereco = entCorrentista.getEndereco();
		//
		JLabel lbCep = new JLabel("CEP");
		pnCorrentista.add(lbCep);
		JTextField tfCep = new JTextField(10);
		pnCorrentista.add(tfCep);
		tfCep.setText(entEndereco.getCep());

		// EMAIL
		JLabel lbEmail = new JLabel("EMAIL");
		pnCorrentista.add(lbEmail);
		JTextField tfEmail = new JTextField(10);
		pnCorrentista.add(tfEmail);
		tfEmail.setText(entCorrentista.getEmail());

		// QTD TRANSAÇÃO
		JLabel lbQtdTrans = new JLabel("QTD TRANSAÇÃO");
		pnCorrentista.add(lbQtdTrans);
		JTextField tfQtdTrans = new JTextField(10);
		pnCorrentista.add(tfQtdTrans);
		tfQtdTrans.setText(Integer.toString(entCorrentista.getQtdTransacao()));

		// LIMITE SAQUE
		JLabel lbLimSaque = new JLabel("LIM SAQUE");
		pnCorrentista.add(lbLimSaque);
		JTextField tfLimSaque = new JTextField(10);
		pnCorrentista.add(tfLimSaque);
		tfLimSaque.setText(Double.toString(entCorrentista.getLimiteDeSaque()));

		//
		JButton svBottom = new JButton("SALVAR");
		pnCorrentista.add(svBottom);

		JButton bkBottom = new JButton("VOLTAR");
		pnCorrentista.add(bkBottom);

		//
		CtlFrmAlteracaoCorrentistaBasicoManut ctlFrmAlteracaoCorrentistaBasicoManut = new CtlFrmAlteracaoCorrentistaBasicoManut(
				tfNome, tfCpf, tfCep, tfEmail, tfQtdTrans, tfLimSaque, frmCorrentista);

		svBottom.addActionListener(ctlFrmAlteracaoCorrentistaBasicoManut);
		bkBottom.addActionListener(ctlFrmAlteracaoCorrentistaBasicoManut);

		frmCorrentista.setVisible(true);
	}
}
