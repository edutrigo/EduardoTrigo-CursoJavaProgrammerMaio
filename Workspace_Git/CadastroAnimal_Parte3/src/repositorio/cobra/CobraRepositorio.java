package repositorio.cobra;

import java.util.List;

import entidade.Cobra;

public interface CobraRepositorio {

	// Estas são classes (somente assinatura) do DaoCobra
	public boolean saveCobraBD(Cobra cobra);

	public List<Cobra> retQueryCobra();

	public boolean delCobraBD(String caf);

	public boolean updateCobraBD(Cobra cobra);

	public Cobra buscaCobraPorCaf(String caf);

}
