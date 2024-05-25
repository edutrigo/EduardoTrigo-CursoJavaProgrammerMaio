package Entidade;

import java.util.Scanner;

public class Cachorro extends Animal {
	private String CorPelo;

	public String getCorPelo() {
		return CorPelo;
	}

	public void setCorPelo(String corPelo) {
		CorPelo = corPelo;
	}

	public void cadastraCachorro () {
		Cachorro  objCachorro       = new Cachorro();
		Scanner   objEntradaDeDados = new Scanner(System.in);
		
		// DADOS CACHORRO
		System.out.println("Entre com os dados do Cachorro...");

		System.out.println("Nome:");
		objCachorro.setNome( objEntradaDeDados.next() );
		
		System.out.println("Idade:");
		objCachorro.setIdade( Integer.parseInt( objEntradaDeDados.next()) );

		System.out.println("Peso:");
		objCachorro.setPeso( Double.parseDouble(objEntradaDeDados.next()) );
		
		System.out.println("Preco:");
		objCachorro.setPreco( Double.parseDouble(objEntradaDeDados.next()) );

		System.out.println("CorPelo:");
		objCachorro.setCorPelo( objEntradaDeDados.next() );
	}
}
