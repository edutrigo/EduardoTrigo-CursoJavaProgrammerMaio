package controlador.cobra;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import entidade.Cobra;

public class ControladorCobraQuery {

	//
	// DENTRO DESTE CONTROLADOR JA TEM A TELA TAMBEM
	//

	public void GridCobra(List<Cobra> listaCobra) {

		// Captura a quantidade de registros da matriz
		int qtdRegistros = listaCobra.size();

		// Faz o dimencionamento da matriz, já fixando a quantidade de colunas "3"
		String[][] gridString = new String[qtdRegistros][3];

		// Inicializa contadores
		int posColuna = 0;
		int posLinha = 0;

		// Alimenta a matriz
		for (Cobra Cobra : listaCobra) {
			gridString[posLinha][posColuna] = Cobra.getCaf().toString();
			posColuna++;

			gridString[posLinha][posColuna] = Cobra.getNome();

			posColuna++;
			gridString[posLinha][posColuna] = Cobra.getTipoVeneno();

			posLinha++;
			posColuna = 0;
		}

		// Cria FRAME e faz o dimensionamento do mesmo
		JFrame frameGridCobra = new JFrame();
		frameGridCobra.setSize(500, 250);

		// Monta a "linha cabeçalho" do GRID
		String nomeColunas[] = { "CAF", "NOME", "TIPO VENENO" };

		// Monta uma TABELA com os dados (gridString) e o cabeçalho (nomeColunas)
		JTable gridCobra = new JTable(gridString, nomeColunas);

		// Configura a TABELA posição(x,y) e o tamanho(width/height) -- largura / altura
		// gridCobra.setBounds(1, 1, 400, 400);

		// gridCobra.setAutoscrolls(true);
		// gridCobra.setSize(400, 200);

		// Cria objeto visual(GRID) para apresentar na tela
		JScrollPane scrollPaneGridCobra = new JScrollPane(gridCobra);

		scrollPaneGridCobra.setPreferredSize(new Dimension(450, 185));

		// CRIA um PANEL
		JPanel panelGridCobra = new JPanel();

		// Adiciona o JScrollPane ao PANEL
		panelGridCobra.add(scrollPaneGridCobra);

		// Adiciona o PANEL ao FRAME
		frameGridCobra.add(panelGridCobra);

		// Deixa o FRAME visivel
		frameGridCobra.setVisible(true);
	}
}
