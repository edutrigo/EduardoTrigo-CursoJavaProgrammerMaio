package controller.CorrentistaPremium;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import repository.CorrentistaPremium.RepCorrentistaPremiumImplement;

public class CtlFrmExclusaoCorrentistaPremium implements ActionListener {

	JTextField cpf;
	JFrame frameRetornar;

	public CtlFrmExclusaoCorrentistaPremium(JTextField cpf, JFrame frameRetornar) {
		this.cpf = cpf;
		this.frameRetornar = frameRetornar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "EXCLUIR") {

			RepCorrentistaPremiumImplement repCorrentistaPremiumImplement = new RepCorrentistaPremiumImplement();
			repCorrentistaPremiumImplement.excluiCorrentista(cpf.getText());

		} else if (e.getActionCommand() == "VOLTAR") {
			frameRetornar.setVisible(false);
		}
	}
}
