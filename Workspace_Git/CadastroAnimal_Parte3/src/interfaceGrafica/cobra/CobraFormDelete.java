package interfaceGrafica.cobra;

import java.awt.Dimension;
import java.awt.TextField;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controlador.cobra.ControladorCobraFormDelete;
import entidade.Cobra;

public class CobraFormDelete {

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
		frameGridCobra.setSize(500, 300);

		// Monta a "linha cabeçalho" do GRID
		String nomeColunas[] = { "CAF", "NOME", "TP VENENO" };

		// Monta uma TABELA com os dados (gridString) e o cabeçalho (nomeColunas)
		JTable gridCobra = new JTable(gridString, nomeColunas);

		// Configura a TABELA posição(x,y) e o tamanho(width/height) -- largura / altura
		// gridCobra.setBounds(1, 1, 400, 400);

		// Cria objeto visual(GRID) para apresentar na tela
		JScrollPane scrollPaneGridCobra = new JScrollPane(gridCobra);

		scrollPaneGridCobra.setPreferredSize(new Dimension(450, 185));

		// CRIA um PANEL
		JPanel panelGridCobra = new JPanel();

		// Adiciona ao PANEL
		panelGridCobra.add(scrollPaneGridCobra);

		// Adiciona o PANEL ao FRAME
		frameGridCobra.add(panelGridCobra);

		// Cria campo CAF para entrar como parâmetro
		TextField caf = new TextField(10);
		panelGridCobra.add(caf);

		// Cria bot]ao DELETAR
		JButton botaoDeletar = new JButton("Deletar");
		panelGridCobra.add(botaoDeletar);

		ControladorCobraFormDelete controladorCobraFormDeletar = new ControladorCobraFormDelete(caf, frameGridCobra);
		botaoDeletar.addActionListener(controladorCobraFormDeletar);
		
		// Deixa o FRAME visivel
		frameGridCobra.setVisible(true);
	}
}
