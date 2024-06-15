package interfaceGrafica.cobra;

import java.awt.Dimension;
import java.awt.TextField;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controlador.cobra.ControladorCobraFormUpdateSelecao;
import entidade.Cobra;

public class CobraFormUpdateSelecao {

	public void GridCobra(List<Cobra> listaCobra) {

		// Captura a quantidade de registros da matriz
		int qtdRegistros = listaCobra.size();

		// Faz o dimencionamento da matriz, já fixando a quantidade de colunas "3"
		String[][] gridString = new String[qtdRegistros][3];

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

			posLinha++;
			posColuna = 0;
		}

		// Cria FRAME e faz o dimensionamento do mesmo
		JFrame frameGridCobra = new JFrame();
		frameGridCobra.setSize(500, 300);

		// Monta a "linha cabeçalho" do GRID
		String nomeColunas[] = { "CAF", "NOME", "TIPO VENENO" };

		// Monta uma TABELA com os dados (gridString) e o cabeçalho (nomeColunas)
		JTable gridCobra = new JTable(gridString, nomeColunas);

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
		JButton botaoUpdate = new JButton("Atualizar");
		panelGridCobra.add(botaoUpdate);

		JButton botaoVoltar = new JButton("Voltar");
		panelGridCobra.add(botaoVoltar);

		ControladorCobraFormUpdateSelecao controladorCobraFormUpdate = new ControladorCobraFormUpdateSelecao(caf,
				frameGridCobra);

		botaoUpdate.addActionListener(controladorCobraFormUpdate);

		botaoVoltar.addActionListener(controladorCobraFormUpdate);

		// Deixa o FRAME visivel
		frameGridCobra.setVisible(true);
	}
}
