package br.com.foursys.fourcamp.fourstore.service;

import java.util.ArrayList;
import java.util.List;

import br.com.foursys.fourcamp.fourstore.controller.ProductController;
import br.com.foursys.fourcamp.fourstore.data.ProductData;
import br.com.foursys.fourcamp.fourstore.data.SaleData;
import br.com.foursys.fourcamp.fourstore.model.Product;
import br.com.foursys.fourcamp.fourstore.model.Sale;

public class SaleService {
	
	static ArrayList<Product> cart = new ArrayList<Product>();
	ProductController productController = new ProductController();
	ProductData productdata = new ProductData();
	SaleData saleData = new SaleData();
	
	public void saveSale(Sale sale) {
		saleData.save(sale);
	}
	
	public List<Sale> listSale() {
		return saleData.list();
	}
	
	public Double amountValue(List<Product> products) {
		Double amountValue = 0.0;
		for(int i = 0; i < products.size(); i++) {
			amountValue += products.get(i).getSalePrice() * products.get(i).getQuantity();
		}
		return amountValue;
	}
	
	public Double profit(List<Product> products) {
		Double profit = 0.0;
		Double amountValuePurchasePrice = 0.0;
		Double amountValueSalePrice = 0.0;
		
		for(int i = 0; i < products.size(); i++) {
			amountValueSalePrice += products.get(i).getSalePrice() * products.get(i).getQuantity();
			amountValuePurchasePrice += products.get(i).getPurchasePrice() * products.get(i).getQuantity();
		}
		
		profit = amountValueSalePrice - amountValuePurchasePrice;
		
		return profit;
	}
	
	public boolean addCart(String sku, Integer quantity) {
		Product currentProduct = productController.getProductBySkuObject(sku);
		Product GenericProduct = new Product(sku, quantity, currentProduct.getPurchasePrice(), currentProduct.getSalePrice());
		
		cart.add(GenericProduct);
		
		return true;
	}
	
	public void clearCart() {
		cart.clear();
	}
	
	public List<Product> cart() {
		return cart;
	}
	
}
