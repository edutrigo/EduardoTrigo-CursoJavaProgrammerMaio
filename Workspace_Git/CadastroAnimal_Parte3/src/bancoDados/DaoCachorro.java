package bancoDados;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entidade.Cachorro;

// DAO - Data Access Object
public class DaoCachorro {

	// Salva registro de cachorro no BD
	public boolean SaveCachorroBD(Cachorro cachorro) {
		boolean salvamento = false;

		// Instancia objeto "CriaConexao"
		CriaConexao criaConexao = new CriaConexao();

		// Cria objeto tipo "CONNECTION" = NULL
		Connection conexaoBD = null;

		// Cria objeto tipo "PreparedStatement" = NULL
		PreparedStatement preComandoSQL = null;

		// String SQL
		String cmdSQL = "insert into animal (tipo_animal, caf, nome, cor_pelo) values (?, ?, ?, ?)";

		try {
			// Cria a conexão e armazena no objeto "conexaoBD"
			conexaoBD = criaConexao.BdCursoJava();

			// Passo a string com o comando SQL para a variavel "preComandoSQL"
			preComandoSQL = conexaoBD.prepareStatement(cmdSQL);

			// Alimento as colunas
			preComandoSQL.setString(1, "CACHORRO");
			preComandoSQL.setString(2, cachorro.getCaf().toString());
			preComandoSQL.setString(3, cachorro.getNome());
			preComandoSQL.setString(4, cachorro.getCorPelo());

			// Passa o comando para o BD e também faz o COMMIT
			preComandoSQL.execute();

			System.out.println("Dados CACHORRO registrado com sucesso!");

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
