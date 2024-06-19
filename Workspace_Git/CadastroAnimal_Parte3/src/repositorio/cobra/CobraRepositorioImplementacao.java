package repositorio.cobra;

import java.util.List;

import bancoDados.dao.DaoCobra;
import entidade.Cobra;
import servico.EntidadeServico;

public class CobraRepositorioImplementacao implements CobraRepositorio {

	@Override
	public boolean saveCobraBD(Cobra cobra, String peso) {
		DaoCobra daoCobra = new DaoCobra();
		EntidadeServico entidadeServico = new EntidadeServico();

		if (entidadeServico.buscaPrecoCobra(peso) == null) {
			return false;
		} else {
			cobra.setPreco(entidadeServico.buscaPrecoCobra(peso));
			return daoCobra.saveCobraBD(cobra);
		}
	}

	@Override
	public boolean delCobraBD(String caf) {
		DaoCobra daoCobra = new DaoCobra();

		if (buscaCobraPorCaf(caf) != null) {
			return daoCobra.delCobraBD(caf);
		} else {
			return false;
		}
	}

	@Override
	public List<Cobra> retQueryCobra() {
		DaoCobra daoCobra = new DaoCobra();

		return daoCobra.retQueryCobra();
	}

	@Override
	public boolean updateCobraBD(Cobra cobra) {
		DaoCobra daoCobra = new DaoCobra();
		return daoCobra.updateCobraBD(cobra);
	}

	@Override
	public Cobra buscaCobraPorCaf(String caf) {
		for (Cobra cobra : retQueryCobra()) {
			if (cobra.getCaf().toString().equals(caf)) {
				return cobra;
			}
		}
		return null;
	}

}
