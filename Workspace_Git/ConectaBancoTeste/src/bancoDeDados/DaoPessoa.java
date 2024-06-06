package bancoDeDados;

import java.sql.Connection;
import java.sql.PreparedStatement;

// DAO - Data Access Object
public class DaoPessoa {

	// Salva registro de pessoa no BD
	public boolean SavePessoaBD(Pessoa pessoa) {
		boolean salvamento = false;

		// Instancia objeto "CriaConexao"
		CriaConexao criaConexao = new CriaConexao();

		// Cria objeto tipo "CONNECTION" = NULL
		Connection conexaoBD = null;

		// Cria objeto tipo "PreparedStatement" = NULL
		PreparedStatement preComandoSQL = null;

		// String SQL
		String cmdSQL = "insert into pessoa (cpf, nome, email) values (?, ?, ?)";

		try {
			// Cria a conexão e armazena no objeto "conexaoBD"
			conexaoBD = criaConexao.BdExemplo();

			// Passo a string com o comando SQL para a variavel "preComandoSQL"
			preComandoSQL = conexaoBD.prepareStatement(cmdSQL);

			// Alimento as colunas
			preComandoSQL.setString(1, pessoa.getCpf());
			preComandoSQL.setString(2, pessoa.getNome());
			preComandoSQL.setString(3, pessoa.getEmail());

			// Passa o comando para o BD e também faz o COMMIT
			preComandoSQL.execute();

			System.out.println("Dados registrados com sucesso!");

			salvamento = true;

		} catch (Exception e) {
			System.out.println("Não foi possível salvar as informações...");
			System.out.println(e.getMessage());

		} finally { // Obrigatorio
			try {
				if (conexaoBD != null) {
					conexaoBD.close();
				}
				if (preComandoSQL != null) {
					preComandoSQL.close();
				}

			} catch (Exception e2) {
				System.out.println("Não foi possível encerrar a conexão de BD...");
				System.out.println(e2.getMessage());
			}
		}
		return salvamento;
	}
}
