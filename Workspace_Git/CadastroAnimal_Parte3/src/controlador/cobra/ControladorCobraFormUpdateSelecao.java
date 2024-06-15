package controlador.cobra;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import entidade.Cobra;
import interfaceGrafica.cobra.CobraFormUpdateManutencao;
import repositorio.cobra.CobraRepositorioImplementacao;

public class ControladorCobraFormUpdateSelecao implements ActionListener {

	TextField campo_01; // CAF
	JFrame frameTela;
	CobraRepositorioImplementacao cobraRepositorio = new CobraRepositorioImplementacao();
	CobraFormUpdateManutencao cobraFormUpdateManutencao = new CobraFormUpdateManutencao();

	// Construtor
	public ControladorCobraFormUpdateSelecao(TextField campo_01, JFrame frameTela) {
		this.campo_01 = campo_01; // CAF
		this.frameTela = frameTela;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Atualizar")) {
			Cobra cobra = new Cobra();

			cobra = cobraRepositorio.buscaCobraPorCaf(campo_01.getText());

			if (cobra == null) {
				JOptionPane.showMessageDialog(null, "CAF para Cobra não encontrado! > " + campo_01.getText());
			} else {

				JOptionPane.showMessageDialog(null, "CAF para Cobra encontrado! > " + cobra.getCaf());

				cobraFormUpdateManutencao.montaCobraFormManutencao(cobra);
				frameTela.setVisible(false);
			}
		} else {
			// VOLTAR
			frameTela.setVisible(false);
		}
	}
}
