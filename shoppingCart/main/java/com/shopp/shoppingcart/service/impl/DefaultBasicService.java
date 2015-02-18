package com.shopp.shoppingcart.service.impl;

import com.shopp.shoppingcart.dao.ProductDAO;
import com.shopp.shoppingcart.model.Product;
import com.shopp.shoppingcart.model.ProductDTO;
import com.shopp.shoppingcart.service.BasicService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class DefaultBasicService implements BasicService {

    private ProductDAO productDao;
    private ProductDTO productDto;
    
    @Autowired
    public DefaultBasicService(ProductDAO productDao) {
		super();
		this.productDao = productDao;
	}
    
    @Override
    public List<Product> loadProducts() {
    	
        return productDao.getProducts();
    }
    @Override
    public List<ProductDTO> loadOffers() {
    	
    	List<ProductDTO> prodsDto = new ArrayList<ProductDTO>();
    	for(Product prod : (productDao.getOffers())){
    		productDto = new ProductDTO(prod);
    		prodsDto.add(productDto);
    	}
    	return  prodsDto;
    }
    @Override
    public ProductDTO findByName(String name) {
    	productDto = new ProductDTO(productDao.findByName(name));
        return productDto;

    }
    
    @Override
    public List<ProductDTO> findByCategory(int idCategory) {
        List<ProductDTO> prodsDto = new ArrayList<ProductDTO>();
    	for(Product prod : (productDao.findByCategory(idCategory))){
    		productDto = new ProductDTO(prod);
    		prodsDto.add(productDto);
    	}
    	
    	return prodsDto;
    }

}
