package services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JOptionPane;

import entity.EntEndereco;

public class SrvApiCep {

	public static EntEndereco converteJsonParaEndereco(String jsonString) {

		EntEndereco entEndereco = new EntEndereco();

		jsonString = jsonString.trim().substring(1, jsonString.length() - 1);

		String[] parts = jsonString.split(",\\s*");

		for (String part : parts) {

			String[] keyValue = part.split(":\\s*");

			if (keyValue.length == 2) {
				String key = keyValue[0].trim().replaceAll("^\"|\"$", "");
				String value = keyValue[1].trim().replaceAll("^\"|\"$", "");

				switch (key) {
				case "cep":
					entEndereco.setCep(value);
					break;
				case "logradouro":
					entEndereco.setLogradouro(value);
					break;
				case "complemento":
					break;
				case "bairro":
					break;
				case "localidade":
					entEndereco.setLocalidade(value);
					break;
				case "uf":
					entEndereco.setUf(value);
					break;
				case "ibge":
					break;
				case "gia":
					break;
				case "ddd":
					break;
				case "siafi":
					break;
				default:
					break;
				}
			}
		}
		return entEndereco;
	}

	public static EntEndereco buscaEndCep(String cep) throws Exception {

		String urlApi = "https://viacep.com.br/ws/" + cep + "/json/";
		EntEndereco entEndereco = new EntEndereco();

		URL obj = new URL(urlApi);

		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");

		int statusRespostaApi = con.getResponseCode();

		if (statusRespostaApi == HttpURLConnection.HTTP_OK) {
			BufferedReader dadosEntradaDaApi = new BufferedReader(new InputStreamReader(con.getInputStream()));

			String linhaEntrada;

			StringBuffer respostaDaApi = new StringBuffer();

			while ((linhaEntrada = dadosEntradaDaApi.readLine()) != null) {
				respostaDaApi.append(linhaEntrada);
			}

			dadosEntradaDaApi.close();
			String jsonRecebidoDaApi = respostaDaApi.toString();
			System.out.println(jsonRecebidoDaApi);
			entEndereco = converteJsonParaEndereco(jsonRecebidoDaApi);

		} else {
			JOptionPane.showMessageDialog(null, "Não foi possivel buscar o endereco do CEP informado");
		}

		return entEndereco;
	}
}
