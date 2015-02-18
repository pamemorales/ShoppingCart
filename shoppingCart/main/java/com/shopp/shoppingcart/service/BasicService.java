package com.shopp.shoppingcart.service;

import java.util.List;
import java.util.Set;

import com.shopp.shoppingcart.model.Product;
import com.shopp.shoppingcart.model.ProductDTO;

public interface BasicService {

	public List<Product> loadProducts();
	public List<ProductDTO> loadOffers();
	public ProductDTO findByName(String name);
	public List<ProductDTO> findByCategory(int idCategory);
	
}
