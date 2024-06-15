package controlador.cachorro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.Cachorro;
import repositorio.cachorro.CachorroRepositorioImplementacao;

public class ControladorCachorroFormUpdateManutencao implements ActionListener {

	CachorroRepositorioImplementacao cachorroRepositorio = new CachorroRepositorioImplementacao();

	Cachorro cachorroUpdate = new Cachorro();

	JTextField labelCampo01;
	JTextField labelCampo02;
	int caf;
	JFrame frmCachorroForm;

	// Construtor
	public ControladorCachorroFormUpdateManutencao(JTextField labelCampo01, JTextField labelCampo02, int caf,
			JFrame frmCachorroForm) {
		this.labelCampo01 = labelCampo01; // NOME
		this.labelCampo02 = labelCampo02; // COR DO PELO
		this.caf = caf; // CAF
		this.frmCachorroForm = frmCachorroForm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (labelCampo01.getText().equals("")) {

			JOptionPane.showMessageDialog(null, "Campo 'NOME' não pode ficar" + "\n" + "em branco!");

		} else if (labelCampo02.getText().equals("")) {

			JOptionPane.showMessageDialog(null, "Campo 'CorPelo' não pode ficar" + "\n" + "em branco!");

		} else {
			// SALVE EM BANCO DE DADOS - ATRAVES DA INTERFACE

			cachorroUpdate.setCaf(caf);
			cachorroUpdate.setNome(labelCampo01.getText());
			cachorroUpdate.setCorPelo(labelCampo02.getText());

			cachorroRepositorio.updateCachorroBD(cachorroUpdate);

			JOptionPane.showMessageDialog(null, "Atualização do Cachorro" + "\n" + "efetuado com sucesso!");

			frmCachorroForm.setVisible(false);
		}
	}
}
