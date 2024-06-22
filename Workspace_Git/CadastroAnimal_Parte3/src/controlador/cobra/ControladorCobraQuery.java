package controlador.cobra;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import entidade.Cobra;
import repositorio.cobra.CobraRepositorioImplementacao;
import servico.EntidadeServico;

public class ControladorCobraQuery implements ActionListener {

	TextField cafRecebido;
	JFrame frameDeletar;

	public ControladorCobraQuery(TextField cafRecebido, JFrame frameDeletar) {
		this.cafRecebido = cafRecebido;
		this.frameDeletar = frameDeletar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("PDF")) {
			CobraRepositorioImplementacao cobraRepositorio = new CobraRepositorioImplementacao();
			EntidadeServico entidadeServico = new EntidadeServico();
			Cobra cobra = new Cobra();

			if (cobraRepositorio.buscaCobraPorCaf(cafRecebido.getText()) != null) {
				cobra = cobraRepositorio.buscaCobraPorCaf(cafRecebido.getText());
				entidadeServico.gerarPdfDetalharCobra(cobra);
			} else {
				JOptionPane.showMessageDialog(null, "CAF para Cobra não encontrado! > " + cafRecebido.getText());
			}
		} else if (e.getActionCommand().equals("VOLTAR")) {
			frameDeletar.setVisible(false);
		}
	}
}
