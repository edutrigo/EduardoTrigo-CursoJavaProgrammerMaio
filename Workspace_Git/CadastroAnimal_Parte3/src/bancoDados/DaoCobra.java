package bancoDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidade.Cobra;

// DAO - Data Access Object
public class DaoCobra {

	// Salva registro de Cobra no BD
	public boolean SaveCobraBD(Cobra cobra) {
		boolean salvamento = false;

		// Instancia objeto "CriaConexao"
		CriaConexao criaConexao = new CriaConexao();

		// Cria objeto tipo "CONNECTION" = NULL
		Connection conexaoBD = null;

		// Cria objeto tipo "PreparedStatement" = NULL
		PreparedStatement preComandoSQL = null;

		// String SQL
		String cmdSQL = "insert into animal (tipo_animal, caf, nome, tipo_veneno) values (?, ?, ?, ?)";

		try {
			// Cria a conexão e armazena no objeto "conexaoBD"
			conexaoBD = criaConexao.BdCursoJava();

			// Passo a string com o comando SQL para a variavel "preComandoSQL"
			preComandoSQL = conexaoBD.prepareStatement(cmdSQL);

			// Alimento as colunas
			preComandoSQL.setString(1, "COBRA");
			preComandoSQL.setString(2, cobra.getCaf().toString());
			preComandoSQL.setString(3, cobra.getNome());
			preComandoSQL.setString(4, cobra.getTipoVeneno());

			// Passa o comando para o BD e também faz o COMMIT
			preComandoSQL.execute();

			System.out.println("Dados COBRA registrado com sucesso!");

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

	public List<Cobra> retQueryCobra() {

		// Instancia objeto "CriaConexao"
		CriaConexao criaConexao = new CriaConexao();

		// Cria objeto tipo "CONNECTION" = NULL
		Connection conexaoBD = null;

		// Cria objeto tipo "PreparedStatement" = NULL
		PreparedStatement preComandoSQL = null;

		// Cria objeto que irá armazenar o resultado da Query
		ResultSet resultQuery = null;

		// Cria objeto lista do objeto "Cobra"
		List<Cobra> listCobra = new ArrayList<>();

		// String SQL
		String cmdSQL = "select caf, nome, tipo_veneno from animal where tipo_animal='COBRA'";

		try {
			// Cria a conexão e armazena no objeto "conexaoBD"
			conexaoBD = criaConexao.BdCursoJava();

			// Passo a string com o comando SQL para a variavel "preComandoSQL"
			preComandoSQL = conexaoBD.prepareStatement(cmdSQL);

			// Carregando os dados no objeto "preComandoSQL"
			resultQuery = preComandoSQL.executeQuery();

			while (resultQuery.next()) {

				Cobra Cobra = new Cobra();

				Cobra.setCaf(Integer.parseInt(resultQuery.getString("CAF")));
				Cobra.setNome(resultQuery.getString("NOME"));
				Cobra.setTipoVeneno(resultQuery.getString("TIPO_VENENO"));

				listCobra.add(Cobra);
			}

		} catch (Exception e) {
			System.out.println("Não foi possível listar as informações...");
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
		return listCobra;
	}

}
