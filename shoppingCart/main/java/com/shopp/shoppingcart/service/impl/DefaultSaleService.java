package com.shopp.shoppingcart.service.impl;

import com.shopp.shoppingcart.dao.ProductDAO;
import com.shopp.shoppingcart.dao.SaleDAO;
import com.shopp.shoppingcart.dao.UserDAO;
import com.shopp.shoppingcart.model.LineSale;
import com.shopp.shoppingcart.model.Pay;
import com.shopp.shoppingcart.model.Product;
import com.shopp.shoppingcart.model.Sale;
import com.shopp.shoppingcart.model.SaleDTO;
import com.shopp.shoppingcart.model.User;
import com.shopp.shoppingcart.service.SaleService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class DefaultSaleService implements SaleService {

    @Autowired
    private SaleDAO saleDao;
    SaleDTO saleDto;
    private Set<LineSale> line;
    @Autowired
    private UserDAO personDao;
    private boolean confirm;
    @Autowired
    private ProductDAO productDao;
    private Pay pay;

    @Override
    public void initLineSale() {
        this.line = new HashSet<LineSale>();
        this.confirm = false; // esta activa la venta
    }

    public List<SaleDTO> getSalesConfirm(){
    	
    	List<SaleDTO> salesDto = new ArrayList<SaleDTO>();
    	for(Sale sale : (saleDao.getSalesConfirm())){
    		saleDto = new SaleDTO(sale);
    		salesDto.add(saleDto);
    	}
    	return  salesDto;
    	
    }
    
    @Override
    public void addProduct(int idSale, int idProduct, int quantity) {
        
    	if (line == null) {
            initLineSale();
        }
        if (!confirm) {
            Sale sale = saleDao.getSale(idSale);
            Product product = productDao.findById(idProduct);
            if (product != null) {
                line.add(new LineSale(sale, product, quantity));
            }
        }
    }

    @Override
    public void removeProduct(int idSale, int idProduct) {
        if (!confirm) {
            if (line != null) {
                int index = 0;
                for (LineSale lineSale : line) {
                    if (lineSale.getProduct().getIdProduct() == idProduct) {
                        line.remove(index);
                        break; // salir del bucle
                    }
                    index++;
                }
            }
        }

    }

    @Override
    public void save(Sale sale) {
        this.confirm = true;
        saleDao.loadSale(sale);

    }

    public void dropSale() {
        if (line == null) {
            initLineSale();
        } else {
            line.clear();
            confirm = false;
        }
    }
    
    
    public Sale generateSale(User user, Pay pay) {
        Sale saleNow = null;
        double higher = 0;
        double lower = 0;
        double subTotal = 0.0;
        double total=0.0;
        boolean first = false;
        if (!confirm && user != null) {
            for (LineSale lineSale : line) {
                subTotal = subTotal + lineSale.getTotalLineSale();
            }
            switch (pay.getTypePay()) {
            case Cash:
                for (LineSale lineSale : line) {
                    lower = lineSale.getProduct().getPrice();
                    if (higher < lower)
                        higher = lower;
                }
                total = subTotal - (higher * 0.9); // obtengo el 90% del valor del mas caro y se lo resto al total
                break;
            case CreditCard:
                total = subTotal - (subTotal * 0.1);
                break;
            case Paypal:
                for (LineSale lineSale : line) {
                    if (first) {
                        higher = lineSale.getProduct().getPrice();
                        if (lower > higher) {
                            lower = higher;
                        } else {
                            lower = lineSale.getProduct().getPrice();
                            first = true;
                        }

                    }
                    total = subTotal - lower;
                    break;
                }
                saleNow = new Sale(user, pay, line, total);
                saleNow.setStatus(true);

            }

        }
        return saleNow;
    }

}
