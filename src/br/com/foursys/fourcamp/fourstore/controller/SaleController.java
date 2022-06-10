package br.com.foursys.fourcamp.fourstore.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.foursys.fourcamp.fourstore.enums.PaymentMethod;
import br.com.foursys.fourcamp.fourstore.model.Client;
import br.com.foursys.fourcamp.fourstore.model.Product;
import br.com.foursys.fourcamp.fourstore.model.Sale;
import br.com.foursys.fourcamp.fourstore.service.ClientService;
import br.com.foursys.fourcamp.fourstore.service.SaleService;

public class SaleController {
	
	private SaleService saleService = new SaleService();
	private ClientService clientService = new ClientService();
	
	public String addCart(String sku, Integer quantity) {
		if(saleService.addCart(sku, quantity)) {
			//System.out.println("Verificando a lista: " + saleConsultation() + " acabou!");
			return "\nProduto adicionado com sucesso!\n";
		}
		return "\nO produto nao pode ser adicionado\n";
	}
	
	public String clearCart() {
		saleService.clearCart();
		return "Carrinho limpo";
	}
	
	public List<Product> cart() {
		return saleService.cart();
	}
	
	public String saleRegister(PaymentMethod paymentmethod, String cpf) {
		Client client = clientService.findByCPF(cpf);
		Double amountValue = this.amountValue(saleService.cart());
		Double profit = this.profit(saleService.cart());
		ArrayList teste = new ArrayList(this.cart());
		
		Sale sale = new Sale(client, teste, amountValue, profit, paymentmethod);
		
		saleService.saveSale(sale);
		
		return "\nVenda realizada com sucesso\n" + sale;
	}
	
	public String saleRegister(PaymentMethod paymentmethod) {
		Double amountValue = this.amountValue(saleService.cart());
		Double profit = this.profit(saleService.cart());
		ArrayList teste = new ArrayList(this.cart());
		
		Sale sale = new Sale(teste, amountValue, profit, paymentmethod);
		
		saleService.saveSale(sale);
		
		return "\nVenda realizada com sucesso\n" + sale;
	}
	
	public String saleConsultation() {
		String retorno = "";
		if(saleService.listSale().size() == 0) {
			retorno = "\nNão há historico de vendas!\n";
			return retorno;
		}
		retorno = saleService.listSale().toString();
		return retorno;
	}
	
	public Double amountValue(List<Product> products) {
		Double retorno = 0.0;
		retorno = saleService.amountValue(products);
		return retorno;
	}
	
	public Double profit(List<Product> products) {
		Double retorno = 0.0;
		retorno = saleService.profit(products);
		return retorno;
	}
}




