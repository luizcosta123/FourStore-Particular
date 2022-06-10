package br.com.foursys.fourcamp.fourstore.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum CategoryEnum {
	
	ACESSORIOS("31", "Acessórios"), 
	BERMUDAS("32", "Bermudas"), 
	BLUSAS("33", "Blusas"), 
	CALCADOS("34", "Calçados"),
	CALCAS("35", "Calças"), 
	CAMISETAS("36", "Camisetas"), 
	CAMISAS("37", "Camisas"), 
	CASACOS("38", "Casacos"),
	INTIMA("39", "Moda Íntima"), 
	JAQUETAS("40", "Jaquetas");

	private String key;
	private String description;
	
	public static final Map<String, CategoryEnum> categoryMap = new HashMap<String, CategoryEnum>();
	static {
		for (CategoryEnum category : EnumSet.allOf(CategoryEnum.class)) {
			categoryMap.put(category.getKey(), category);
		}
	}
	
	public static CategoryEnum get(String string) {
		return categoryMap.get(string);
	}
	
	CategoryEnum(String key, String description) {
		this.key = key;
		this.description = description;
	}

	public String getKey() {
		return key;
	}

	public String getDescription() {
		return description;
	}
}