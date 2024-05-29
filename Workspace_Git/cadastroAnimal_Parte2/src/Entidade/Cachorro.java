package Entidade;

//import java.util.Scanner;

import javax.swing.JOptionPane;

public class Cachorro extends Animal {
	private String CorPelo;

	public String getCorPelo() {
		return CorPelo;
	}

	public void setCorPelo(String corPelo) {
		CorPelo = corPelo;
	}

	public Cachorro cadastraCachorro() {

		boolean v_menuResult = true;
		Cachorro objCachorro = new Cachorro();
		// Scanner objEntradaDeDados = new Scanner(System.in);

		// DADOS CACHORRO
		JOptionPane.showMessageDialog(null, "Entre com os dados do Cachorro...");
		// System.out.println("Entre com os dados do Cachorro...");

		objCachorro.setNome(JOptionPane.showInputDialog("Nome"));
		// System.out.println("Nome:");
		// objCachorro.setNome( objEntradaDeDados.next() );

		while (v_menuResult) {
		try {
			objCachorro.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Idade")));
			v_menuResult = false;
			// System.out.println("Idade:");
			// objCachorro.setIdade( Integer.parseInt( objEntradaDeDados.next()) );

		} catch (Exception msgExcept) {
			System.out.println( "erro entrada IDADE: " + msgExcept.getMessage());
		}
		}

		
		objCachorro.setPeso(Double.parseDouble(JOptionPane.showInputDialog("Peso")));
		// System.out.println("Peso:");
		// objCachorro.setPeso( Double.parseDouble(objEntradaDeDados.next()) );

		objCachorro.setPreco(Double.parseDouble(JOptionPane.showInputDialog("Preco")));
		// System.out.println("Preco:");
		// objCachorro.setPreco( Double.parseDouble(objEntradaDeDados.next()) );

		objCachorro.setCorPelo(JOptionPane.showInputDialog("CorPelo"));
		// System.out.println("CorPelo:");
		// objCachorro.setCorPelo( objEntradaDeDados.next() );
		return (objCachorro);
	}
}
