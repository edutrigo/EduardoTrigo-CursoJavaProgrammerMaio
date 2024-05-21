import java.util.Scanner;

public class Principal {

	public static void main(String args[]) {

		String v_nome;

		Scanner entradaDeDados = new Scanner (System.in);

		System.out.printf("Entre com o nome: ");

		v_nome = entradaDeDados.next();

		System.out.println("Voce digitou: ".concat(v_nome));
	}
}