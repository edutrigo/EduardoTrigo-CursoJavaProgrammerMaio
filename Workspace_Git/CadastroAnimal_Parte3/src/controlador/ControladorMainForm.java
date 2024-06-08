package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import bancoDados.DaoCachorro;
import entidade.Cachorro;
import interfaceGrafica.CachorroForm;
import interfaceGrafica.CobraForm;

public class ControladorMainForm implements ActionListener {

	JTextField boxTextOption;

	// Construtor
	public ControladorMainForm(JTextField boxTextOption) {
		this.boxTextOption = boxTextOption;
	}

	CachorroForm ScrCachorroForm = new CachorroForm();
	CobraForm ScrCobraForm = new CobraForm();
	DaoCachorro daoCachorro = new DaoCachorro();
	List<Cachorro> listCachorro = new ArrayList<>();
	Cachorro cachorro = new Cachorro();

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (boxTextOption.getText()) {
		case "1": {
			// Cadastro de Cachorro
			ScrCachorroForm.montaCachorroForm();
			break;
		}
		case "2": {
			// Cadastro de Cobra
			ScrCobraForm.montaCobraForm();
			break;
		}
		case "3": {
			// Lista Cachorro
			listCachorro = daoCachorro.retQueryCachorro();

			StringBuilder aux = new StringBuilder();

			for (Cachorro cachorroReg : listCachorro) {

				aux.delete(0, 5000);

				aux.append(cachorroReg.getCaf()).append("\n").append(cachorroReg.getNome()).append("\n")
						.append(cachorroReg.getCorPelo());

				JOptionPane.showMessageDialog(null, aux.toString());
			}

			JOptionPane.showMessageDialog(null, "FIM CADASTRO CACHORRO...");

			break;
		}

		case "4": {
			// Lista Cobra
			break;
		}

		case "5": {
			System.exit(0);
			break;
		}
		default:
			JOptionPane.showMessageDialog(null, "Somente as opções [1-5] são Válidas...");
			boxTextOption.setText(null);
		}
	}
}
