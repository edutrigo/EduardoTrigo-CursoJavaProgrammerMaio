package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entity.EntCorrentistaBasico;
import entity.EntEndereco;
import persistence.config.PerCriaConexao;

public class DaoCorrentistaBasico {

	public boolean adicionaCorrentistaBasico(EntCorrentistaBasico entCorrentista) {
		boolean confirmaProcesso = false;

		PerCriaConexao criaConexao = new PerCriaConexao();
		Connection conexaoBD = null;
		PreparedStatement preComandoSQL = null;

		// String SQL
		String cmdSQL = "insert into correntista (cpf, nome, cep, logradouro, localidade, uf, email, qtd_transacao, val_anuidade, limite_saque, tipo_correntista )\r\n"
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

			preComandoSQL.setString(10, entCorrentista.getLimiteDeSaque().toString());
			preComandoSQL.setString(11, "B");

			// Passa o comando para o BD e também faz o COMMIT
			preComandoSQL.execute();

			JOptionPane.showMessageDialog(null, "Dados do 'CORRENTISTA BASICO' registrado com sucesso!");

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
	public List<EntCorrentistaBasico> RetornaConsultaCorrentista() {

		PerCriaConexao criaConexao = new PerCriaConexao();
		Connection conexaoBD = null;
		PreparedStatement preComandoSQL = null;
		ResultSet resultQuery = null;

		List<EntCorrentistaBasico> listCorrentista = new ArrayList<>();

		String cmdSQL = "select cpf, nome, cep, logradouro, localidade, uf, email, qtd_transacao, val_anuidade, limite_credito, limite_saque\r\n"
				+ "from correntista\r\n" + "where tipo_correntista = 'B'";

		try {
			conexaoBD = criaConexao.ConnectBD();
			preComandoSQL = conexaoBD.prepareStatement(cmdSQL);
			resultQuery = preComandoSQL.executeQuery();

			while (resultQuery.next()) {
				//
				EntCorrentistaBasico entCorrentistaBasico = new EntCorrentistaBasico();
				entCorrentistaBasico.setCpf(resultQuery.getString("CPF"));
				entCorrentistaBasico.setNome(resultQuery.getString("NOME"));
				entCorrentistaBasico.setEmail(resultQuery.getString("EMAIL"));
				entCorrentistaBasico.setQtdTransacao(Integer.parseInt(resultQuery.getString("QTD_TRANSACAO")));
				entCorrentistaBasico.setValorAnuidade(Double.parseDouble(resultQuery.getString("VAL_ANUIDADE")));
				entCorrentistaBasico.setLimiteDeSaque(Double.parseDouble(resultQuery.getString("LIMITE_SAQUE")));

				//
				EntEndereco entEndereco = new EntEndereco();
				entEndereco.setCep(resultQuery.getString("CEP"));
				entEndereco.setLogradouro(resultQuery.getString("LOGRADOURO"));
				entEndereco.setLocalidade(resultQuery.getString("LOCALIDADE"));
				entEndereco.setUf(resultQuery.getString("UF"));

				entCorrentistaBasico.setEndereco(entEndereco);

				//
				listCorrentista.add(entCorrentistaBasico);
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

	public boolean ExcluiCorrentista(String cpf) {

		boolean confirmaProcesso = false;

		PerCriaConexao criaConexao = new PerCriaConexao();
		Connection conexaoBD = null;
		PreparedStatement preComandoSQL = null;

		String cmdSQL = "delete from correntista where tipo_correntista = ? and cpf = ?";

		try {
			conexaoBD = criaConexao.ConnectBD();
			preComandoSQL = conexaoBD.prepareStatement(cmdSQL);

			preComandoSQL.setString(1, "B");
			preComandoSQL.setString(2, cpf);

			preComandoSQL.execute();

			JOptionPane.showMessageDialog(null, "Dados do 'CORRENTISTA BASICO' excluído com sucesso!");

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
}
