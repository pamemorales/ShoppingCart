package com.shopp.shoppingcart.model;

public class ProductDTO {

	private int id;
	private String name;
	private double price;
	private double ofprice=0.0;

	public double getOfprice() {
		return ofprice;
	}

	public void setOfprice(double ofprice) {
		this.ofprice = ofprice;
	}
	
	public ProductDTO(Product prod) {
		
		this.id = prod.getIdProduct();
		this.name = prod.getName();
		this.price = prod.getPrice();
		this.ofprice = prod.getOfferPrice(); 
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}



}

