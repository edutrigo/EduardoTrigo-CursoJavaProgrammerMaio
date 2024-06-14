package interfaceGrafica.cachorro;

import java.awt.Dimension;
import java.awt.TextField;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controlador.cachorro.ControladorCachorroFormSelectUpdate;
import entidade.Cachorro;

public class CachorroFormSelectUpdate {

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
		frameGridCachorro.setSize(500, 300);

		// Monta a "linha cabeçalho" do GRID
		String nomeColunas[] = { "CAF", "NOME", "COR PELO" };

		// Monta uma TABELA com os dados (gridString) e o cabeçalho (nomeColunas)
		JTable gridCachorro = new JTable(gridString, nomeColunas);

		// Configura a TABELA posição(x,y) e o tamanho(width/height) -- largura / altura
		// gridCachorro.setBounds(1, 1, 400, 400);

		// Cria objeto visual(GRID) para apresentar na tela
		JScrollPane scrollPaneGridCachorro = new JScrollPane(gridCachorro);

		scrollPaneGridCachorro.setPreferredSize(new Dimension(450, 185));

		// CRIA um PANEL
		JPanel panelGridCachorro = new JPanel();

		// Adiciona ao PANEL
		panelGridCachorro.add(scrollPaneGridCachorro);

		// Adiciona o PANEL ao FRAME
		frameGridCachorro.add(panelGridCachorro);

		// Cria campo CAF para entrar como parâmetro
		TextField caf = new TextField(10);
		panelGridCachorro.add(caf);

		// Cria bot]ao DELETAR
		JButton botaoUpdate = new JButton("Atualizar");
		panelGridCachorro.add(botaoUpdate);

		JButton botaoVoltar = new JButton("Voltar");
		panelGridCachorro.add(botaoVoltar);

		ControladorCachorroFormSelectUpdate controladorCachorroFormUpdate = new ControladorCachorroFormSelectUpdate(caf,
				frameGridCachorro);

		botaoUpdate.addActionListener(controladorCachorroFormUpdate);

		botaoVoltar.addActionListener(controladorCachorroFormUpdate);

		// Deixa o FRAME visivel
		frameGridCachorro.setVisible(true);
	}
}
