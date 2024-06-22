package bancoDados.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bancoDados.config.CriaConexao;
import entidade.Cachorro;
import entidade.Endereco;

// DAO - Data Access Object
public class DaoCachorro {

	// INCLUIR
	public boolean saveCachorroBD(Cachorro cachorro) {
		boolean confirmaProcesso = false;

		// Instancia objeto "CriaConexao"
		CriaConexao criaConexao = new CriaConexao();

		// Cria objeto tipo "CONNECTION" = NULL
		Connection conexaoBD = null;

		// Cria objeto tipo "PreparedStatement" = NULL
		PreparedStatement preComandoSQL = null;

		// String SQL
		String cmdSQL = "insert into animal (tipo_animal, caf, nome, cor_pelo, preco, cep, localidade, logradouro, bairro, uf ) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

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
			preComandoSQL.setString(5, cachorro.getPreco().toString());
			// Dados Endereco
			preComandoSQL.setString(6, cachorro.getEndereco().getCep());
			preComandoSQL.setString(7, cachorro.getEndereco().getLocalidade());
			preComandoSQL.setString(8, cachorro.getEndereco().getLogradouro());
			preComandoSQL.setString(9, cachorro.getEndereco().getBairro());
			preComandoSQL.setString(10, cachorro.getEndereco().getUf());

			// Passa o comando para o BD e também faz o COMMIT
			preComandoSQL.execute();

			System.out.println("Dados CACHORRO registrado com sucesso!");

			confirmaProcesso = true;

		} catch (Exception e) {
			System.out.println("Não foi possível salvar as informações...");
			System.out.println(e.getMessage());

		} finally { // Obrigatorio
			try {
				if (conexaoBD != null) {
					conexaoBD.close();
				}
				if (conexaoBD != null) {
					conexaoBD.close();
				}

			} catch (Exception e2) {
				System.out.println("Não foi possível encerrar a conexão de BD...");
				System.out.println(e2.getMessage());
			}
		}
		return confirmaProcesso;
	}

	// EXCLUIR
	public boolean delCachorroBD(String caf) {
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
			preComandoSQL.setString(1, "CACHORRO");
			preComandoSQL.setString(2, caf);

			// Passa o comando para o BD e também faz o COMMIT
			preComandoSQL.execute();

			System.out.println("Dados CACHORRO excluído com sucesso!");

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
	public List<Cachorro> retQueryCachorro() {

		// Instancia objeto "CriaConexao"
		CriaConexao criaConexao = new CriaConexao();

		// Cria objeto tipo "CONNECTION" = NULL
		Connection conexaoBD = null;

		// Cria objeto tipo "PreparedStatement" = NULL
		PreparedStatement preComandoSQL = null;

		// Cria objeto que irá armazenar o resultado da Query
		ResultSet resultQuery = null;

		// Cria objeto lista do objeto "Cachorro"
		List<Cachorro> listCachorro = new ArrayList<>();

		// String SQL
		String cmdSQL = "select caf, nome, cor_pelo, preco, cep, localidade, logradouro, bairro, uf from animal where tipo_animal='CACHORRO'";

		try {
			// Cria a conexão e armazena no objeto "conexaoBD"
			conexaoBD = criaConexao.BdCursoJava();

			// Passo a string com o comando SQL para a variavel "preComandoSQL"
			preComandoSQL = conexaoBD.prepareStatement(cmdSQL);

			// Carregando os dados no objeto "preComandoSQL"
			resultQuery = preComandoSQL.executeQuery();

			while (resultQuery.next()) {

				// DADOS DIVERSOS
				Cachorro cachorro = new Cachorro();
				cachorro.setCaf(Integer.parseInt(resultQuery.getString("CAF")));
				cachorro.setNome(resultQuery.getString("NOME"));
				cachorro.setCorPelo(resultQuery.getString("COR_PELO"));
				cachorro.setPreco(Double.parseDouble(resultQuery.getString("PRECO")));

				// DADOS ENDERECO
				Endereco endereco = new Endereco();
				endereco.setCep(resultQuery.getString("CEP"));
				endereco.setLocalidade(resultQuery.getString("LOCALIDADE"));
				endereco.setLogradouro(resultQuery.getString("LOGRADOURO"));
				endereco.setBairro(resultQuery.getString("BAIRRO"));
				endereco.setUf(resultQuery.getString("UF"));

				// FAZ-SE O VINCULO DO "ENDERECO" A ENTIDADE "CACHORRO"
				cachorro.setEndereco(endereco);
				
				listCachorro.add(cachorro);
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
		return listCachorro;
	}

	// ATUALIZAR
	public boolean updateCachorroBD(Cachorro cachorro) {
		boolean confirmaProcesso = false;

		// Instancia objeto "CriaConexao"
		CriaConexao criaConexao = new CriaConexao();

		// Cria objeto tipo "CONNECTION" = NULL
		Connection conexaoBD = null;

		// Cria objeto tipo "PreparedStatement" = NULL
		PreparedStatement preComandoSQL = null;

		// String SQL
		String cmdSQL = "update animal set nome = ?, cor_pelo = ?, preco = ? where tipo_animal = ? and caf = ?";

		try {
			// Cria a conexão e armazena no objeto "conexaoBD"
			conexaoBD = criaConexao.BdCursoJava();

			// Passo a string com o comando SQL para a variavel "preComandoSQL"
			preComandoSQL = conexaoBD.prepareStatement(cmdSQL);

			// Alimento as colunas
			preComandoSQL.setString(1, cachorro.getNome());
			preComandoSQL.setString(2, cachorro.getCorPelo());
			preComandoSQL.setString(3, "CACHORRO");
			preComandoSQL.setString(4, cachorro.getCaf().toString());
			preComandoSQL.setString(5, cachorro.getPreco().toString());

			// Passa o comando para o BD e também faz o COMMIT
			preComandoSQL.execute();

			System.out.println("Dados CACHORRO atualizado com sucesso!");

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
