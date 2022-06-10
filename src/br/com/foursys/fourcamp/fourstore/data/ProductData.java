package br.com.foursys.fourcamp.fourstore.data;

import java.util.ArrayList;

import br.com.foursys.fourcamp.fourstore.interfaces.DataInterfaces;
import br.com.foursys.fourcamp.fourstore.model.Product;


public class ProductData implements DataInterfaces<Product> {
	private static ArrayList<Product> productList = new ArrayList<Product>();
	
	@Override
	public void save(Product product) {
		productList.add(product);
	}
	
	@Override
	public void update(Product product) {
		for(int i = 0; i < productList.size(); i++) {
			Product listProduct = productList.get(i);
			if(listProduct.getId().equals(product.getId())) {
				listProduct.update(product);
			}
		}
	}
	
	public Product getProductById (String id) {
		for(int i = 0; i < productList.size(); i++) {
			String productId = productList.get(i).getId();
			if(productId.equals(id)) {
				return productList.get(i);
			}
		}
		return null;
	}
	
	public Product getProductBySku (String sku) {
		for(int i = 0; i < productList.size(); i++) {
			String productSku = productList.get(i).getSku();
			if(productSku.equals(sku)) {
				return productList.get(i);
			}
		}
		return null;
	}
	
	@Override
	public ArrayList<Product> listAll() {
		if(productList != null) {
			return productList;
		}
		return null;
	}
	
	@Override
	public void delete(Product product) {
		for(int i = 0; i < productList.size(); i++) {
			Product listProduct = productList.get(i);
			if(listProduct.getId().equals(product.getId())) {
				productList.remove(i);
			}
		}
	}
}
