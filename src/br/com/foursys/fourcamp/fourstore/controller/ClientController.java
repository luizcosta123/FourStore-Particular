package br.com.foursys.fourcamp.fourstore.controller;

import br.com.foursys.fourcamp.fourstore.model.Client;
import br.com.foursys.fourcamp.fourstore.service.ClientService;

public class ClientController {
	
	ClientService clientService = new ClientService();
	
	public boolean clientIsRegistered(String cpf) {
		return clientService.clientIsRegistered(cpf);
	}
	
	public Client findByCPF(String cpf) {
		return clientService.findByCPF(cpf);
	}
	
	public void registerClient(String nome, String cpf) {
		Client cliente = new Client(nome, cpf);
		clientService.registerClient(cliente);
	}

	public void registerPix(String chavePix) {
		clientService.registerPix(chavePix);
		
	}

	public void registerPix(String chavePix, String cpf) {
		clientService.registerPix(chavePix, cpf);
	}

}
