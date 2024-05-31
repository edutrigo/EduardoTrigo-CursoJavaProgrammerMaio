package gerenciaArquivo;

import java.io.BufferedWriter;
import java.io.FileWriter;

import entidades.Gerente;

public class ManipuladorArquivo {
	
	public void registrarGerente (Gerente gerente) {
		
		String enderecoArquivo = "C:\\CursoJavaProgrammerMaio\\CursoJavaProgrammerMaio\\cadastroFuncionario\\registroGerentes.txt";
		
		try {
			
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(enderecoArquivo));
			
			bufferedWriter.append("O nome do gerente é:" + gerente.getNome());
			bufferedWriter.newLine();
			bufferedWriter.append("O cpf do gerente é:" + gerente.getCpf());
			bufferedWriter.newLine();
			bufferedWriter.append("A gerencia do gerente é:" + gerente.getGerencia());
			
			bufferedWriter.close();
				
		} catch (Exception e) {
			System.out.println("Erro ao registrar o gerente!!!!"); 
		}
	}
	

}
