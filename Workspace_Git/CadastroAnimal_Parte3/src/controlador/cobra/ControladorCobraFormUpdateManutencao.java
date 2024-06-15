package controlador.cobra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.Cobra;
import repositorio.cobra.CobraRepositorioImplementacao;

public class ControladorCobraFormUpdateManutencao implements ActionListener {

	CobraRepositorioImplementacao cobraRepositorio = new CobraRepositorioImplementacao();

	Cobra cobraUpdate = new Cobra();

	JTextField labelCampo01;
	JTextField labelCampo02;
	int caf;
	JFrame frmCobraForm;

	// Construtor
	public ControladorCobraFormUpdateManutencao(JTextField labelCampo01, JTextField labelCampo02, int caf,
			JFrame frmCobraForm) {
		this.labelCampo01 = labelCampo01; // NOME
		this.labelCampo02 = labelCampo02; // TIPO VENENO
		this.caf = caf; // CAF
		this.frmCobraForm = frmCobraForm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (labelCampo01.getText().equals("")) {

			JOptionPane.showMessageDialog(null, "Campo 'NOME' não pode ficar" + "\n" + "em branco!");

		} else if (labelCampo02.getText().equals("")) {

			JOptionPane.showMessageDialog(null, "Campo 'TipoVeneno' não pode ficar" + "\n" + "em branco!");

		} else {
			// SALVE EM BANCO DE DADOS - ATRAVES DA INTERFACE

			cobraUpdate.setCaf(caf);
			cobraUpdate.setNome(labelCampo01.getText());
			cobraUpdate.setTipoVeneno(labelCampo02.getText());

			cobraRepositorio.updateCobraBD(cobraUpdate);

			JOptionPane.showMessageDialog(null, "Atualização do Cobra" + "\n" + "efetuado com sucesso!");

			frmCobraForm.setVisible(false);
		}
	}
}
