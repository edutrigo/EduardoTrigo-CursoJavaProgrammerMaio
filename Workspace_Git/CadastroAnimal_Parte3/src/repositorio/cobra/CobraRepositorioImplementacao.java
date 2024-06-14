package repositorio.cobra;

import java.util.List;

import bancoDados.dao.DaoCachorro;
import bancoDados.dao.DaoCobra;
import entidade.Cachorro;
import entidade.Cobra;

public class CobraRepositorioImplementacao implements CobraRepositorio {

	@Override
	public boolean saveCobraBD(Cobra cobra) {
		DaoCobra daoCobra = new DaoCobra();

		return daoCobra.saveCobraBD(cobra);
	}

	@Override
	public boolean delCobraBD(String caf) {
		DaoCobra daoCobra = new DaoCobra();

		for (Cobra cobra : retQueryCobra()) {
			if (cobra.getCaf().toString().equals(caf)) {
				return daoCobra.delCobraBD(caf);
			}
		}
		return false;
	}

	@Override
	public List<Cobra> retQueryCobra() {
		DaoCobra daoCobra = new DaoCobra();

		return daoCobra.retQueryCobra();
	}
}
