package com.shopp.shoppingcart.web;

import java.util.List;
import com.shopp.shoppingcart.model.ProductDTO;
import com.shopp.shoppingcart.service.BasicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {
    @Autowired
    private BasicService basicService;
    private ProductDTO result;
    
    @RequestMapping(value = "product/{name}", method = RequestMethod.GET)
    @ResponseBody
    public ProductDTO loadProductByName(@PathVariable String name) {

        result = basicService.findByName(name);

        return result;

    }

     @RequestMapping(value = "category/{idcategory}", method = RequestMethod.GET)
     @ResponseBody
     public List<ProductDTO> findByCategory(@PathVariable int idcategory) {
    	 List<ProductDTO> prods =  basicService.findByCategory(idcategory);
    	 return prods;
     }
    
     @RequestMapping(value = "/offers", method = RequestMethod.GET)
     @ResponseBody
     public List<ProductDTO> loadOffers() {
     List<ProductDTO> productDto = basicService.loadOffers();
     return productDto;
     }

}
