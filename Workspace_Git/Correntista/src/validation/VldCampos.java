package validation;

import javax.swing.JOptionPane;

public class VldCampos {

	public boolean campoInteger(String campoString) {

		int campoInteger;

		try {
			campoInteger = Integer.parseInt(campoString);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public boolean campoDouble(String campoString) {

		Double campoDouble;
		try {
			campoDouble = Double.parseDouble(campoString);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public boolean campoNullBranco(String campo) {
		return campo == null || campo.isEmpty();
	}

	public boolean VldAddModifiedField(String nome, String cpf, String cep, String email, String qtdTransacao,
			String limSaque) {
		VldCampos vldCampos = new VldCampos();

		if (vldCampos.campoNullBranco(nome)) {
			JOptionPane.showMessageDialog(null, "Campo 'Nome' não pode ficar em branco.");
			return false;
		}

		else if (vldCampos.campoNullBranco(cpf)) {
			JOptionPane.showMessageDialog(null, "Campo 'CPF' não pode ficar em branco.");
			return false;
		}

		else if (vldCampos.campoNullBranco(cep)) {
			JOptionPane.showMessageDialog(null, "Campo 'CEP' não pode ficar em branco.");
			return false;
		}

		else if (vldCampos.campoNullBranco(email)) {
			JOptionPane.showMessageDialog(null, "Campo 'eMail' não pode ficar em branco.");
			return false;
		}

		else if (vldCampos.campoNullBranco(qtdTransacao)) {
			JOptionPane.showMessageDialog(null, "Campo 'Qtd Transação' não pode ficar em branco.");
			return false;
		} else if (vldCampos.campoNullBranco(limSaque)) {
			JOptionPane.showMessageDialog(null, "Campo 'Lim Saque' não pode ficar em branco.");
			return false;
		} else {
			if (vldCampos.campoDouble(cpf) == false) {
				JOptionPane.showMessageDialog(null, "Campo 'CPF' só pode contem números.");
				return false;

			} else if (vldCampos.campoInteger(cep) == false) {
				JOptionPane.showMessageDialog(null, "Campo 'CEP' só pode contem números.");
				return false;

			} else if (vldCampos.campoInteger(qtdTransacao) == false) {
				JOptionPane.showMessageDialog(null, "Campo 'Qtd Transação' só pode contem números.");
				return false;

			} else if (vldCampos.campoDouble(limSaque) == false) {
				JOptionPane.showMessageDialog(null, "Campo 'Lim Saque' só pode contem números.");
				return false;
			} else {
				return true;
			}
		}
	}
}
