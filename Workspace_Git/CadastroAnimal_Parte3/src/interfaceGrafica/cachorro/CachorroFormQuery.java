package interfaceGrafica.cachorro;

import java.awt.Dimension;
import java.awt.TextField;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controlador.cachorro.ControladorCachorroFormDelete;
import controlador.cachorro.ControladorCachorroQuery;
import entidade.Cachorro;

public class CachorroFormQuery {

	public void GridCachorro(List<Cachorro> listaCachorro) {
		// Captura a quantidade de registros da matriz
		int qtdRegistros = listaCachorro.size();

		// Faz o dimencionamento da matriz, já fixando a quantidade de colunas "3"
		String[][] gridString = new String[qtdRegistros][4];

		// Inicializa contadores
		int posColuna = 0;
		int posLinha = 0;

		// Alimenta a matriz
		for (Cachorro cachorro : listaCachorro) {
			gridString[posLinha][posColuna] = cachorro.getCaf().toString();
			posColuna++;

			gridString[posLinha][posColuna] = cachorro.getNome();

			posColuna++;
			gridString[posLinha][posColuna] = cachorro.getCorPelo();

			posColuna++;
			gridString[posLinha][posColuna] = cachorro.getPreco().toString();

			posLinha++;
			posColuna = 0;
		}

		// Cria FRAME e faz o dimensionamento do mesmo
		JFrame frameGridCachorro = new JFrame();
		frameGridCachorro.setSize(550, 250);

		// Monta a "linha cabeçalho" do GRID
		String nomeColunas[] = { "CAF", "NOME", "COR PELO", "PRECO" };

		// Monta uma TABELA com os dados (gridString) e o cabeçalho (nomeColunas)
		JTable gridCachorro = new JTable(gridString, nomeColunas);

		// Cria objeto visual(GRID) para apresentar na tela
		JScrollPane scrollPaneGridCachorro = new JScrollPane(gridCachorro);

		// Tamanho do GRID
		scrollPaneGridCachorro.setPreferredSize(new Dimension(500, 150));

		// CRIA um PANEL
		JPanel panelGridCachorro = new JPanel();

		// Adiciona ao PANEL
		panelGridCachorro.add(scrollPaneGridCachorro);

		TextField caf = new TextField(10);
		panelGridCachorro.add(caf);

		JButton botaoPDF = new JButton("PDF");
		panelGridCachorro.add(botaoPDF);

		JButton botaoVoltar = new JButton("VOLTAR");
		panelGridCachorro.add(botaoVoltar);

		// Adiciona o PANEL ao FRAME
		frameGridCachorro.add(panelGridCachorro);

		ControladorCachorroQuery controladorCachorroQuery = new ControladorCachorroQuery(caf, frameGridCachorro);
		botaoPDF.addActionListener(controladorCachorroQuery);
		botaoVoltar.addActionListener(controladorCachorroQuery);

		// Deixa o FRAME visivel
		frameGridCachorro.setVisible(true);
	}
}
