package controller.CorrentistaBasico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import repository.CorrentistaBasico.RepCorrentistaBasicoImplement;

public class CtlFrmExclusaoCorrentistaBasico implements ActionListener {

	JTextField cpf;
	JFrame frameRetornar;

	public CtlFrmExclusaoCorrentistaBasico(JTextField cpf, JFrame frameRetornar) {
		this.cpf = cpf;
		this.frameRetornar = frameRetornar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "EXCLUIR") {

			RepCorrentistaBasicoImplement repCorrentistaBasicoImplement = new RepCorrentistaBasicoImplement();
			repCorrentistaBasicoImplement.excluiCorrentista(cpf.getText());

		} else if (e.getActionCommand() == "VOLTAR") {
			frameRetornar.setVisible(false);
		}
	}
}
