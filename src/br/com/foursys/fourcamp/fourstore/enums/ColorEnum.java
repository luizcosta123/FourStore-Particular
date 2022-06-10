package br.com.foursys.fourcamp.fourstore.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum ColorEnum {
	AMARELO("01" , "Amarelo"), 
	AZUL("02" , "Azul"), 
	BRANCO("03", "Branco"), 
	CINZA("04", "Cinza"), 
	LARANJA("05", "Laranja"), 
	MARROM("06" , "Marrom"), 
	PRETO("07", "Preto"), 
	ROXO("08" , "Roxo"), 
	VERDE("09" , "Verde"), 
	VERMELHO("10", "Vermelho");

	private String key;
	private String description;
	
	public static final Map<String, ColorEnum> colorMap = new HashMap<String, ColorEnum>();
	static {
		for (ColorEnum color : EnumSet.allOf(ColorEnum.class)) {
			colorMap.put(color.getKey(), color);
		}
	}
	
	public static ColorEnum get(String string) {
		return colorMap.get(string);
	}
	
	ColorEnum(String key, String description) {
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