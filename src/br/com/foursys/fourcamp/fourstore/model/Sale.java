package br.com.foursys.fourcamp.fourstore.model;

import java.util.ArrayList;
import java.util.List;

import br.com.foursys.fourcamp.fourstore.enums.PaymentMethod;

public class Sale {
	
	private Client client;
	private List<Product> products = new ArrayList<Product>();
	private Double amountValue;
	private Double profit;
	private PaymentMethod paymentMethod;
	
	public Sale(List<Product> products, Double amountValue, Double profit, PaymentMethod paymentMethod) {
		this.products = products;
		this.amountValue = amountValue;
		this.profit = profit;
		this.paymentMethod = paymentMethod;
	}
	
	public Sale(Client client, List<Product> products, Double amountValue, Double profit, PaymentMethod paymentMethod) {
		this.client = client;
		this.products = products;
		this.amountValue = amountValue;
		this.profit = profit;
		this.paymentMethod = paymentMethod;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Double getAmountValue() {
		return amountValue;
	}

	public void setAmountValue(Double amountValue) {
		this.amountValue = amountValue;
	}
	
	public Double getProfit() {
		return profit;
	}

	public void setProfit(Double profit) {
		this.profit = profit;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@Override
	public String toString() {
		if(this.client != null) {
			return "\n\nCliente: " +  client.getName() 
			 + "\n\nChave pix: " +  client.getPixKey() 
		     + "\nProdutos: " + products.toString()
		     + "\nValor total: " + amountValue
		     + "\nLucro: " + profit
		     + "\nMétodo de pagamento: " + paymentMethod.getDescription() + "\n";
		} else {
			return "\nVenda para o cliente: cliente não informado"
			 + "\nProdutos: " + products.toString()
		     + "\nValor total: " + amountValue
		     + "\nLucro: " + profit
		     + "\nMétodo de pagamento: " + paymentMethod.getDescription() + "\n";
		}
		
	}
	

	
} 
