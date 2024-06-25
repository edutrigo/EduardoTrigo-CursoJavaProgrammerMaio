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
}
