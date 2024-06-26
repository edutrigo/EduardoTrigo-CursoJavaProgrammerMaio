package controller.CorrentistaBasico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entity.EntCorrentistaBasico;
import repository.RepCorrentistaBasicoImplement;
import services.SrvApiCep;
import validation.VldCampos;

public class CtlFrmInclusaoCorrentistaBasico implements ActionListener {

	JTextField nome;
	JTextField cpf;
	JTextField cep;
	JTextField email;
	JTextField qtdTransacao;
	JTextField limSaque;

	JFrame frmVoltar;

	public CtlFrmInclusaoCorrentistaBasico(JTextField nome, JTextField cpf, JTextField cep, JTextField email,
			JTextField qtdTransacao, JTextField limSaque, JFrame frmVoltar) {
		this.nome = nome;
		this.cpf = cpf;
		this.cep = cep;
		this.email = email;
		this.qtdTransacao = qtdTransacao;
		this.limSaque = limSaque;
		this.frmVoltar = frmVoltar;
	}

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

		if (e.getActionCommand() == "Salvar") {
			VldCampos vldCampos = new VldCampos();

			RepCorrentistaBasicoImplement repCorrentistaBasicoImplement = new RepCorrentistaBasicoImplement();

			if (vldCampos.campoNullBranco(nome.getText())) {
				JOptionPane.showMessageDialog(null, "Campo 'Nome' não pode ficar em branco.");
			}

			else if (vldCampos.campoNullBranco(cpf.getText())) {
				JOptionPane.showMessageDialog(null, "Campo 'CPF' não pode ficar em branco.");
			}

			else if (vldCampos.campoNullBranco(cep.getText())) {
				JOptionPane.showMessageDialog(null, "Campo 'CEP' não pode ficar em branco.");
			}

			else if (vldCampos.campoNullBranco(email.getText())) {
				JOptionPane.showMessageDialog(null, "Campo 'eMail' não pode ficar em branco.");
			}

			else if (vldCampos.campoNullBranco(qtdTransacao.getText())) {
				JOptionPane.showMessageDialog(null, "Campo 'Qtd Transação' não pode ficar em branco.");
			}

			else if (vldCampos.campoNullBranco(limSaque.getText())) {
				JOptionPane.showMessageDialog(null, "Campo 'Lim Saque' não pode ficar em branco.");
			} else {

				if (vldCampos.campoDouble(cpf.getText()) == false) {
					JOptionPane.showMessageDialog(null, "Campo 'CPF' só pode contem números.");

				} else if (vldCampos.campoInteger(cep.getText()) == false) {
					JOptionPane.showMessageDialog(null, "Campo 'CEP' só pode contem números.");

				} else if (vldCampos.campoInteger(qtdTransacao.getText()) == false) {
					JOptionPane.showMessageDialog(null, "Campo 'Qtd Transação' só pode contem números.");

				} else if (vldCampos.campoInteger(limSaque.getText()) == false) {
					JOptionPane.showMessageDialog(null, "Campo 'Lim Saque' só pode contem números.");

				} else {
					EntCorrentistaBasico entCorrentistaBasico = new EntCorrentistaBasico();
					entCorrentistaBasico = populaEntCorrentista();

					int confirmacao = JOptionPane.showConfirmDialog(null,
							"Confirma os dados?" + "\n" + "CPF: " + entCorrentistaBasico.getCpf() + "\n" + "NOME: "
									+ entCorrentistaBasico.getNome() + "\n" + "VL ANUIDADE: "
									+ entCorrentistaBasico.getValorAnuidade() + "\n" + "ENDEREÇO:" + "\n"
									+ entCorrentistaBasico.getEndereco().getCep() + "\n"
									+ entCorrentistaBasico.getEndereco().getLogradouro() + "\n"
									+ entCorrentistaBasico.getEndereco().getLocalidade() + "\n"
									+ entCorrentistaBasico.getEndereco().getUf());

					if (confirmacao == 0) {
						if (repCorrentistaBasicoImplement.adicionaCorrentistaBasico(entCorrentistaBasico)) {
							JOptionPane.showMessageDialog(null,
									"Cadastro de CORRENTISTA BASICO" + "\n" + "efetuado com sucesso!");
						} else {
							JOptionPane.showMessageDialog(null,
									"Erro ao registrar Correntista Básico..." + "\n" + "Processo cancelado.!");
						}
					}
				}
			}

		} else if (e.getActionCommand() == "Voltar") {
			frmVoltar.setVisible(false);
		}
	}
}
