package br.com.foursys.fourcamp.fourstore.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum SeasonEnum {
	INVERNO("6090" , "Inverno"), 
	OUTONO("3060" , " Outono"), 
	VERAO("3030" , "Verão"), 
	PRIMAVERA("9012", "Primavera");
	
	private String key;
	private String description;
	
	public static final Map<String, SeasonEnum> seasonMap = new HashMap<String, SeasonEnum>();
	static {
		for (SeasonEnum season : EnumSet.allOf(SeasonEnum.class)) {
			seasonMap.put(season.getKey(), season);
		}
	}
	
	public static SeasonEnum get(String string) {
		return seasonMap.get(string);
	}
	
	SeasonEnum(String key, String description) {
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