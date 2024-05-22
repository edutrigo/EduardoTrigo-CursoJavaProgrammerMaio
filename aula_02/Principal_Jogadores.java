import java.util.Scanner; //Objeto java padrao para receber dados atraves do teclado

public class Principal_Jogadores {

	public static void main(String args[]) {

		JogadorFutebol objJogadorFutebol = new JogadorFutebol();   //Inicializa objeto "objAtleta"
		JogadorVolei   objJogadorVolei   = new JogadorVolei();     //Inicializa objeto "objAtleta"
		Scanner        objEntradaDeDados = new Scanner(System.in); //Objeto java padrao para receber dados atraves do teclado

		//Jogador de Futebol
		System.out.println("Entre com os dados do Jogador de Futebol..."); //Display na tela

		System.out.printf("Entre com o nome: "); //Display na tela
		objJogadorFutebol.v_nomeAtleta = objEntradaDeDados.next(); //Abre permissao para o usuario entrar com dados via teclado

		System.out.printf("Entre com a idade: "); //Display na tela
		objJogadorFutebol.v_idade = Integer.parseInt(objEntradaDeDados.next()); //Abre permissao para o usuario entrar com dados via teclado

		System.out.printf("Entre com a perna mais forte: "); //Display na tela
		objJogadorFutebol.v_pernaMaisForte = objEntradaDeDados.next(); //Abre permissao para o usuario entrar com dados via teclado

		//Jogador de Volei
		System.out.println(" "); //Display na tela
		System.out.println("Entre com os dados do Jogador de Volei..."); //Display na tela

		System.out.printf("Entre com o nome: "); //Display na tela
		objJogadorVolei.v_nomeAtleta = objEntradaDeDados.next(); //Abre permissao para o usuario entrar com dados via teclado

		System.out.printf("Entre com a idade: "); //Display na tela
		objJogadorVolei.v_idade = Integer.parseInt(objEntradaDeDados.next()); //Abre permissao para o usuario entrar com dados via teclado

		System.out.printf("Entre com a perna mais forte: "); //Display na tela
		objJogadorVolei.v_bracoMaisForte = objEntradaDeDados.next(); //Abre permissao para o usuario entrar com dados via teclado

		imprimir(objJogadorFutebol, objJogadorVolei);
	}

	public static void imprimir(JogadorFutebol objJogadorFutebol
	                           ,JogadorVolei   objJogadorVolei) {
		//Resultado Final
		System.out.println(" "); //Display na tela
		System.out.println("Dados Futebol..."); //Display na tela
		System.out.println("Nome:" + objJogadorFutebol.v_nomeAtleta + " - Idade:" + objJogadorFutebol.v_idade + " - Perna:" + objJogadorFutebol.v_pernaMaisForte );

		System.out.println(" "); //Display na tela
		System.out.println("Dados Volei..."); //Display na tela
		System.out.println("Nome:" + objJogadorVolei.v_nomeAtleta + " - Idade:" + objJogadorVolei.v_idade + " - Braco:" + objJogadorVolei.v_bracoMaisForte );
	}
}