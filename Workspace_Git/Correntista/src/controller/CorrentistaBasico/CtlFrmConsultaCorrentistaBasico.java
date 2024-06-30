package controller.CorrentistaBasico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entity.EntCorrentistaBasico;
import repository.CorrentistaBasico.RepCorrentistaBasicoImplement;
import services.SrvCriarPdf;

public class CtlFrmConsultaCorrentistaBasico implements ActionListener {

	JTextField cpf;
	JFrame frameRetornar;

	public CtlFrmConsultaCorrentistaBasico(JTextField cpf, JFrame frameRetornar) {
		this.cpf = cpf;
		this.frameRetornar = frameRetornar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand() == "PDF") {

			RepCorrentistaBasicoImplement repCorrentistaBasicoImplement = new RepCorrentistaBasicoImplement();

			if (repCorrentistaBasicoImplement.buscaCorrentistaPorCpf(cpf.getText()) != null) {

				EntCorrentistaBasico entCorrentistaBasico = new EntCorrentistaBasico();
				entCorrentistaBasico = repCorrentistaBasicoImplement.buscaCorrentistaPorCpf(cpf.getText());

				SrvCriarPdf srvCriarPdf = new SrvCriarPdf();
				srvCriarPdf.gerarPdfCorrentistaBasico(entCorrentistaBasico);
			}

			else {
				JOptionPane.showMessageDialog(null, "CPF para CORRENTISTA BASICO não encontrado!: " + cpf.getText());
			}
		} else if (e.getActionCommand() == "VOLTAR") {
			frameRetornar.setVisible(false);
		}
	}
}
