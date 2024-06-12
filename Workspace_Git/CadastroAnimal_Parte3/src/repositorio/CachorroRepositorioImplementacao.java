package repositorio;

import java.util.List;

import bancoDados.DaoCachorro;
import entidade.Cachorro;

public class CachorroRepositorioImplementacao implements CachorroRepositorio {

	@Override
	public boolean saveCachorroBD(Cachorro cachorro) {
		DaoCachorro daoCachorro = new DaoCachorro();

		return daoCachorro.saveCachorroBD(cachorro);
	}

	public boolean delCachorroBD(String caf) {
		DaoCachorro daoCachorro = new DaoCachorro();

		return daoCachorro.delCachorroBD(caf);
	}

	@Override
	public List<Cachorro> retQueryCachorro() {
		DaoCachorro daoCachorro = new DaoCachorro();

		return daoCachorro.retQueryCachorro();
	}
}
