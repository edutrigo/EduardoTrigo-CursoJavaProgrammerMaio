package cadastroAtleta;

import java.util.Scanner; //Objeto java padrao para receber dados atraves do teclado
import entidade.Atleta;

public class Principal {

	public static void main(String[] args) {
		Atleta objAtleta = new Atleta();
		
		Scanner objEntradaDados = new Scanner(System.in);
		
		System.out.println( "Informe o nome do Atleta:");
		objAtleta.v_nome = objEntradaDados.next();
		
		System.out.println( "Informe a idade do Atleta:");
		objAtleta.v_idade = Integer.parseInt(objEntradaDados.next());

		System.out.println( "Informe a qtd de partidas:");
		objAtleta.v_qtd_partidas = Integer.parseInt(objEntradaDados.next());

		objAtleta.v_salario = calcularSalario(objAtleta.v_qtd_partidas);
		
		//imprimir( objAtleta );
		
		imprimirResultadosNoConsole(objAtleta); // Chamo a execução do metodo para imprimir os resultados
	}

	public static void imprimirResultadosNoConsole(Atleta objAtleta) {
		//Resultado Final
		System.out.println("Dados..."); //Display na tela
		System.out.println("Nome:" + objAtleta.v_nome + " - Idade:" + objAtleta.v_idade + " - Perna:" + objAtleta.v_salario );
		}

	public static Double calcularSalario(int qtdPartida) {
		
		double salario = qtdPartida * 10000;
		
		return salario;
	}

}
