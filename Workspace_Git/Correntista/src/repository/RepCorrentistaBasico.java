package repository;

import java.util.List;

import entity.EntCorrentistaBasico;

public interface RepCorrentistaBasico {

	public boolean adicionaCorrentistaBasico(EntCorrentistaBasico entCorrentista);
	
	public List<EntCorrentistaBasico> RetornaConsultaCorrentista();

	public EntCorrentistaBasico buscaCorrentistaPorCpf(String cpf);
}
