package manipulaArq;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class ManipulaArquivo {

	public void InsereCachorro(entidade.Cachorro cachorro) {

		String diretorio = "D:\\EDUARDO\\Impacta_Curso_Java\\git\\EduardoTrigo\\Workspace_Git\\CadastroAnimal_Parte3\\RegCachorro.txt";

		try {

			BufferedWriter buffer = new BufferedWriter(new FileWriter(diretorio));

			buffer.append("Registro Cachorro");
			buffer.newLine();
			buffer.append("-----------------");
			buffer.newLine();
			buffer.append("Nome....:" + cachorro.getNome());
			buffer.newLine();
			buffer.append("CAF.....:" + cachorro.getCaf());
			buffer.newLine();
			buffer.append("Cor Pelo:" + cachorro.getCorPelo());

			buffer.close();

		} catch (Exception e) {
			System.out.println("Erro ao registrar CACHORRO!!!!");
		}
	}

	public void InsereCobra(entidade.Cobra cobra) {

		String diretorio = "D:\\EDUARDO\\Impacta_Curso_Java\\git\\EduardoTrigo\\Workspace_Git\\CadastroAnimal_Parte3\\RegCobra.txt";

		try {

			BufferedWriter buffer = new BufferedWriter(new FileWriter(diretorio));

			buffer.append("Registro Cobra");
			buffer.newLine();
			buffer.append("--------------");
			buffer.newLine();
			buffer.append("Nome.......:" + cobra.getNome());
			buffer.newLine();
			buffer.append("CAF........:" + cobra.getCaf());
			buffer.newLine();
			buffer.append("Tipo Veneno:" + cobra.getTipoVeneno());

			buffer.close();

		} catch (Exception e) {
			System.out.println("Erro ao registrar COBRA!!!!");
		}
	}
}
