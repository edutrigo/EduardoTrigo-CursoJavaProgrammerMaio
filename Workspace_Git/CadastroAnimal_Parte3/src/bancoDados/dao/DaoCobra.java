package bancoDados.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bancoDados.config.CriaConexao;
import entidade.Cobra;
import entidade.Endereco;

// DAO - Data Access Object
public class DaoCobra {

	// INCLUIR
	public boolean saveCobraBD(Cobra cobra) {
		boolean confirmaProcesso = false;

		// Instancia objeto "CriaConexao"
		CriaConexao criaConexao = new CriaConexao();

		// Cria objeto tipo "CONNECTION" = NULL
		Connection conexaoBD = null;

		// Cria objeto tipo "PreparedStatement" = NULL
		PreparedStatement preComandoSQL = null;

		// String SQL
		String cmdSQL = "insert into animal (tipo_animal, caf, nome, tipo_veneno, preco, cep, localidade, logradouro, bairro, uf) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
			preComandoSQL.setString(5, cobra.getPreco().toString());
			// Dados Endereco
			preComandoSQL.setString(6, cobra.getEndereco().getCep());
			preComandoSQL.setString(7, cobra.getEndereco().getLocalidade());
			preComandoSQL.setString(8, cobra.getEndereco().getLogradouro());
			preComandoSQL.setString(9, cobra.getEndereco().getBairro());
			preComandoSQL.setString(10, cobra.getEndereco().getUf());

			// Passa o comando para o BD e também faz o COMMIT
			preComandoSQL.execute();

			System.out.println("Dados COBRA registrado com sucesso!");

			confirmaProcesso = true;

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
		return confirmaProcesso;
	}

	// EXCLUIR
	public boolean delCobraBD(String caf) {
		boolean confirmaProcesso = false;

		// Instancia objeto "CriaConexao"
		CriaConexao criaConexao = new CriaConexao();

		// Cria objeto tipo "CONNECTION" = NULL
		Connection conexaoBD = null;

		// Cria objeto tipo "PreparedStatement" = NULL
		PreparedStatement preComandoSQL = null;

		// String SQL
		String cmdSQL = "delete from animal where tipo_animal = ? and caf = ?";

		try {
			// Cria a conexão e armazena no objeto "conexaoBD"
			conexaoBD = criaConexao.BdCursoJava();

			// Passo a string com o comando SQL para a variavel "preComandoSQL"
			preComandoSQL = conexaoBD.prepareStatement(cmdSQL);

			// Alimento as colunas
			preComandoSQL.setString(1, "COBRA");
			preComandoSQL.setString(2, caf);

			// Passa o comando para o BD e também faz o COMMIT
			preComandoSQL.execute();

			System.out.println("Dados COBRA excluído com sucesso!");

			confirmaProcesso = true;

		} catch (Exception e) {
			System.out.println("Não foi possível excluir as informações...");
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
		return confirmaProcesso;
	}

	// CONSULTAR
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
		String cmdSQL = "select caf, nome, tipo_veneno, preco, cep, localidade, logradouro, bairro, uf from animal where tipo_animal='COBRA'";

		try {
			// Cria a conexão e armazena no objeto "conexaoBD"
			conexaoBD = criaConexao.BdCursoJava();

			// Passo a string com o comando SQL para a variavel "preComandoSQL"
			preComandoSQL = conexaoBD.prepareStatement(cmdSQL);

			// Carregando os dados no objeto "preComandoSQL"
			resultQuery = preComandoSQL.executeQuery();

			while (resultQuery.next()) {

				// DADOS DIVERSOS
				Cobra cobra = new Cobra();
				cobra.setCaf(Integer.parseInt(resultQuery.getString("CAF")));
				cobra.setNome(resultQuery.getString("NOME"));
				cobra.setTipoVeneno(resultQuery.getString("TIPO_VENENO"));
				cobra.setPreco(Double.parseDouble(resultQuery.getString("PRECO")));

				// DADOS ENDERECO
				Endereco endereco = new Endereco();
				endereco.setCep(resultQuery.getString("CEP"));
				endereco.setLocalidade(resultQuery.getString("LOCALIDADE"));
				endereco.setLogradouro(resultQuery.getString("LOGRADOURO"));
				endereco.setBairro(resultQuery.getString("BAIRRO"));
				endereco.setUf(resultQuery.getString("UF"));

				// FAZ-SE O VINCULO DO "ENDERECO" A ENTIDADE "CACHORRO"
				cobra.setEndereco(endereco);

				listCobra.add(cobra);
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

	// ATUALIZAR
	public boolean updateCobraBD(Cobra cobra) {
		boolean confirmaProcesso = false;

		// Instancia objeto "CriaConexao"
		CriaConexao criaConexao = new CriaConexao();

		// Cria objeto tipo "CONNECTION" = NULL
		Connection conexaoBD = null;

		// Cria objeto tipo "PreparedStatement" = NULL
		PreparedStatement preComandoSQL = null;

		// String SQL
		String cmdSQL = "update animal set nome = ?, tipo_veneno = ? where tipo_animal = ? and caf = ?";

		try {
			// Cria a conexão e armazena no objeto "conexaoBD"
			conexaoBD = criaConexao.BdCursoJava();

			// Passo a string com o comando SQL para a variavel "preComandoSQL"
			preComandoSQL = conexaoBD.prepareStatement(cmdSQL);

			// Alimento as colunas
			preComandoSQL.setString(1, cobra.getNome());
			preComandoSQL.setString(2, cobra.getTipoVeneno());
			preComandoSQL.setString(3, "COBRA");
			preComandoSQL.setString(4, cobra.getCaf().toString());

			// Passa o comando para o BD e também faz o COMMIT
			preComandoSQL.execute();

			System.out.println("Dados COBRA atualizado com sucesso!");

			confirmaProcesso = true;

		} catch (Exception e) {
			System.out.println("Não foi possível atualizar as informações...");
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
		return confirmaProcesso;
	}

}
