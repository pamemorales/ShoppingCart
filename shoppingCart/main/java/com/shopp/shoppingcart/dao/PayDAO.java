package com.shopp.shoppingcart.dao;

import java.util.ArrayList;

import com.shopp.shoppingcart.model.Pay;
import com.shopp.shoppingcart.model.Product;
import com.shopp.shoppingcart.model.TypePay;

public interface PayDAO {

	public TypePay getTypePay();
	public Pay setPay(String name, long creditNumber, TypePay typePay);
	public double getDiscount (double subtotal, ArrayList<Product> productSale, TypePay typePay);
	
}
