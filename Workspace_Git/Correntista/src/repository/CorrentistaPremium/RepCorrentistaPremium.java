package repository.CorrentistaPremium;

import java.util.List;

import entity.EntCorrentistaPremium;

public interface RepCorrentistaPremium {

	public boolean adicionaCorrentistaPremium(EntCorrentistaPremium entCorrentista);

	public List<EntCorrentistaPremium> retornaConsultaCorrentista();

	public EntCorrentistaPremium buscaCorrentistaPorCpf(String cpf);

	public boolean excluiCorrentista(String cpf);

	public boolean atualizaCorrentistaPremium(EntCorrentistaPremium entCorrentista);
}