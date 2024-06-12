package repositorio;

import java.util.List;

import bancoDados.DaoCobra;
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

		return daoCobra.delCobraBD(caf);
	}

	@Override
	public List<Cobra> retQueryCobra() {
		DaoCobra daoCobra = new DaoCobra();

		return daoCobra.retQueryCobra();
	}
}
