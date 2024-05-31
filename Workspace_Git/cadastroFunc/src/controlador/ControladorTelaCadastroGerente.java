package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import entidades.Gerente;
import gerenciaArquivo.ManipuladorArquivo;

public class ControladorTelaCadastroGerente implements ActionListener {

	JTextField nome;
	JTextField cpf;
	JTextField gerencia;
	
	ManipuladorArquivo arquivo = new ManipuladorArquivo();
	


	public ControladorTelaCadastroGerente(JTextField nome, JTextField cpf, JTextField gerencia) {
		this.nome = nome;
		this.cpf = cpf;
		this.gerencia = gerencia;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		registrarGerente();
	}
	
	public void registrarGerente() {
		Gerente gerente = new Gerente();
		gerente.setNome(nome.getText());
		gerente.setCpf(cpf.getText());
		gerente.setGerencia(gerencia.getText());
		arquivo.registrarGerente(gerente);
	}

}
