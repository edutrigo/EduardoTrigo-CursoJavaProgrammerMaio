package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entity.EntCorrentistaPremium;
import entity.EntEndereco;
import persistence.config.PerCriaConexao;

public class DaoCorrentistaPremium {

	//
	public boolean adicionaCorrentistaPremium(EntCorrentistaPremium entCorrentista) {
		boolean confirmaProcesso = false;

		PerCriaConexao criaConexao = new PerCriaConexao();
		Connection conexaoBD = null;
		PreparedStatement preComandoSQL = null;

		String cmdSQL = "insert into correntista (cpf, nome, cep, logradouro, localidade, uf, email, qtd_transacao, val_anuidade, limite_credito, tipo_correntista )\r\n"
				+ "values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

		try {
			conexaoBD = criaConexao.ConnectBD();
			preComandoSQL = conexaoBD.prepareStatement(cmdSQL);

			preComandoSQL.setString(1, entCorrentista.getCpf());
			preComandoSQL.setString(2, entCorrentista.getNome());

			preComandoSQL.setString(3, entCorrentista.getEndereco().getCep());
			preComandoSQL.setString(4, entCorrentista.getEndereco().getLogradouro());
			preComandoSQL.setString(5, entCorrentista.getEndereco().getLocalidade());
			preComandoSQL.setString(6, entCorrentista.getEndereco().getUf());

			preComandoSQL.setString(7, entCorrentista.getEmail());
			preComandoSQL.setString(8, Integer.toString(entCorrentista.getQtdTransacao()));

			preComandoSQL.setString(9, entCorrentista.getValorAnuidade().toString());

			preComandoSQL.setString(10, entCorrentista.getLimiteDeCredito().toString());
			preComandoSQL.setString(11, "P");

			preComandoSQL.execute();

			JOptionPane.showMessageDialog(null, "Dados do 'CORRENTISTA PREMIUM' registrado com sucesso!");

			confirmaProcesso = true;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não foi possível salvar as informações..." + "\n" + e.getMessage());

		} finally {
			try {
				if (conexaoBD != null) {
					conexaoBD.close();
				}
				if (conexaoBD != null) {
					conexaoBD.close();
				}

			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,
						"Não foi possível encerrar a conexão de BD..." + "\n" + e2.getMessage());
			}
		}
		return confirmaProcesso;
	}

	//
	public List<EntCorrentistaPremium> retornaConsultaCorrentista() {

		PerCriaConexao criaConexao = new PerCriaConexao();
		Connection conexaoBD = null;
		PreparedStatement preComandoSQL = null;
		ResultSet resultQuery = null;

		List<EntCorrentistaPremium> listCorrentista = new ArrayList<>();

		String cmdSQL = "select cpf, nome, cep, logradouro, localidade, uf, email, qtd_transacao, val_anuidade, limite_credito, limite_saque\r\n"
				+ "from correntista\r\n" + "where tipo_correntista = 'P'";

		try {
			conexaoBD = criaConexao.ConnectBD();
			preComandoSQL = conexaoBD.prepareStatement(cmdSQL);
			resultQuery = preComandoSQL.executeQuery();

			while (resultQuery.next()) {
				//
				EntCorrentistaPremium entCorrentistaPremium = new EntCorrentistaPremium();
				entCorrentistaPremium.setCpf(resultQuery.getString("CPF"));
				entCorrentistaPremium.setNome(resultQuery.getString("NOME"));
				entCorrentistaPremium.setEmail(resultQuery.getString("EMAIL"));
				entCorrentistaPremium.setQtdTransacao(Integer.parseInt(resultQuery.getString("QTD_TRANSACAO")));
				entCorrentistaPremium.setValorAnuidade(Double.parseDouble(resultQuery.getString("VAL_ANUIDADE")));
				entCorrentistaPremium.setLimiteDeCredito(Double.parseDouble(resultQuery.getString("LIMITE_CREDITO")));

				//
				EntEndereco entEndereco = new EntEndereco();
				entEndereco.setCep(resultQuery.getString("CEP"));
				entEndereco.setLogradouro(resultQuery.getString("LOGRADOURO"));
				entEndereco.setLocalidade(resultQuery.getString("LOCALIDADE"));
				entEndereco.setUf(resultQuery.getString("UF"));

				entCorrentistaPremium.setEndereco(entEndereco);

				//
				listCorrentista.add(entCorrentistaPremium);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não foi possível listar as informações..." + "\n" + e.getMessage());

		} finally { // Obrigatorio
			try {
				if (conexaoBD != null) {
					conexaoBD.close();
				}
				if (preComandoSQL != null) {
					preComandoSQL.close();
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,
						"Não foi possível encerrar a conexão de BD..." + "\n" + e2.getMessage());
			}
		}
		return listCorrentista;
	}

	//
	public boolean excluiCorrentista(String cpf) {

		boolean confirmaProcesso = false;

		PerCriaConexao criaConexao = new PerCriaConexao();
		Connection conexaoBD = null;
		PreparedStatement preComandoSQL = null;

		String cmdSQL = "delete from correntista where tipo_correntista = ? and cpf = ?";

		try {
			conexaoBD = criaConexao.ConnectBD();
			preComandoSQL = conexaoBD.prepareStatement(cmdSQL);

			preComandoSQL.setString(1, "P");
			preComandoSQL.setString(2, cpf);

			preComandoSQL.execute();

			JOptionPane.showMessageDialog(null, "Dados do 'CORRENTISTA PREMIUM' excluído com sucesso!");

			confirmaProcesso = true;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não foi possível excluir as informações..." + "\n" + e.getMessage());

		} finally {
			try {
				if (conexaoBD != null) {
					conexaoBD.close();
				}
				if (preComandoSQL != null) {
					preComandoSQL.close();
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,
						"Não foi possível encerrar a conexão de BD..." + "\n" + e2.getMessage());
			}
		}
		return confirmaProcesso;
	}

	//
	public boolean atualizaCorrentistaPremium(EntCorrentistaPremium entCorrentista) {
		boolean confirmaProcesso = false;

		PerCriaConexao criaConexao = new PerCriaConexao();
		Connection conexaoBD = null;
		PreparedStatement preComandoSQL = null;

		String cmdSQL = "update correntista set nome = ?, cep = ? ,logradouro = ?, localidade = ?, uf = ?, email = ?, qtd_transacao = ?, val_anuidade = ?, limite_credito = ?"
				+ "where cpf = ? and tipo_correntista = ?";

		try {
			conexaoBD = criaConexao.ConnectBD();
			preComandoSQL = conexaoBD.prepareStatement(cmdSQL);

			preComandoSQL.setString(1, entCorrentista.getNome());

			preComandoSQL.setString(2, entCorrentista.getEndereco().getCep());
			preComandoSQL.setString(3, entCorrentista.getEndereco().getLogradouro());
			preComandoSQL.setString(4, entCorrentista.getEndereco().getLocalidade());
			preComandoSQL.setString(5, entCorrentista.getEndereco().getUf());

			preComandoSQL.setString(6, entCorrentista.getEmail());
			preComandoSQL.setString(7, Integer.toString(entCorrentista.getQtdTransacao()));
			preComandoSQL.setString(8, entCorrentista.getValorAnuidade().toString());
			preComandoSQL.setString(9, entCorrentista.getLimiteDeCredito().toString());

			preComandoSQL.setString(10, entCorrentista.getCpf());
			preComandoSQL.setString(11, "P");

			preComandoSQL.execute();

			JOptionPane.showMessageDialog(null, "Dados do 'CORRENTISTA PREMIUM' alterado com sucesso!");

			confirmaProcesso = true;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não foi possível salvar as informações..." + "\n" + e.getMessage());

		} finally {
			try {
				if (conexaoBD != null) {
					conexaoBD.close();
				}
				if (conexaoBD != null) {
					conexaoBD.close();
				}

			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,
						"Não foi possível encerrar a conexão de BD..." + "\n" + e2.getMessage());
			}
		}
		return confirmaProcesso;
	}
}
