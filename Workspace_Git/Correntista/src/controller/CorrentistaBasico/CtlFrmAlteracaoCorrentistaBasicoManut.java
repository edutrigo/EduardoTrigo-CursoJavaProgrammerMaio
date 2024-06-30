package controller.CorrentistaBasico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import entity.EntCorrentistaBasico;
import repository.CorrentistaBasico.RepCorrentistaBasicoImplement;
import services.SrvApiCep;
import validation.VldCampos;

public class CtlFrmAlteracaoCorrentistaBasicoManut implements ActionListener {

	private JTextField nome;
	private JTextField cpf;
	private JTextField cep;
	private JTextField email;
	private JTextField qtdTransacao;
	private JTextField limSaque;
	private JFrame frameRetornar;

	public CtlFrmAlteracaoCorrentistaBasicoManut(JTextField nome, JTextField cpf, JTextField cep, JTextField email,
			JTextField qtdTransacao, JTextField limSaque, JFrame frameRetornar) {
		this.nome = nome;
		this.cpf = cpf;
		this.cep = cep;
		this.email = email;
		this.qtdTransacao = qtdTransacao;
		this.limSaque = limSaque;
		this.frameRetornar = frameRetornar;
	}

	//
	public EntCorrentistaBasico populaEntCorrentista() {

		EntCorrentistaBasico entCorrentistaBasico = new EntCorrentistaBasico();

		entCorrentistaBasico
				.setValorAnuidade(entCorrentistaBasico.CalcularAnuidade(Integer.parseInt(qtdTransacao.getText())));

		entCorrentistaBasico.setNome(nome.getText());
		entCorrentistaBasico.setCpf(cpf.getText());
		entCorrentistaBasico.setEmail(email.getText());
		entCorrentistaBasico.setQtdTransacao(Integer.parseInt(qtdTransacao.getText()));
		entCorrentistaBasico.setLimiteDeSaque(Double.parseDouble(limSaque.getText()));

		try {
			entCorrentistaBasico.setEndereco(SrvApiCep.buscaEndCep(cep.getText()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entCorrentistaBasico;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "SALVAR") {

			VldCampos vldCampos = new VldCampos();

			if (vldCampos.VldAddModifiedField(nome.getText(), cpf.getText(), cep.getText(), email.getText(),
					qtdTransacao.getText(), limSaque.getText(), null, "B")) {

				EntCorrentistaBasico entCorrentistaBasico = new EntCorrentistaBasico();
				entCorrentistaBasico = populaEntCorrentista();

				RepCorrentistaBasicoImplement repCorrentistaBasicoImplement = new RepCorrentistaBasicoImplement();
				repCorrentistaBasicoImplement.atualizaCorrentistaBasico(entCorrentistaBasico);
			}
		} else if (e.getActionCommand() == "VOLTAR") {
			frameRetornar.setVisible(false);
		}
	}
}
