package repository;

import java.util.List;

import javax.swing.JOptionPane;

import entity.EntCorrentistaBasico;
import persistence.dao.DaoCorrentistaBasico;

public class RepCorrentistaBasicoImplement implements RepCorrentistaBasico {

	public boolean adicionaCorrentistaBasico(EntCorrentistaBasico entCorrentista) {
		DaoCorrentistaBasico daoCorrentistaBasico = new DaoCorrentistaBasico();
		return daoCorrentistaBasico.adicionaCorrentistaBasico(entCorrentista);
	}

	public List<EntCorrentistaBasico> retornaConsultaCorrentista() {
		DaoCorrentistaBasico daoCorrentistaBasico = new DaoCorrentistaBasico();
		return daoCorrentistaBasico.retornaConsultaCorrentista();
	}

	public EntCorrentistaBasico buscaCorrentistaPorCpf(String cpf) {
		for (EntCorrentistaBasico entCorrentistaBasico : retornaConsultaCorrentista()) {
			if (entCorrentistaBasico.getCpf().toString().equals(cpf)) {
				return entCorrentistaBasico;
			}
		}
		return null;
	}

	public boolean excluiCorrentista(String cpf) {
		DaoCorrentistaBasico daoCorrentistaBasico = new DaoCorrentistaBasico();

		if (buscaCorrentistaPorCpf(cpf) != null) {
			return daoCorrentistaBasico.excluiCorrentista(cpf);
		} else {
			JOptionPane.showMessageDialog(null, "CPF não encontrado...");
			return false;
		}
	}

	public boolean atualizaCorrentistaBasico(EntCorrentistaBasico entCorrentista) {
		DaoCorrentistaBasico daoCorrentistaBasico = new DaoCorrentistaBasico();
		return daoCorrentistaBasico.atualizaCorrentistaBasico(entCorrentista);
	}
}
