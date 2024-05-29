package Entidade;

//import java.util.Scanner;

import javax.swing.JOptionPane;

public class Cobra extends Animal {
	private String TipoVeneno;

	public String getTipoVeneno() {
		return TipoVeneno;
	}

	public void setTipoVeneno(String tipoVeneno) {
		TipoVeneno = tipoVeneno;
	}

	public Cobra cadastraCobra() {
		Cobra objCobra = new Cobra();
		// Scanner objEntradaDeDados = new Scanner(System.in);

		// DADOS COBRA
		JOptionPane.showMessageDialog(null, "Entre com os dados da Cobra...");
		// System.out.println("Entre com os dados da Cobra...");

		objCobra.setNome(JOptionPane.showInputDialog("Nome"));
		// System.out.println("Nome:");
		// objCobra.setNome( objEntradaDeDados.next() );

		objCobra.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Idade")));
		// System.out.println("Idade:");
		// objCobra.setIdade( Integer.parseInt( objEntradaDeDados.next()) );

		objCobra.setPeso(Double.parseDouble(JOptionPane.showInputDialog("Peso")));
		// System.out.println("Peso:");
		// objCobra.setPeso( Double.parseDouble(objEntradaDeDados.next()) );

		objCobra.setPreco(Double.parseDouble(JOptionPane.showInputDialog("Preco")));
		// System.out.println("Preco:");
		// objCobra.setPreco( Double.parseDouble(objEntradaDeDados.next()) );

		objCobra.setTipoVeneno(JOptionPane.showInputDialog("TipoVeneno"));
		// System.out.println("TipoVeneno:");
		// objCobra.setTipoVeneno( objEntradaDeDados.next() );
		return (objCobra);
	}

}
