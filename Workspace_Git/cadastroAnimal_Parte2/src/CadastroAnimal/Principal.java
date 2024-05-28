package CadastroAnimal;

import java.util.Scanner;

import javax.swing.JOptionPane;

import Entidade.Cachorro;
import Entidade.Cobra;

public class Principal {

	public static void main(String[] args) {

		Cachorro  objCachorro       = new Cachorro();
		Cobra     objCobra          = new Cobra();
		Scanner   objEntradaDeDados = new Scanner(System.in); //somente para uso no CONSOLE
		int       v_opcao = 0;
		boolean   v_menuResult = true;
		
		
		//System.out.println("Digite "1" para CACHORRO, "2" para COBRA e "3" para SAIR");
		//v_opcao =  Integer.parseInt( objEntradaDeDados.next());
		
		while (v_menuResult) {
			v_opcao =  Integer.parseInt( JOptionPane.showInputDialog ( "Digite '1' para CACHORRO, '2' para COBRA ou '3' para SAIR" ));
			
			switch (v_opcao) {
			case 1: {
				objCachorro = objCachorro.cadastraCachorro();
				v_menuResult = false;
				break;
			}
			case 2: {
				objCobra = objCobra.cadastraCobra();
				v_menuResult = false;
				break;
			}
			case 3: {
				System.exit(0); //termina rotina
				break;
			        }
			default: {
				JOptionPane.showMessageDialog( null, "Opção inválida.... entre somente com 1, 2 ou 3" );
				break;
			}
			}
		}
/*
		if (v_opcao == 1) {
			objCachorro.cadastraCachorro();
		}
		else if (v_opcao == 2) {
			objCobra.cadastraCobra();
		}
		else {
			JOptionPane.showMessageDialog( null, "Opção inválida.... entre somente com 1 ou 2" );
			//System.out.println("Opção inválida.... entre somente com 1 ou 2");
		}
*/
		exibeDados( objCachorro, objCobra, v_opcao );
	}

	public static void exibeDados (Cachorro objCachorro
                                  ,Cobra    objCobra
                                  ,int      v_opcao) {
		if (v_opcao == 1) {
			JOptionPane.showMessageDialog( null, "Nome Cachorro: " + objCachorro.getNome() + "\n" +
					                             "Idade Cachorro: " + objCachorro.getIdade() );
		}
		else if (v_opcao == 2) {
			JOptionPane.showMessageDialog( null, "Nome Cobra: " + objCobra.getNome() + "\n" +
                                                 "Idade Cobra: " + objCobra.getIdade() );
		}

	}
}	