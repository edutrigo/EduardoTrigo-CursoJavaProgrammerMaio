package repositorio.cachorro;

import java.util.List;

import entidade.Cachorro;

public interface CachorroRepositorio {

	// Estas são classes (somente assinatura) do DaoCachorro (tipo "package
	// specification"
	public boolean saveCachorroBD(Cachorro cachorro, String peso);

	public List<Cachorro> retQueryCachorro();

	public boolean delCachorroBD(String caf);

	public boolean updateCachorroBD(Cachorro cachorro);

	public Cachorro buscaCachorroPorCaf(String caf);
}
