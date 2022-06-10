package br.com.foursys.fourcamp.fourstore.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum SizeEnum {
	PP("50" , "Tamanho PP"), 
	P("51" , " Tamanho P"), 
	M("52" , "Tamanho M"), 
	G("53", "Tamanho G"),
	GG("54", "Tamanho GG");

	
	private String key;
	private String description;
	
	public static final Map<String, SizeEnum> sizeMap = new HashMap<String, SizeEnum>();
	static {
		for (SizeEnum size : EnumSet.allOf(SizeEnum.class)) {
			sizeMap.put(size.getKey(), size);
		}
	}
	
	public static SizeEnum get(String string) {
		return sizeMap.get(string);
	}
	
	SizeEnum(String key, String description) {
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