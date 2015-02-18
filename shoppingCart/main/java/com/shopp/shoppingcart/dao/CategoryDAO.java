package com.shopp.shoppingcart.dao;

import java.util.List;

import com.shopp.shoppingcart.model.Category;

public interface CategoryDAO {

	public List<Category> findAll();
	public Category findById(int idCategory);
	
}
