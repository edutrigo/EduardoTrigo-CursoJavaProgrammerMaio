package servico.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JOptionPane;

import entidade.Endereco;

public class EnderecoCliente {

	// Isso aqui não está incluso no curso é só um "BONUS"
	public Endereco buscarEnderecoPeloCep(String cep) throws Exception {
		String urlApi = "https://viacep.com.br/ws/" + cep + "/json/"; // URL PARA BUSCAR NA API
		Endereco enderecoPopulado = new Endereco();

		URL obj = new URL(urlApi); // CRIAR OBJETO URL COM A STRING DA URL DA API

		HttpURLConnection con = (HttpURLConnection) obj.openConnection(); // ABRE CONEXÃO COM SERVIDOR DA API

		con.setRequestMethod("GET"); // É UM METODO HTTP PARA CONSULTA

		int statusRespostaApi = con.getResponseCode();// RECEBE O STATUS HTTP DA RESPOSTA DA API 200 OU 400

		if (statusRespostaApi == HttpURLConnection.HTTP_OK) {
			// Armazena toda resposta do servidor no objeto dadosEntradaDaApi
			BufferedReader dadosEntradaDaApi = new BufferedReader(new InputStreamReader(con.getInputStream()));

			String linhaEntrada; // String temporaria para montar o string StringBuffer
			
			StringBuffer respostaDaApi = new StringBuffer(); // String buffer que será montada durante a leitura do json

			while ((linhaEntrada = dadosEntradaDaApi.readLine()) != null) {
				respostaDaApi.append(linhaEntrada);
			}

			dadosEntradaDaApi.close();
			String jsonRecebidoDaApi = respostaDaApi.toString();
			System.out.println(jsonRecebidoDaApi);
			enderecoPopulado = jsonParaEndereco(jsonRecebidoDaApi);

		} else {
			JOptionPane.showMessageDialog(null, "Não foi possivel Buscar o endereco do cep informado");
		}

		return enderecoPopulado;
	}

	// Recebe uma String JSON e retorna a entidade endereço
	// Aula teorica de manipulação de string
	public static Endereco jsonParaEndereco(String jsonString) {

		Endereco endereco = new Endereco();

		jsonString = jsonString.trim().substring(1, jsonString.length() - 1);

		String[] parts = jsonString.split(",\\s*");

		for (String part : parts) {

			String[] keyValue = part.split(":\\s*");

			if (keyValue.length == 2) {
				String key = keyValue[0].trim().replaceAll("^\"|\"$", "");
				String value = keyValue[1].trim().replaceAll("^\"|\"$", "");

				switch (key) {
				case "cep":
					endereco.setCep(value);
					break;
				case "logradouro":
					endereco.setLogradouro(value);
					break;
				case "complemento":
					endereco.setComplemento(value);
					break;
				case "bairro":
					endereco.setBairro(value);
					break;
				case "localidade":
					endereco.setLocalidade(value);
					break;
				case "uf":
					endereco.setUf(value);
					break;
				case "ibge":
					endereco.setIbge(value);
					break;
				case "gia":
					endereco.setGia(value);
					break;
				case "ddd":
					endereco.setDdd(value);
					break;
				case "siafi":
					endereco.setSiafi(value);
					break;
				default:

					break;
				}
			}
		}

		return endereco;
	}

}
