package com.shopp.shoppingcart.web;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopp.shoppingcart.model.ProductDTO;
import com.shopp.shoppingcart.model.Sale;
import com.shopp.shoppingcart.model.SaleDTO;
import com.shopp.shoppingcart.service.SaleService;

@Controller
public class SaleController {
	
	@Autowired
	SaleService saleService;
	ProductDTO prodDto;
	
	@RequestMapping(value = "sales/{idSale}/products/{idProduct}/linesales/{quantity}", method = RequestMethod.GET)
    @ResponseBody
    public void addProduct(@PathVariable int idSale, @PathVariable int idProduct, @PathVariable int quantity){
		saleService.addProduct(idSale, idProduct, quantity);
	}
	
	@RequestMapping(value = "salesConfirm", method = RequestMethod.GET)
    @ResponseBody
    public List<SaleDTO> getSalesConfirm(){
	
		return saleService.getSalesConfirm();
}
	
	@RequestMapping(value="saleOk", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Void> saveSale(@PathVariable Sale sale){
		
		saleService.save(sale);
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	
	}
	
}

