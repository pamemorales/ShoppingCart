package com.shopp.shoppingcart.dao;


import java.util.List;

import com.shopp.shoppingcart.model.Sale;

public interface SaleDAO {
	
	public Sale getSale(int idSale);
	public void loadSale(Sale sale);
	public List<Sale> getSalesConfirm();
	
	
}
