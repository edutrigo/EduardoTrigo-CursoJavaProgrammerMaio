package form.CorrentistaBasico;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.CorrentistaBasico.CtlFrmConsultaCorrentistaBasico;
import entity.EntCorrentistaBasico;
import entity.EntEndereco;

public class FrmConsultaCorrentistaBasico {

	public void ConsultaCorrentistaBasico(List<EntCorrentistaBasico> listaCorrentista) {

		int qtdRegistros = listaCorrentista.size();

		String[][] gridString = new String[qtdRegistros][10];

		int posColuna = 0;
		int posLinha = 0;

		for (EntCorrentistaBasico entCorrentistaBasico : listaCorrentista) {

			EntEndereco entEndereco = new EntEndereco();

			entEndereco = entCorrentistaBasico.getEndereco();

			gridString[posLinha][posColuna] = entCorrentistaBasico.getCpf().toString();
			posColuna++;

			gridString[posLinha][posColuna] = entCorrentistaBasico.getNome();
			posColuna++;

			gridString[posLinha][posColuna] = entEndereco.getCep();
			posColuna++;

			gridString[posLinha][posColuna] = entEndereco.getLogradouro();
			posColuna++;

			gridString[posLinha][posColuna] = entEndereco.getLocalidade();
			posColuna++;

			gridString[posLinha][posColuna] = entEndereco.getUf();
			posColuna++;

			gridString[posLinha][posColuna] = entCorrentistaBasico.getEmail();
			posColuna++;

			gridString[posLinha][posColuna] = Integer.toString(entCorrentistaBasico.getQtdTransacao());
			posColuna++;

			gridString[posLinha][posColuna] = Double.toString(entCorrentistaBasico.getValorAnuidade());
			posColuna++;

			gridString[posLinha][posColuna] = Double.toString(entCorrentistaBasico.getLimiteDeSaque());
			posColuna++;

			posLinha++;
			posColuna = 0;
		}

		JFrame frameCorrentista = new JFrame();
		frameCorrentista.setSize(1000, 250);

		String nomeColunas[] = { "Cpf", "Nome", "Cep", "Logradouro", "Localidade", "Uf", "Email", "QtdTrans", "ValAnui",
				"LimSaque" };

		JTable tbCorrentista = new JTable(gridString, nomeColunas);

		JScrollPane scrPanelCorrentista = new JScrollPane(tbCorrentista);

		scrPanelCorrentista.setPreferredSize(new Dimension(950, 150));

		JPanel pnCorrentista = new JPanel();

		pnCorrentista.add(scrPanelCorrentista);

		JTextField cpf = new JTextField(10);
		pnCorrentista.add(cpf);

		JButton botaoPDF = new JButton("PDF");
		pnCorrentista.add(botaoPDF);

		JButton botaoVoltar = new JButton("VOLTAR");
		pnCorrentista.add(botaoVoltar);

		frameCorrentista.add(pnCorrentista);

		CtlFrmConsultaCorrentistaBasico ctlFrmConsultaCorrentistaBasico = new CtlFrmConsultaCorrentistaBasico(cpf,
				frameCorrentista);
		botaoPDF.addActionListener(ctlFrmConsultaCorrentistaBasico);
		botaoVoltar.addActionListener(ctlFrmConsultaCorrentistaBasico);

		frameCorrentista.setVisible(true);
	}
}
