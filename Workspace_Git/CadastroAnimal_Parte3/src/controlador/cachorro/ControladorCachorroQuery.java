package controlador.cachorro;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import entidade.Cachorro;
import repositorio.cachorro.CachorroRepositorioImplementacao;
import servico.EntidadeServico;

public class ControladorCachorroQuery implements ActionListener {

	TextField cafRecebido;
	JFrame frameDeletar;

	public ControladorCachorroQuery(TextField cafRecebido, JFrame frameDeletar) {
		this.cafRecebido = cafRecebido;
		this.frameDeletar = frameDeletar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("PDF")) {
			CachorroRepositorioImplementacao cachorroRepositorio = new CachorroRepositorioImplementacao();
			EntidadeServico entidadeServico = new EntidadeServico();
			Cachorro cachorro = new Cachorro();

			if (cachorroRepositorio.buscaCachorroPorCaf(cafRecebido.getText()) != null) {
				cachorro = cachorroRepositorio.buscaCachorroPorCaf(cafRecebido.getText());
				entidadeServico.gerarPdfDetalharCachorro(cachorro);
			} else {
				JOptionPane.showMessageDialog(null, "CAF para Cachorro não encontrado! > " + cafRecebido.getText());
			}
		} else if (e.getActionCommand().equals("VOLTAR")) {
			frameDeletar.setVisible(false);
		}
	}
}
