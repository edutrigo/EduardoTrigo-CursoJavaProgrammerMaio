package bancoDeDados;

import java.sql.Connection;

public class Principal {

	public static void main(String[] args) {

		CriaConexao conexao = new CriaConexao();

		Connection conexãoRecebida = conexao.BdExemplo();

		if (conexãoRecebida == null) {
			System.out.println("Conexão não foi bem sucedida...");
		} else {
			System.out.println("Conexão realizada com sucesso!");
		}
	}
}
