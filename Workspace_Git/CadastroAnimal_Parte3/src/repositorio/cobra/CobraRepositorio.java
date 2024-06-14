package repositorio.cobra;

import java.util.List;

import entidade.Cobra;

public interface CobraRepositorio {

	// Estas são classes (somente assinatura) do DaoCobra
	public boolean saveCobraBD(Cobra cobra);

	public boolean delCobraBD(String caf);

	public List<Cobra> retQueryCobra();
}
