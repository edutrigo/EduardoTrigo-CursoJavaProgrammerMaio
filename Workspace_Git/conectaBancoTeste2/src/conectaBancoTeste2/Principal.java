package conectaBancoTeste2;

import java.sql.Connection;

public class Principal {
	
	public static void main (String args[]) {
		
		FabricaConexao conexao = new FabricaConexao();// Instancia a classe que contém o metodo que retorna o objeto de conexão
		

		Connection conexãoRecebida = conexao.criarConexaoComBaseExemplo();
		
		if (conexãoRecebida == null) {
			System.out.println("Deu ruim a conexão e não posso usar o objeto");
		}else {
			System.out.println("Deu bom e posso usar a conexão");
		}
		
	}

}