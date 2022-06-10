package br.com.foursys.fourcamp.fourstore.service;

import java.util.ArrayList;

import br.com.foursys.fourcamp.fourstore.data.ProductData;
import br.com.foursys.fourcamp.fourstore.model.Product;

public class ProductService {
	
	private static ProductData productData = new ProductData();

	public void cadProduct(Product product) {
		productData.save(product);
	}
	
	public boolean productIsRegistered(String sku) {
		if(productData.getProductBySku(sku) == null) {
			return false;
		}
		return true;
	}
	
	public Product getById(String id) {
		return productData.getProductById(id);
	}
	
	public Product getBySku(String sku) {
		return productData.getProductBySku(sku);
	}
	
	public Boolean updateBySku(Product updatedProduct) {
		String Sku = updatedProduct.getSku();

		Product originalProduct = productData.getProductBySku(Sku);
		if(originalProduct == null) {
			return false;
		}

		return update(updatedProduct, originalProduct);
	}
	
	private Boolean update(Product updatedProduct, Product originalProduct) { 
		Integer updatedQuantity = updatedProduct.getQuantity();
		if(updatedQuantity == Integer.MAX_VALUE) {
			updatedProduct.setQuantity(originalProduct.getQuantity()); 
		}
		
		if(updatedQuantity < 0) {
			return false;
		}
		
		Double updatedPurchasePrice = updatedProduct.getPurchasePrice();
		if(updatedPurchasePrice == 0.0) {
			updatedProduct.setPurchasePrice(originalProduct.getPurchasePrice()); 
		}
		
		if(updatedPurchasePrice < 0) {
			return false;
		}
		
		Double updatedSalePrice = updatedProduct.getSalePrice();
		if(updatedSalePrice == 0.0) {
			updatedProduct.setSalePrice(originalProduct.getSalePrice()); 
		}
		
		if(updatedSalePrice < 0) {
			return false;
		}
		
		productData.update(updatedProduct);
		return true;
	}
	
	public Boolean deleteProductById(String id) {
		Product product = productData.getProductById(id);
		return this.deleteProduct(product);
	}
	
	public Boolean deleteProductBySku(String sku) {
		Product product = productData.getProductBySku(sku);
		return this.deleteProduct(product);
	}
	
	private Boolean deleteProduct(Product product) {
		if(product == null) {
			return false;	
		}
		productData.delete(product);
		return true;
	}
	
	public String listProductService() {
		String retorno = "";
		ArrayList<Product> lista = new ArrayList<Product>();
		lista = productData.listAll();
		if(lista.size() != 0) {
			for (Product list : lista) {
				retorno += list.toString();
			}
		} else {
			retorno = "\nNão há produtos cadastrados!\n";
		}

		return retorno;
	}
	
	public Boolean haveStock(String sku, Integer quantity) {
		Product productInStock = productData.getProductBySku(sku);
		if(productInStock != null) {
			Integer quantityInStock = productInStock.getQuantity();
			if(quantityInStock >= quantity) {
				return true;
			}
		}

		return false;
	}
	
	public Product getProductBySku (String sku) {
		return productData.getProductBySku(sku);
	}

	public void decrementProduct(String sku, Integer qtt) {
		Product product = productData.getProductBySku(sku);
		product.decrementProduct(qtt);
		}
	
}



