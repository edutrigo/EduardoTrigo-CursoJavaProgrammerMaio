package interfaceGrafica;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.ControladorTelaPrincipal;

public class TelaPrincipal {
	
	public void menuPrincipal() {
		
		JFrame frameMenuprincipal = new JFrame();// Frame da tela
		frameMenuprincipal.setSize(200,200); //Informa largura e altura
		
		JPanel panelMenuPrincipal = new JPanel();// Painel onde iremos agrupar os componentes
		
		JLabel labelOpcao1 = new JLabel("1 - PARA MENU GERENTE");//LABEL DA PRIMEIRA OPÇÃO
		panelMenuPrincipal.add(labelOpcao1);// Adiciona o labelOpcao1 no painel
		
		JLabel labelOpcao2 = new JLabel("2 - PARA MENU ATENDENTE");//LABEL DA PRIMEIRA OPÇÃO
		panelMenuPrincipal.add(labelOpcao2);// Adiciona o labelOpcao1 no painel
		
		JTextField caixaTextoOpcao = new JTextField(10);//Caixa de texto
		panelMenuPrincipal.add(caixaTextoOpcao);//Adiciona a caixa de texto no painel caixaTextoOpcao
		
		JButton botaoEnviar = new JButton("Enviar"); //Cria o botão com o valor Enviar
		panelMenuPrincipal.add(botaoEnviar);// Adiciona o botão no painel

		frameMenuprincipal.add(panelMenuPrincipal);//Adicionando o painel no frame
		frameMenuprincipal.setVisible(true); //Tornando o frame visivel 
		
		ControladorTelaPrincipal controladorTelaPrincipal = new ControladorTelaPrincipal(caixaTextoOpcao, frameMenuprincipal);//Criando o controlador já com o valor que foi digitado
		botaoEnviar.addActionListener(controladorTelaPrincipal);// Inserindo o controlador no botão
		
		
		
	}
	
	

}
