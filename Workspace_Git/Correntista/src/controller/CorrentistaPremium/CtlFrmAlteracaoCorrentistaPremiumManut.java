package controller.CorrentistaPremium;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import entity.EntCorrentistaPremium;
import repository.CorrentistaPremium.RepCorrentistaPremiumImplement;
import services.SrvApiCep;
import validation.VldCampos;

public class CtlFrmAlteracaoCorrentistaPremiumManut implements ActionListener {

	private JTextField nome;
	private JTextField cpf;
	private JTextField cep;
	private JTextField email;
	private JTextField qtdTransacao;
	private JTextField limCredito;
	private JFrame frameRetornar;

	public CtlFrmAlteracaoCorrentistaPremiumManut(JTextField nome, JTextField cpf, JTextField cep, JTextField email,
			JTextField qtdTransacao, JTextField limCredito, JFrame frameRetornar) {
		this.nome = nome;
		this.cpf = cpf;
		this.cep = cep;
		this.email = email;
		this.qtdTransacao = qtdTransacao;
		this.limCredito = limCredito;
		this.frameRetornar = frameRetornar;
	}

	//
	public EntCorrentistaPremium populaEntCorrentista() {

		EntCorrentistaPremium entCorrentistaPremium = new EntCorrentistaPremium();

		entCorrentistaPremium
				.setValorAnuidade(entCorrentistaPremium.CalcularAnuidade(Integer.parseInt(qtdTransacao.getText())));

		entCorrentistaPremium.setNome(nome.getText());
		entCorrentistaPremium.setCpf(cpf.getText());
		entCorrentistaPremium.setEmail(email.getText());
		entCorrentistaPremium.setQtdTransacao(Integer.parseInt(qtdTransacao.getText()));
		entCorrentistaPremium.setLimiteDeCredito(Double.parseDouble(limCredito.getText()));

		try {
			entCorrentistaPremium.setEndereco(SrvApiCep.buscaEndCep(cep.getText()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entCorrentistaPremium;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "SALVAR") {

			VldCampos vldCampos = new VldCampos();

			if (vldCampos.VldAddModifiedField(nome.getText(), cpf.getText(), cep.getText(), email.getText(),
					qtdTransacao.getText(), null, limCredito.getText(), "P")) {

				EntCorrentistaPremium entCorrentistaPremium = new EntCorrentistaPremium();
				entCorrentistaPremium = populaEntCorrentista();

				RepCorrentistaPremiumImplement repCorrentistaPremiumImplement = new RepCorrentistaPremiumImplement();
				repCorrentistaPremiumImplement.atualizaCorrentistaPremium(entCorrentistaPremium);
			}
		} else if (e.getActionCommand() == "VOLTAR") {
			frameRetornar.setVisible(false);
		}
	}
}
