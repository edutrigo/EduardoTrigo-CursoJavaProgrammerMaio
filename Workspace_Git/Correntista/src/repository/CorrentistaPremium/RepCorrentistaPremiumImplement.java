package repository.CorrentistaPremium;

import java.util.List;

import javax.swing.JOptionPane;

import entity.EntCorrentistaPremium;
import persistence.dao.DaoCorrentistaPremium;

public class RepCorrentistaPremiumImplement implements RepCorrentistaPremium {

	public boolean adicionaCorrentistaPremium(EntCorrentistaPremium entCorrentista) {
		DaoCorrentistaPremium daoCorrentistaPremium = new DaoCorrentistaPremium();
		return daoCorrentistaPremium.adicionaCorrentistaPremium(entCorrentista);
	}

	public List<EntCorrentistaPremium> retornaConsultaCorrentista() {
		DaoCorrentistaPremium daoCorrentistaPremium = new DaoCorrentistaPremium();
		return daoCorrentistaPremium.retornaConsultaCorrentista();
	}

	public EntCorrentistaPremium buscaCorrentistaPorCpf(String cpf) {
		for (EntCorrentistaPremium entCorrentistaPremium : retornaConsultaCorrentista()) {
			if (entCorrentistaPremium.getCpf().toString().equals(cpf)) {
				return entCorrentistaPremium;
			}
		}
		return null;
	}

	public boolean excluiCorrentista(String cpf) {
		DaoCorrentistaPremium daoCorrentistaPremium = new DaoCorrentistaPremium();

		if (buscaCorrentistaPorCpf(cpf) != null) {
			return daoCorrentistaPremium.excluiCorrentista(cpf);
		} else {
			JOptionPane.showMessageDialog(null, "CPF não encontrado...");
			return false;
		}
	}

	public boolean atualizaCorrentistaPremium(EntCorrentistaPremium entCorrentista) {
		DaoCorrentistaPremium daoCorrentistaPremium = new DaoCorrentistaPremium();
		return daoCorrentistaPremium.atualizaCorrentistaPremium(entCorrentista);
	}
}
