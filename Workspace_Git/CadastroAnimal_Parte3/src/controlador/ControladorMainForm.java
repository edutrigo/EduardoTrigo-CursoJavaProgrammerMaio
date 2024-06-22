package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import bancoDados.dao.DaoCachorro;
import bancoDados.dao.DaoCobra;
import controlador.cachorro.ControladorCachorroQuery;
import controlador.cobra.ControladorCobraQuery;
import entidade.Cachorro;
import entidade.Cobra;
import interfaceGrafica.cachorro.CachorroFormInsert;
import interfaceGrafica.cachorro.CachorroFormQuery;
import interfaceGrafica.cachorro.CachorroFormDelete;
import interfaceGrafica.cachorro.CachorroFormUpdateSelecao;
import interfaceGrafica.cobra.CobraFormInsert;
import interfaceGrafica.cobra.CobraFormUpdateSelecao;
import interfaceGrafica.cobra.CobraFormDelete;
import repositorio.cachorro.CachorroRepositorioImplementacao;
import repositorio.cobra.CobraRepositorioImplementacao;

public class ControladorMainForm implements ActionListener {

	JTextField boxTextOption;

	// Construtor
	public ControladorMainForm(JTextField boxTextOption) {
		this.boxTextOption = boxTextOption;
	}

	// Objetos Cachorro
	CachorroFormInsert ScrCachorroForm = new CachorroFormInsert();
	DaoCachorro daoCachorro = new DaoCachorro();
	List<Cachorro> listCachorro = new ArrayList<>();
	Cachorro cachorro = new Cachorro();

	// Objetos Cobra
	CobraFormInsert ScrCobraForm = new CobraFormInsert();
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

			// Alimenta objeto "listCobra" com o resultado do método "retQueryCachorro"
			listCachorro = daoCachorro.retQueryCachorro();

			// Cria objeto "controladorGridCachorro" para poder usar o método "GridCachorro"
			// e passar o conteúdo do "listCobra"
			// No método "GridCachorro" irá alimentar um JTable e montar a tela
			CachorroFormQuery cachorroFormQuery = new CachorroFormQuery();
			cachorroFormQuery.GridCachorro(listCachorro);
			/*
			 * StringBuilder aux = new StringBuilder();
			 * 
			 * for (Cachorro cachorroReg : listCobra) {
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

			// Cria objeto "controladorGridCobra" para poder usar o método "GridCobra" e
			// passar o conteúdo do "listCobra"
			// No método "GridCobra" irá alimentar um JTable e montar a tela
			ControladorCobraQuery controladorGridCobra = new ControladorCobraQuery();
			controladorGridCobra.GridCobra(listCobra);
			break;
		}

		case "5": {
			// Exclui Cachorro
			CachorroRepositorioImplementacao cachorroRepositorioImplementacao = new CachorroRepositorioImplementacao();

			listCachorro = cachorroRepositorioImplementacao.retQueryCachorro();

			CachorroFormDelete cachorroFormDelete = new CachorroFormDelete();

			cachorroFormDelete.GridCachorro(listCachorro);
			break;
		}

		case "6": {
			// Exclui Cobra
			CobraRepositorioImplementacao cobraRepositorioImplementacao = new CobraRepositorioImplementacao();

			listCobra = cobraRepositorioImplementacao.retQueryCobra();

			CobraFormDelete cobraFormDelete = new CobraFormDelete();

			cobraFormDelete.GridCobra(listCobra);
			break;
		}

		case "7": {
			// ALTERA CACHORRO
			CachorroRepositorioImplementacao cachorroRepositorioImplementacao = new CachorroRepositorioImplementacao();

			listCachorro = cachorroRepositorioImplementacao.retQueryCachorro();

			CachorroFormUpdateSelecao cachorroFormSelectUpdate = new CachorroFormUpdateSelecao();

			cachorroFormSelectUpdate.GridCachorro(listCachorro);
			break;
		}

		case "8": {
			// ALTERA COBRA
			CobraRepositorioImplementacao cobraRepositorioImplementacao = new CobraRepositorioImplementacao();

			listCobra = cobraRepositorioImplementacao.retQueryCobra();

			CobraFormUpdateSelecao cobraFormSelectUpdate = new CobraFormUpdateSelecao();

			cobraFormSelectUpdate.GridCobra(listCobra);
			break;
		}

		case "X": {
			System.exit(0);
			break;
		}
		case "x": {
			System.exit(0);
			break;
		}
		default:
			JOptionPane.showMessageDialog(null, "Somente as opções [1-5] ou 'X' são Válidas...");
			boxTextOption.setText(null);
		}
	}
}
