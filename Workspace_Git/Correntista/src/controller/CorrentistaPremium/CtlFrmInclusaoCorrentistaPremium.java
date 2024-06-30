package controller.CorrentistaPremium;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entity.EntCorrentistaPremium;
import repository.CorrentistaPremium.RepCorrentistaPremiumImplement;
import services.SrvApiCep;
import validation.VldCampos;

public class CtlFrmInclusaoCorrentistaPremium implements ActionListener {

	JTextField nome;
	JTextField cpf;
	JTextField cep;
	JTextField email;
	JTextField qtdTransacao;
	JTextField limCredito;

	JFrame frmVoltar;

	public CtlFrmInclusaoCorrentistaPremium(JTextField nome, JTextField cpf, JTextField cep, JTextField email,
			JTextField qtdTransacao, JTextField limCredito, JFrame frmVoltar) {
		this.nome = nome;
		this.cpf = cpf;
		this.cep = cep;
		this.email = email;
		this.qtdTransacao = qtdTransacao;
		this.limCredito = limCredito;
		this.frmVoltar = frmVoltar;
	}

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

		if (e.getActionCommand() == "Salvar") {
			VldCampos vldCampos = new VldCampos();

			RepCorrentistaPremiumImplement repCorrentistaPremiumImplement = new RepCorrentistaPremiumImplement();

			if (vldCampos.VldAddModifiedField(nome.getText(), cpf.getText(), cep.getText(), email.getText(),
					qtdTransacao.getText(), null, limCredito.getText(), "P")) {
				EntCorrentistaPremium entCorrentistaPremium = new EntCorrentistaPremium();
				entCorrentistaPremium = populaEntCorrentista();

				int confirmacao = JOptionPane.showConfirmDialog(null,
						"Confirma os dados?" + "\n" + "CPF: " + entCorrentistaPremium.getCpf() + "\n" + "NOME: "
								+ entCorrentistaPremium.getNome() + "\n" + "VL ANUIDADE: "
								+ entCorrentistaPremium.getValorAnuidade() + "\n" + "ENDEREÇO:" + "\n"
								+ entCorrentistaPremium.getEndereco().getCep() + "\n"
								+ entCorrentistaPremium.getEndereco().getLogradouro() + "\n"
								+ entCorrentistaPremium.getEndereco().getLocalidade() + "\n"
								+ entCorrentistaPremium.getEndereco().getUf());

				if (confirmacao == 0) {
					if (repCorrentistaPremiumImplement.adicionaCorrentistaPremium(entCorrentistaPremium)) {
						JOptionPane.showMessageDialog(null,
								"Cadastro de CORRENTISTA PREMIUM" + "\n" + "efetuado com sucesso!");
					} else {
						JOptionPane.showMessageDialog(null,
								"Erro ao registrar Correntista Premium..." + "\n" + "Processo cancelado.!");
					}
				}
			}

		} else if (e.getActionCommand() == "Voltar") {
			frmVoltar.setVisible(false);
		}
	}
}
