package repository;

import java.util.List;

import entity.EntCorrentistaBasico;

public interface RepCorrentistaBasico {

	public boolean adicionaCorrentistaBasico(EntCorrentistaBasico entCorrentista);

	public List<EntCorrentistaBasico> retornaConsultaCorrentista();

	public EntCorrentistaBasico buscaCorrentistaPorCpf(String cpf);

	public boolean excluiCorrentista(String cpf);

	public boolean atualizaCorrentistaBasico(EntCorrentistaBasico entCorrentista);
}