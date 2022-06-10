package br.com.foursys.fourcamp.fourstore.controller;

import br.com.foursys.fourcamp.fourstore.utils.Validations;

public class MenuController {
	Validations validations;
	public MenuController() {
		this.validations=new Validations();
		
	}
	public int validationRegexMenu(String entrada, String verificMenu) {
		return validations.validationMenu(entrada, verificMenu);
	}
	
	public boolean validarCpf(String cpf) {
		boolean isValid=validations.cpfValidation(cpf);
		return isValid;
	}
	
	public boolean validateCpfRegex(String cpf) {
		return validations.validateCpfRegex(cpf);
	}
	
	public boolean validationCard(String acceptedCards) {
		return validations.validateCard(acceptedCards);
	}
	
	public boolean validatePixRegex(String pix) {
		return validations.validatePixRegex(pix);
	}
		
}







