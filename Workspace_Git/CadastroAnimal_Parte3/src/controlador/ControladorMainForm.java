package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import bancoDados.DaoCachorro;
import bancoDados.DaoCobra;
import entidade.Cachorro;
import entidade.Cobra;
import interfaceGrafica.CachorroForm;
import interfaceGrafica.CobraForm;

public class ControladorMainForm implements ActionListener {

	JTextField boxTextOption;

	// Construtor
	public ControladorMainForm(JTextField boxTextOption) {
		this.boxTextOption = boxTextOption;
	}

	// Objetos Cachorro
	CachorroForm ScrCachorroForm = new CachorroForm();
	DaoCachorro daoCachorro = new DaoCachorro();
	List<Cachorro> listCachorro = new ArrayList<>();
	Cachorro cachorro = new Cachorro();

	// Objetos Cobra
	CobraForm ScrCobraForm = new CobraForm();
	DaoCobra daoCobra = new DaoCobra();
	List<Cobra> listCobra = new ArrayList<>();
	Cobra cobra = new Cobra();

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

			// Alimenta objeto "listCachorro" com o resultado do método "retQueryCachorro"
			listCachorro = daoCachorro.retQueryCachorro();

			// Cria objeto "controladorGridCachorro" para poder usar o método "GridCachorro" e passar o conteúdo do "listCachorro"
			// No método "GridCachorro" irá alimentar um JTable e montar a tela
			ControladorGridCachorro controladorGridCachorro = new ControladorGridCachorro();
			controladorGridCachorro.GridCachorro(listCachorro);
			/*
			 * StringBuilder aux = new StringBuilder();
			 * 
			 * for (Cachorro cachorroReg : listCachorro) {
			 * 
			 * aux.delete(0, 5000);
			 * 
			 * aux.append(cachorroReg.getCaf()).append("\n").append(cachorroReg.getNome()).
			 * append("\n") .append(cachorroReg.getCorPelo());
			 * 
			 * JOptionPane.showMessageDialog(null, aux.toString()); }
			 * 
			 * JOptionPane.showMessageDialog(null, "FIM CADASTRO CACHORRO...");
			 */
			break;
		}

		case "4": {
			// Lista Cobra

			// Alimenta objeto "listCobra" com o resultado do método "retQueryCobra"
			listCobra = daoCobra.retQueryCobra();

			// Cria objeto "controladorGridCobra" para poder usar o método "GridCobra" e passar o conteúdo do "listCobra"
			// No método "GridCobra" irá alimentar um JTable e montar a tela
			ControladorGridCobra controladorGridCobra = new ControladorGridCobra();
			controladorGridCobra.GridCobra(listCobra);
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
