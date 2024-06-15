package controlador.cachorro;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import entidade.Cachorro;
import interfaceGrafica.cachorro.CachorroFormUpdateManutencao;
import repositorio.cachorro.CachorroRepositorioImplementacao;

public class ControladorCachorroFormUpdateSelecao implements ActionListener {

	TextField campo_01; // CAF
	JFrame frameTela;
	CachorroRepositorioImplementacao cachorroRepositorio = new CachorroRepositorioImplementacao();
	CachorroFormUpdateManutencao cachorroFormUpdateManutencao = new CachorroFormUpdateManutencao();

	// Construtor
	public ControladorCachorroFormUpdateSelecao(TextField campo_01, JFrame frameTela) {
		this.campo_01 = campo_01; // CAF
		this.frameTela = frameTela;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Atualizar")) {
			Cachorro cachorro = new Cachorro();

			cachorro = cachorroRepositorio.buscaCachorroPorCaf(campo_01.getText());

			if (cachorro == null) {
				JOptionPane.showMessageDialog(null, "CAF para Cachorro não encontrado! > " + campo_01.getText());
			} else {

				JOptionPane.showMessageDialog(null, "CAF para Cachorro encontrado! > " + cachorro.getCaf());
				
				cachorroFormUpdateManutencao.montaCachorroFormManutencao(cachorro);
				frameTela.setVisible(false);
			}
		} else {
			// VOLTAR
			frameTela.setVisible(false);
		}
	}
}
