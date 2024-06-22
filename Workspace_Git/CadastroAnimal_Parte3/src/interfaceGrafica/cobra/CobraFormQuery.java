package interfaceGrafica.cobra;

import java.awt.Dimension;
import java.awt.TextField;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controlador.cobra.ControladorCobraQuery;
import entidade.Cobra;

public class CobraFormQuery {

	public void GridCobra(List<Cobra> listaCobra) {
		// Captura a quantidade de registros da matriz
		int qtdRegistros = listaCobra.size();

		// Faz o dimencionamento da matriz, já fixando a quantidade de colunas "3"
		String[][] gridString = new String[qtdRegistros][4];

		// Inicializa contadores
		int posColuna = 0;
		int posLinha = 0;

		// Alimenta a matriz
		for (Cobra cobra : listaCobra) {
			gridString[posLinha][posColuna] = cobra.getCaf().toString();
			posColuna++;

			gridString[posLinha][posColuna] = cobra.getNome();

			posColuna++;
			gridString[posLinha][posColuna] = cobra.getTipoVeneno();

			posColuna++;
			gridString[posLinha][posColuna] = cobra.getPreco().toString();

			posLinha++;
			posColuna = 0;
		}

		// Cria FRAME e faz o dimensionamento do mesmo
		JFrame frameGridCobra = new JFrame();
		frameGridCobra.setSize(550, 250);

		// Monta a "linha cabeçalho" do GRID
		String nomeColunas[] = { "CAF", "NOME", "TP VENENO", "PRECO" };

		// Monta uma TABELA com os dados (gridString) e o cabeçalho (nomeColunas)
		JTable gridCobra = new JTable(gridString, nomeColunas);

		// Cria objeto visual(GRID) para apresentar na tela
		JScrollPane scrollPaneGridCobra = new JScrollPane(gridCobra);

		// Tamanho do GRID
		scrollPaneGridCobra.setPreferredSize(new Dimension(500, 150));

		// CRIA um PANEL
		JPanel panelGridCobra = new JPanel();

		// Adiciona ao PANEL
		panelGridCobra.add(scrollPaneGridCobra);

		TextField caf = new TextField(10);
		panelGridCobra.add(caf);

		JButton botaoPDF = new JButton("PDF");
		panelGridCobra.add(botaoPDF);

		JButton botaoVoltar = new JButton("VOLTAR");
		panelGridCobra.add(botaoVoltar);

		// Adiciona o PANEL ao FRAME
		frameGridCobra.add(panelGridCobra);

		ControladorCobraQuery controladorCobraQuery = new ControladorCobraQuery(caf, frameGridCobra);
		botaoPDF.addActionListener(controladorCobraQuery);
		botaoVoltar.addActionListener(controladorCobraQuery);

		// Deixa o FRAME visivel
		frameGridCobra.setVisible(true);
	}
}
