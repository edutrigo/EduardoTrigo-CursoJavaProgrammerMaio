package repositorio;

import java.util.List;

import bancoDados.DaoCobra;
import entidade.Cobra;

public class CobraRepositorioImplemetacao implements CobraRepositorio {

	@Override
	public boolean saveCobraBD(Cobra cobra) {
		DaoCobra daoCobra = new DaoCobra();

		return daoCobra.saveCobraBD(cobra);
	}

	@Override
	public List<Cobra> retQueryCobra() {
		DaoCobra daoCobra = new DaoCobra();

		return daoCobra.retQueryCobra();
	}
}
