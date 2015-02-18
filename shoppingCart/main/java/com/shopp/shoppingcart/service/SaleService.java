package com.shopp.shoppingcart.service;

import java.util.List;

import com.shopp.shoppingcart.model.Pay;
import com.shopp.shoppingcart.model.Sale;
import com.shopp.shoppingcart.model.SaleDTO;
import com.shopp.shoppingcart.model.User;

public interface SaleService {
	
	public void initLineSale();
	public void addProduct(int idline, int idProduct, int quantity);
	public void removeProduct(int idSale, int idProduct);
	public void save(Sale sale);
	public Sale generateSale(User user, Pay pay);
    public List<SaleDTO> getSalesConfirm();



}
