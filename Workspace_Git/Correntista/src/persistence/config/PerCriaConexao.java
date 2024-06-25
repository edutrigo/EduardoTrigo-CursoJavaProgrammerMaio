package persistence.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class PerCriaConexao {

	private static String USUARIO = "root";
	private static String SENHA = "root";
	private static String BANCO_URL = "jdbc:mysql://localhost:3306/curso_java?useTimezone=true&serverTimezone=UTC";

	public Connection ConnectBD() {

		Connection conexaoBD = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conexaoBD = DriverManager.getConnection(BANCO_URL, USUARIO, SENHA);

			System.out.println("Conexão de BD realizada com sucesso!");

		} catch (Exception e) {
			System.out.println("Ocorreu um erro na tentativa de conexão com o DB...");
			System.out.println(e.getMessage());
		}
		return conexaoBD;
	}
}
