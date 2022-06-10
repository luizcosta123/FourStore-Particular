package br.com.foursys.fourcamp.fourstore.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {

	public int validationMenu(String entrada, String verificMenu) {
		int option;

		if (entrada.matches(verificMenu)) {
			option = Integer.parseInt(entrada);
			return option;
		} else {
			option = -1;
			return option;
		}

	}

	public boolean validateCard(String acceptedCards) {
		Boolean retorno = false;

		if (acceptedCards.length() != 16 && acceptedCards.length() != 19) {
			return retorno;
		}
		retorno = checkLuhn(acceptedCards);

		return retorno;
	}

	private boolean checkLuhn(String value) {
		value = value.replace(" ", "");
		int sum = 0;
		boolean shouldDouble = false;

		for (int i = value.length() - 1; i >= 0; i--) {
			Integer digit = Integer.parseInt(value.substring(i, i + 1));

			if (shouldDouble) {
				if ((digit *= 2) > 9) {
					digit -= 9;
				}
			}

			sum += digit;
			shouldDouble = !shouldDouble;
		}
		return (sum % 10) == 0;
	}
	
	public boolean validateSkuRegex(String sku) {
		String pattern = "([0-9]{14})";
		Pattern regex = Pattern.compile(pattern);
		Matcher matcher = regex.matcher(sku);
		
		if(!matcher.matches()) {
			return false;
		}
		return true;

	}
	
	public boolean validateCpfRegex(String cpf) {
		String pattern = "([0-9]{3}[\\.][0-9]{3}[\\.][0-9]{3}[\\-][0-9]{2})";
		Pattern regex = Pattern.compile(pattern);
		
		Matcher matcher = regex.matcher(cpf);
		
		if(!matcher.matches()) {
			return false;
		}
		return true;

	}
	
	public boolean validateCnpjRegex(String cnpj) {
		String pattern = "\\b([0-9]{2})\\.([0-9]{3})\\.([0-9]{3})\\/([0-9]{4})\\-([0-9]{2})";
		Pattern regex = Pattern.compile(pattern);
		
		Matcher matcher = regex.matcher(cnpj);
		
		if(!matcher.matches()) {
			return false;
		}
		return true;
	}
	
	public boolean validateEmail(String email) {
		String pattern = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)"
					   + "*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7"
					   + "f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a"
					   + "-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25"
					   + "[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|["
					   + "01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-"
					   + "\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f"
					   + "])+)\\])";
		Pattern regex = Pattern.compile(pattern);
		Matcher matcher = regex.matcher(email);
		
		if(!matcher.matches()) {
			return false;
		}
		return true;
	}
	
	public boolean validatePhone(String tell) {
		String pattern = "(\\(?\\d{2}\\)?\\s)?(\\d{4,5}\\-\\d{4})";
		Pattern regex = Pattern.compile(pattern);
		Matcher matcher = regex.matcher(tell);
		
		if(!matcher.matches()) {
			return false;
		}
		return true;
	}
	
	public Boolean cpfValidation(String cpf) {
		
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
	
	public boolean validatePixRegex(String pixKey) {
		if(validateCpfRegex(pixKey)) {
			return true;
		}
		
		if(validateCnpjRegex(pixKey)) {
			return true;
		}
		
		if(validateEmail(pixKey)) {
			return true;
		}
		
		if(validatePhone(pixKey)) {
			return true;
		}
		
		return false;
	}
	
}