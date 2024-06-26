package controller.CorrentistaBasico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entity.EntCorrentistaBasico;
import form.CorrentistaBasico.FrmAlteracaoCorrentistaBasicoManut;
import repository.RepCorrentistaBasicoImplement;

public class CtlFrmAlteracaoCorrentistaBasicoSel implements ActionListener {

	JTextField cpf;
	JFrame frameRetornar;

	public CtlFrmAlteracaoCorrentistaBasicoSel(JTextField cpf, JFrame frameRetornar) {
		this.cpf = cpf;
		this.frameRetornar = frameRetornar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "ALTERAR") {

			RepCorrentistaBasicoImplement repCorrentistaBasicoImplement = new RepCorrentistaBasicoImplement();

			if (repCorrentistaBasicoImplement.buscaCorrentistaPorCpf(cpf.getText()) != null) {
				EntCorrentistaBasico entCorrentistaBasico = new EntCorrentistaBasico();
				entCorrentistaBasico = repCorrentistaBasicoImplement.buscaCorrentistaPorCpf(cpf.getText());

				FrmAlteracaoCorrentistaBasicoManut frmAlteracaoCorrentistaBasicoManut = new FrmAlteracaoCorrentistaBasicoManut();
				frmAlteracaoCorrentistaBasicoManut.alteracao(entCorrentistaBasico);
			} else {
				JOptionPane.showMessageDialog(null, "CPF não encontrado...");
			}

		} else if (e.getActionCommand() == "VOLTAR") {
			frameRetornar.setVisible(false);
		}
	}
}
