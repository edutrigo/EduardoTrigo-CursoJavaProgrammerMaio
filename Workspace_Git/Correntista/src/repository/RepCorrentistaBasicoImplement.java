package repository;

import java.util.List;

import entity.EntCorrentistaBasico;
import persistence.dao.DaoCorrentistaBasico;

public class RepCorrentistaBasicoImplement implements RepCorrentistaBasico {

	public boolean adicionaCorrentistaBasico(EntCorrentistaBasico entCorrentista) {
		DaoCorrentistaBasico daoCorrentistaBasico = new DaoCorrentistaBasico();
		return daoCorrentistaBasico.adicionaCorrentistaBasico(entCorrentista);
	}

	public List<EntCorrentistaBasico> RetornaConsultaCorrentista() {
		DaoCorrentistaBasico daoCorrentistaBasico = new DaoCorrentistaBasico();
		return daoCorrentistaBasico.RetornaConsultaCorrentista();
	}

	public EntCorrentistaBasico buscaCorrentistaPorCpf(String cpf) {
		for (EntCorrentistaBasico entCorrentistaBasico : RetornaConsultaCorrentista()) {
			if (entCorrentistaBasico.getCpf().toString().equals(cpf)) {
				return entCorrentistaBasico;
			}
		}
		return null;
	}
}
