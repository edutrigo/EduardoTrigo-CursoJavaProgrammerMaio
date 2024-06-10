package controlador;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import entidade.Cachorro;

public class ControladorGridCachorro {

	public void GridCachorro(List<Cachorro> listaCahorro) {

		// Captura a quantidade de registros da matriz
		int qtdRegistros = listaCahorro.size();

		// Faz o dimencionamento da matriz, já fixando a quantidade de colunas "3"
		String[][] gridString = new String[qtdRegistros][3];

		// Inicializa contadores
		int posColuna = 0;
		int posLinha = 0;

		// Alimenta a matriz
		for (Cachorro cachorro : listaCahorro) {
			gridString[posLinha][posColuna] = cachorro.getCaf().toString();
			posColuna++;

			gridString[posLinha][posColuna] = cachorro.getNome();

			posColuna++;
			gridString[posLinha][posColuna] = cachorro.getCorPelo();

			posLinha++;
			posColuna = 0;
		}

		// Cria FRAME e faz o dimensionamento do mesmo
		JFrame frameGridCachorro = new JFrame();
		frameGridCachorro.setSize(500, 250);

		// Monta a "linha cabeçalho" do GRID
		String nomeColunas[] = { "CAF", "NOME", "COR PELO" };

		// Monta uma TABELA com os dados (gridString) e o cabeçalho (nomeColunas)
		JTable gridCachorro = new JTable(gridString, nomeColunas);

		// Configura a TABELA posição(x,y) e o tamanho(width/height) -- largura / altura
		// gridCachorro.setBounds(1, 1, 400, 400);

		// gridCachorro.setAutoscrolls(true);
		// gridCachorro.setSize(400, 200);

		// Cria objeto visual(GRID) para apresentar na tela
		JScrollPane scrollPaneGridCachorro = new JScrollPane(gridCachorro);

		scrollPaneGridCachorro.setPreferredSize(new Dimension(450, 185));
		
		// CRIA um PANEL
		JPanel panelGridCachorro = new JPanel();

		// Adiciona ao PANEL
		panelGridCachorro.add(scrollPaneGridCachorro);

		// Adiciona o PANEL ao FRAME
		frameGridCachorro.add(panelGridCachorro);

		// Deixa o FRAME visivel
		frameGridCachorro.setVisible(true);
	}
}
