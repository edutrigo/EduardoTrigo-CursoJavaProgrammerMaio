package repositorio;

import java.util.List;

import bancoDados.DaoCachorro;
import entidade.Cachorro;

public class CachorroRepositorioImplemetacao implements CachorroRepositorio {

	@Override
	public boolean saveCachorroBD(Cachorro cachorro) {
		DaoCachorro daoCachorro = new DaoCachorro();

		return daoCachorro.saveCachorroBD(cachorro);
	}

	@Override
	public List<Cachorro> retQueryCachorro() {
		DaoCachorro daoCachorro = new DaoCachorro();

		return daoCachorro.retQueryCachorro();
	}
}
