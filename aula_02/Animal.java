import java.util.Scanner; //Objeto java padrao para receber dados atraves do teclado

public class Animal {

	public static void main(String args[]) {

		Atleta objAnimal = new Atleta(); //Inicializa objeto "objAtleta"

		Scanner objEntradaDeDados = new Scanner (System.in); //Objeto java padrao para receber dados atraves do teclado

		System.out.printf("Entre com o nome animal: "); //Display na tela

		objAnimal.v_nomeAtleta = objEntradaDeDados.next(); //Abre permissao para o usuario entrar com dados via teclado

		System.out.printf("Entre com a idade animal: "); //Display na tela

		objAnimal.v_idade = Integer.parseInt(objEntradaDeDados.next()); //Abre permissao para o usuario entrar com dados via teclado

		System.out.println("Nome Animal:" + objAnimal.v_nomeAtleta + " - Idade:" + objAnimal.v_idade); //Display na tela com o resultado da entrada de dados

	}
}