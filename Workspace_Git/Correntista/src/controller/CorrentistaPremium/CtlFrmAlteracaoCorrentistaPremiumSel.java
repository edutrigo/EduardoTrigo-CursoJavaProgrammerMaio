package controller.CorrentistaPremium;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entity.EntCorrentistaPremium;
import form.CorrentistaPremium.FrmAlteracaoCorrentistaPremiumManut;
import repository.CorrentistaPremium.RepCorrentistaPremiumImplement;

public class CtlFrmAlteracaoCorrentistaPremiumSel implements ActionListener {

	JTextField cpf;
	JFrame frameRetornar;

	public CtlFrmAlteracaoCorrentistaPremiumSel(JTextField cpf, JFrame frameRetornar) {
		this.cpf = cpf;
		this.frameRetornar = frameRetornar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "ALTERAR") {

			RepCorrentistaPremiumImplement repCorrentistaPremiumImplement = new RepCorrentistaPremiumImplement();

			if (repCorrentistaPremiumImplement.buscaCorrentistaPorCpf(cpf.getText()) != null) {
				EntCorrentistaPremium entCorrentistaPremium = new EntCorrentistaPremium();
				entCorrentistaPremium = repCorrentistaPremiumImplement.buscaCorrentistaPorCpf(cpf.getText());

				FrmAlteracaoCorrentistaPremiumManut frmAlteracaoCorrentistaPremiumManut = new FrmAlteracaoCorrentistaPremiumManut();
				frmAlteracaoCorrentistaPremiumManut.alteracao(entCorrentistaPremium);
			} else {
				JOptionPane.showMessageDialog(null, "CPF não encontrado...");
			}

		} else if (e.getActionCommand() == "VOLTAR") {
			frameRetornar.setVisible(false);
		}
	}
}
