package repositorio;

import java.util.List;

import entidade.Cachorro;

public interface CachorroRepositorio {

	// Estas são classes (somente assinatura) do DaoCachorro
	public boolean saveCachorroBD(Cachorro cachorro);

	public List<Cachorro> retQueryCachorro();

}
