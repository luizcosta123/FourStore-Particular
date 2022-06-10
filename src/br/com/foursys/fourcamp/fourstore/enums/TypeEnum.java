package br.com.foursys.fourcamp.fourstore.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum TypeEnum {
	MANGALONGA("92", "Manga Longa"),
	MANGACURTA("93", "Manga Curta"),
	GOLAV("94", "Gola em V"),
	GOLAPOLO("95", "Gola Polo"),
	SKINNY("96", "Skinny");
	
	private String key;
	private String description;
	
	public static final Map<String, TypeEnum> typeMap = new HashMap<String, TypeEnum>();
	static {
		for (TypeEnum type : EnumSet.allOf(TypeEnum.class)) {
			typeMap.put(type.getKey(), type);
		}
	}
	
	public static TypeEnum get(String string) {
		return typeMap.get(string);
	}
	
	TypeEnum(String key, String description) {
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
