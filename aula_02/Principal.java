import java.util.Scanner; //Objeto java padrao para receber dados atraves do teclado

public class Principal {

	public static void main(String args[]) {

		String v_nome; //Declaracao de variavel

		Atleta objAtleta = new Atleta(); //Inicializa objeto "objAtleta"

		Scanner objEntradaDeDados = new Scanner (System.in); //Objeto java padrao para receber dados atraves do teclado

		System.out.printf("Entre com o nome: "); //Display na tela

		objAtleta.v_nomeAtleta = objEntradaDeDados.next(); //Abre permissao para o usuario entrar com dados via teclado

		System.out.printf("Entre com a idade: "); //Display na tela

		objAtleta.v_idade = Integer.parseInt(objEntradaDeDados.next()); //Abre permissao para o usuario entrar com dados via teclado

		System.out.println("Nome:" + objAtleta.v_nomeAtleta + " - Idade:" + objAtleta.v_idade); //Display na tela com o resultado da entrada de dados


	}
}