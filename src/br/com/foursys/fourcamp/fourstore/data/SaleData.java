package br.com.foursys.fourcamp.fourstore.data;

import java.util.ArrayList;

import br.com.foursys.fourcamp.fourstore.model.Sale;

public class SaleData {
	
	static ArrayList<Sale> saleList = new ArrayList<Sale>();
	
	public void save(Sale sale) {
		//System.out.println("Antes de adicionar: " + saleList.toString());
		saleList.add(sale);
		//System.out.println("Depois de adicionar: " + saleList.toString());
	}
	
	public ArrayList<Sale> list() {
			return saleList;
	}
	
}
