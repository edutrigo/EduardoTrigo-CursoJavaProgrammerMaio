package CadastroAnimal;

import java.util.Scanner;

import Entidade.Cachorro;
import Entidade.Cobra;

public class Principal {

	public static void main(String[] args) {

		Cachorro  objCachorro       = new Cachorro();
		Cobra     objCobra          = new Cobra();
		Scanner   objEntradaDeDados = new Scanner(System.in);
		int v_opcao;
		
		System.out.println("Digite 1 para CACHORRO e 2 para COBRA");
		v_opcao =  Integer.parseInt( objEntradaDeDados.next());

		if (v_opcao == 1) {
			objCachorro.cadastraCachorro();
		}
		else if (v_opcao == 2) {
			objCobra.cadastraCobra();
		}
		else {
			System.out.println("Opção inválida.... entre somente com 1 ou 2");
		}

/*		
		public static void exibeDados (Cachorro objCachorro
				                      ,Cobra    objCobra) {
			System.out.println(objCachorro.getNome());
			System.out.println(objCachorro.getIdade());

			System.out.println(objCobra.getNome());
			System.out.println(objCobra.getIdade());
		}
*/
	}
}