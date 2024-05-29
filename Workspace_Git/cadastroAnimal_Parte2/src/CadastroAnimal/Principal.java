package CadastroAnimal;

import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;
import javax.swing.JOptionPane;

import Entidade.Cachorro;
import Entidade.Cobra;

public class Principal {

	public static void main(String[] args) {

		Cachorro objCachorro = new Cachorro();
		Cobra objCobra = new Cobra();
		List<Cachorro> cachorroLista = new ArrayList<Cachorro>();
		List<Cobra> cobraLista = new ArrayList<Cobra>();

		StringBuilder listaMenu = new StringBuilder();
		String v_enter = "\n";

		// Scanner objEntradaDeDados = new Scanner(System.in); //somente para uso no
		// CONSOLE
		int v_opcao = 0;
		boolean v_menuResult = true;

		// System.out.println("Digite "1" para CACHORRO, "2" para COBRA e "3" para
		// SAIR");
		// v_opcao = Integer.parseInt( objEntradaDeDados.next());

		listaMenu.append("Digite '1' para Cad CACHORRO").append(v_enter).append("Digite '2' para Cad COBRA")
				.append(v_enter).append("Digite '3' para Imprime CACHORRO").append(v_enter)
				.append("Digite '4' para Imprime COBRA").append(v_enter).append("Digite '5' para Sair...");

		while (v_menuResult) {
			v_opcao = Integer.parseInt(JOptionPane.showInputDialog(listaMenu.toString()));

			switch (v_opcao) {
			case 1: {
				objCachorro = objCachorro.cadastraCachorro();
				cachorroLista.add(objCachorro);
				break;
			}
			case 2: {
				objCobra = objCobra.cadastraCobra();
				cobraLista.add(objCobra);
				// v_menuResult = false;
				break;
			}
			case 3: {
				exibeDados(cachorroLista, null, v_opcao);
				break;
			}
			case 4: {
				exibeDados(null, cobraLista, v_opcao);
				break;
			}
			case 5: {
				System.exit(0); // termina rotina
				break;
			}
			default: {
				JOptionPane.showMessageDialog(null, "Opção inválida.... entre somente com 1, 2, 3, 4 ou 5");
				break;
			} // default
			} // switch
		} // while
	} // main

	public static void exibeDados(List<Cachorro> cachorroLista, List<Cobra> cobraLista, int v_opcao) {

		StringBuilder impressaoString = new StringBuilder();
		String v_enter = "\n";

		if (v_opcao == 3) {
			for (Cachorro cachorroItemLista : cachorroLista) {
				impressaoString.append("Nome: ").append(cachorroItemLista.getNome()).append(v_enter).append("Idade: ")
						.append(cachorroItemLista.getIdade()).append(v_enter).append("-------").append(v_enter);
			} // for

			JOptionPane.showMessageDialog(null, impressaoString.toString());
		} // if
		else {
			for (Cobra cobraItemLista : cobraLista) {
				impressaoString.append("Nome: ").append(cobraItemLista.getNome()).append(v_enter).append("Idade: ")
						.append(cobraItemLista.getIdade()).append(v_enter).append("-------").append(v_enter);

			} // for
			JOptionPane.showMessageDialog(null, impressaoString.toString());

		} // else
	} // exibeDados

} // Principal
