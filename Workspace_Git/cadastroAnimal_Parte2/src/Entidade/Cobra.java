package Entidade;

import java.util.Scanner;

public class Cobra extends Animal{
	private String TipoVeneno;

	public String getTipoVeneno() {
		return TipoVeneno;
	}

	public void setTipoVeneno(String tipoVeneno) {
		TipoVeneno = tipoVeneno;
	}

	public void cadastraCobra () {
		Cobra    objCobra = new Cobra();
		Scanner  objEntradaDeDados = new Scanner(System.in);
		
		// DADOS COBRA
		System.out.println("Entre com os dados da Cobra...");

		System.out.println("Nome:");
		objCobra.setNome( objEntradaDeDados.next() );
		
		System.out.println("Idade:");
		objCobra.setIdade( Integer.parseInt( objEntradaDeDados.next()) );

		System.out.println("Peso:");
		objCobra.setPeso( Double.parseDouble(objEntradaDeDados.next()) );
		
		System.out.println("Preco:");
		objCobra.setPreco( Double.parseDouble(objEntradaDeDados.next()) );

		System.out.println("TipoVeneno:");
		objCobra.setTipoVeneno( objEntradaDeDados.next() );
	}


}
