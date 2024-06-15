package repositorio.cachorro;

import java.util.List;

import bancoDados.dao.DaoCachorro;
import entidade.Cachorro;

public class CachorroRepositorioImplementacao implements CachorroRepositorio {

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

	@Override
	public boolean delCachorroBD(String caf) {
		DaoCachorro daoCachorro = new DaoCachorro();

		if (buscaCachorroPorCaf(caf) != null) {
			return daoCachorro.delCachorroBD(caf);
		}
		else {
			return false;
		}
	}

	@Override
	public boolean updateCachorroBD(Cachorro cachorro) {
		DaoCachorro daoCachorro = new DaoCachorro();
		return daoCachorro.updateCachorroBD(cachorro);
	}

	@Override
	public Cachorro buscaCachorroPorCaf(String caf) {
		for (Cachorro cachorro : retQueryCachorro()) {
			if (cachorro.getCaf().toString().equals(caf)) {
				return cachorro;
			}
		}
		return null;
	}
}