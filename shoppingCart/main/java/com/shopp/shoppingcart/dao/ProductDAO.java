package com.shopp.shoppingcart.dao;

import java.util.List;
import java.util.Set;

import com.shopp.shoppingcart.model.Product;


public interface ProductDAO {

	List<Product> findByCategory(int idCategory);
	Product findByName(String name);
	Product findById(int idProduct);
	List<Product> getProducts();
	Product loadOffer(int idProduct, double oPrice);
	List<Product> getOffers();
	
	
}
