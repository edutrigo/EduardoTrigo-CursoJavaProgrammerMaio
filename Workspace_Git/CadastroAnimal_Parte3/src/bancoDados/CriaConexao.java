package bancoDados;

import java.sql.Connection;
import java.sql.DriverManager;

public class CriaConexao {
	// Variaveis de conexao
	private static String USUARIO = "root";
	private static String SENHA = "root";
	private static String BANCO_URL = "jdbc:mysql://localhost:3306/curso_java?useTimezone=true&serverTimezone=UTC";

	public Connection BdCursoJava() {

		// Cria objeto do tipo "CONNECTION" = NULL
		Connection conexaoBD = null;

		try {
			// Aponta para o driver MySQL
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Cria a conexao
			conexaoBD = DriverManager.getConnection(BANCO_URL, USUARIO, SENHA);

			System.out.println("Conexão BD Exemplo realizada com sucesso!");

		} catch (Exception e) {
			System.out.println("Ocorreu um erro na tentativa de conexão com o DB Exemplo...");
			System.out.println(e.getMessage());
		}
		return conexaoBD;
	}
}
