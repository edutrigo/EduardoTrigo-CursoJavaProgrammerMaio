import java.util.Scanner; //Objeto java padrao para receber dados atraves do teclado

public class Principal {

	public static void main(String args[]) {

		String v_nome; //Declaracao de variavel

		Scanner entradaDeDados = new Scanner (System.in); //Objeto java padrao para receber dados atraves do teclado

		System.out.printf("Entre com o nome: "); //Display na tela

		v_nome = entradaDeDados.next(); //Abre permissao para o usuario entrar com dados via teclado

		System.out.println("Voce digitou: ".concat(v_nome)); //Display na tela com o resultado da entrada de dados
	}
}