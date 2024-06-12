package repositorio;

import java.util.List;

import entidade.Cachorro;

public interface CachorroRepositorio {

	// Estas são classes (somente assinatura) do DaoCachorro (tipo "package specification"
	public boolean saveCachorroBD(Cachorro cachorro);

	public boolean delCachorroBD(String caf);

	public List<Cachorro> retQueryCachorro();

}
