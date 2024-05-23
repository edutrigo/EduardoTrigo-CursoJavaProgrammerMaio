package cadastroAnimal;

import java.util.Scanner;

import entidade.Animal;

public class Principal {

	public static void main(String[] args) {

		Animal objAnimal = new Animal();// Cria o objeto vazio
		
		Scanner objEntradaDados = new Scanner(System.in);

		System.out.println("Infome o NOME do Animal");
		objAnimal.nome = objEntradaDados.next();

		System.out.println("Infome a IDADE do Animal");
		objAnimal.idade = Integer.parseInt(objEntradaDados.next());

		System.out.println("Infome o PESO do Animal");
		objAnimal.peso = Double.parseDouble(objEntradaDados.next());

		objAnimal.preco = calcularPrecoVenda( objAnimal.peso );

		exibeResultado( objAnimal );
	}

	public static Double calcularPrecoVenda(Double p_peso) {
		double v_salario = p_peso * 50;
		return v_salario;
	}

	public static void exibeResultado(Animal objAnimal) {
		System.out.println("Nome:" + objAnimal.nome);
		System.out.println("Idade:" + objAnimal.idade);
		System.out.println("Peso:" + objAnimal.peso);
		System.out.println("Preço:" + objAnimal.preco);
	}
	
}
