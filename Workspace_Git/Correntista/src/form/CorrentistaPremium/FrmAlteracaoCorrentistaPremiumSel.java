package form.CorrentistaPremium;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.CorrentistaPremium.CtlFrmAlteracaoCorrentistaPremiumSel;
import entity.EntCorrentistaPremium;
import entity.EntEndereco;

public class FrmAlteracaoCorrentistaPremiumSel {

	public void alteracaoCorrentistaSel(List<EntCorrentistaPremium> listaCorrentista) {

		int qtdRegistros = listaCorrentista.size();

		String[][] gridString = new String[qtdRegistros][10];

		int posColuna = 0;
		int posLinha = 0;

		for (EntCorrentistaPremium entCorrentistaPremium : listaCorrentista) {

			EntEndereco entEndereco = new EntEndereco();

			entEndereco = entCorrentistaPremium.getEndereco();

			gridString[posLinha][posColuna] = entCorrentistaPremium.getCpf().toString();
			posColuna++;

			gridString[posLinha][posColuna] = entCorrentistaPremium.getNome();
			posColuna++;

			gridString[posLinha][posColuna] = entEndereco.getCep();
			posColuna++;

			gridString[posLinha][posColuna] = entEndereco.getLogradouro();
			posColuna++;

			gridString[posLinha][posColuna] = entEndereco.getLocalidade();
			posColuna++;

			gridString[posLinha][posColuna] = entEndereco.getUf();
			posColuna++;

			gridString[posLinha][posColuna] = entCorrentistaPremium.getEmail();
			posColuna++;

			gridString[posLinha][posColuna] = Integer.toString(entCorrentistaPremium.getQtdTransacao());
			posColuna++;

			gridString[posLinha][posColuna] = Double.toString(entCorrentistaPremium.getValorAnuidade());
			posColuna++;

			gridString[posLinha][posColuna] = Double.toString(entCorrentistaPremium.getLimiteDeCredito());
			posColuna++;

			posLinha++;
			posColuna = 0;
		}

		JFrame frameCorrentista = new JFrame();
		frameCorrentista.setSize(1000, 250);

		String nomeColunas[] = { "Cpf", "Nome", "Cep", "Logradouro", "Localidade", "Uf", "Email", "QtdTrans", "ValAnui",
				"LimCredito" };

		JTable tbCorrentista = new JTable(gridString, nomeColunas);

		JScrollPane scrPanelCorrentista = new JScrollPane(tbCorrentista);

		scrPanelCorrentista.setPreferredSize(new Dimension(950, 150));

		JPanel pnCorrentista = new JPanel();

		pnCorrentista.add(scrPanelCorrentista);

		JTextField cpf = new JTextField(10);
		pnCorrentista.add(cpf);

		JButton botaoExcluir = new JButton("ALTERAR");
		pnCorrentista.add(botaoExcluir);

		JButton botaoVoltar = new JButton("VOLTAR");
		pnCorrentista.add(botaoVoltar);

		frameCorrentista.add(pnCorrentista);

		CtlFrmAlteracaoCorrentistaPremiumSel ctlFrmAlteracaoCorrentistaPremiumSel = new CtlFrmAlteracaoCorrentistaPremiumSel(
				cpf, frameCorrentista);
		botaoExcluir.addActionListener(ctlFrmAlteracaoCorrentistaPremiumSel);
		botaoVoltar.addActionListener(ctlFrmAlteracaoCorrentistaPremiumSel);

		frameCorrentista.setVisible(true);
	}
}
