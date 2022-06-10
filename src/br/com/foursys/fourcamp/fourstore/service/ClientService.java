package br.com.foursys.fourcamp.fourstore.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.foursys.fourcamp.fourstore.data.ClientData;
import br.com.foursys.fourcamp.fourstore.model.Client;

public class ClientService {
	
	ClientData clientData = new ClientData();
	
	public Boolean cpfValidation(String cpf) {
		
		
		String pattern = "([0-9]{3}[\\.][0-9]{3}[\\.][0-9]{3}[\\-][0-9]{2})";
		Pattern regex = Pattern.compile(pattern);
		
		Matcher matcher = regex.matcher(cpf);
		
		if(!matcher.matches()) {
			System.out.println("Cpf escrito errado");  // Apagar essa linha
			return false;
		}
		
		// o c�digo acima deve ir para o controller
		
		String S1, S2, S3, S4, S5, S6, S7, S8, S9, check = "";
		int N1, N2, N3, N4, N5, N6, N7, N8, N9, verify1, verify2;

		S1 = cpf.substring(0, 1);
		N1 = Integer.valueOf(S1);
		S2 = cpf.substring(1, 2);
		N2 = Integer.parseInt(S2);
		S3 = cpf.substring(2, 3);
		N3 = Integer.valueOf(S3);
		S4 = cpf.substring(4, 5);
		N4 = Integer.parseInt(S4);
		S5 = cpf.substring(5, 6);
		N5 = Integer.valueOf(S5);
		S6 = cpf.substring(6, 7);
		N6 = Integer.parseInt(S6);
		S7 = cpf.substring(8, 9);
		N7 = Integer.parseInt(S7);
		S8 = cpf.substring(9, 10);
		N8 = Integer.valueOf(S8);
		S9 = cpf.substring(10, 11);
		N9 = Integer.parseInt(S9);

		verify1 = (N1 * 10 + N2 * 9 + N3 * 8 + N4 * 7 + N5 * 6 + N6 * 5 + N7 * 4 + N8 * 3 + N9 * 2);

		if ((verify1 % 11) < 2)
			verify1 = 0;
		else
			verify1 = 11 - (verify1 % 11);

		verify2 = (N1 * 11 + N2 * 10 + N3 * 9 + N4 * 8 + N5 * 7 + N6 * 6 + N7 * 5 + N8 * 4 + N9 * 3 + verify1 * 2);
		if ((verify2 % 11) < 2)
			verify2 = 0;
		else
			verify2 = 11 - (verify2 % 11);
		check = (S1 + S2 + S3 + "." + S4 + S5 + S6 + "." + S7 + S8 + S9 + "-" + verify1 + "" + verify2);

		if (check.equals(cpf))
			return true;
		else
			return false;
	}
	
	public boolean clientIsRegistered(String cpf) {
		if(clientData.findByCPF(cpf) != null) {
			return true;
		}
		
		return false;
	}
	
	
	public Client findByCPF(String cpf) {
		return clientData.findByCPF(cpf);
	}
	
	public void registerClient(Client client) {
		clientData.save(client);
		}

	public void registerPix(String pixKey) {
		Client client = new Client(pixKey);
		clientData.save(client);
	}

	public void registerPix(String pixKey, String cpf) {
		Client client = clientData.findByCPF(cpf);
		client.setPixKey(pixKey);		
	}

}