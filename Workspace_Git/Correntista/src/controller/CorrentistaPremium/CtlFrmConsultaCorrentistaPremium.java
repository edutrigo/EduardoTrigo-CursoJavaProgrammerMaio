package controller.CorrentistaPremium;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entity.EntCorrentistaPremium;
import repository.CorrentistaPremium.RepCorrentistaPremiumImplement;
import services.SrvCriarPdf;

public class CtlFrmConsultaCorrentistaPremium implements ActionListener {

	JTextField cpf;
	JFrame frameRetornar;

	public CtlFrmConsultaCorrentistaPremium(JTextField cpf, JFrame frameRetornar) {
		this.cpf = cpf;
		this.frameRetornar = frameRetornar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand() == "PDF") {

			RepCorrentistaPremiumImplement repCorrentistaPremiumImplement = new RepCorrentistaPremiumImplement();

			if (repCorrentistaPremiumImplement.buscaCorrentistaPorCpf(cpf.getText()) != null) {

				EntCorrentistaPremium entCorrentistaPremium = new EntCorrentistaPremium();
				entCorrentistaPremium = repCorrentistaPremiumImplement.buscaCorrentistaPorCpf(cpf.getText());

				SrvCriarPdf srvCriarPdf = new SrvCriarPdf();
				srvCriarPdf.gerarPdfCorrentistaPremium(entCorrentistaPremium);
			}

			else {
				JOptionPane.showMessageDialog(null, "CPF para CORRENTISTA PREMIUM não encontrado!: " + cpf.getText());
			}
		} else if (e.getActionCommand() == "VOLTAR") {
			frameRetornar.setVisible(false);
		}
	}
}
