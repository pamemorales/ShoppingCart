package com.shopp.shoppingcart.model;

public class SaleDTO {

	private int idSaleDto;
	private  Pay pay;
	private User user;
	private boolean status;
	private double total;
	
	
	public SaleDTO(Sale sale){
		this.idSaleDto = sale.getIdSale();
		this.pay = sale.getPay();
		this.user = sale.getUser();
		this.status = sale.getStatus();
		this.setTotal(sale.getTotal());
		
	}
	
	public Pay getPay() {
		return pay;
	}


	public void setPay(Pay pay) {
		this.pay = pay;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
	
}
