package com.shopp.shoppingcart.dao.hibernate;

import com.shopp.shoppingcart.dao.ProductDAO;
import com.shopp.shoppingcart.model.Product;
import com.shopp.shoppingcart.model.ProductDTO;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOHibernate implements ProductDAO {

    private SessionFactory sessionFactory;
   

    @Autowired
    public ProductDAOHibernate(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Product> findByCategory(int idCategory) {

        Query q = sessionFactory.getCurrentSession().createQuery(
                "SELECT p FROM Product p WHERE p.category.idCategory =:idCategory");
        q.setParameter("idCategory", idCategory);
        return  q.list();
    }

    @Override
    public Product findByName(String name) {

        Query q = sessionFactory.getCurrentSession().createQuery("SELECT p FROM Product p WHERE p.name =:name");
        q.setParameter("name", name);
        Product product = (Product) q.uniqueResult();
        return product;

    }

    @Override
    public List<Product> getProducts() {

        Query q = sessionFactory.getCurrentSession().createQuery("SELECT p FROM Product p");
        return q.list();

    }

    @Override
    public Product loadOffer(int idProduct, double oPrice) {

        Query q = sessionFactory.getCurrentSession().createQuery("SELECT p FROM Product p WHERE p.idProduct =:id");
        q.setParameter("id", idProduct);
        Product product = (Product) q.uniqueResult();
        product.setOfferPrice(oPrice);
        return product;

    }

    @Override
    public List<Product> getOffers() {
    	
        Query q = sessionFactory.getCurrentSession().createQuery("SELECT p FROM Product p WHERE p.offerPrice > 0.0");
        List<Product> prods =  q.list();
        return prods;

    }

    @Override
    public Product findById(int idProduct) {
        Query q = sessionFactory.getCurrentSession().createQuery("SELECT p FROM Product p WHERE p.idProduct =:id");
        q.setParameter("id", idProduct);
        Product product = (Product) q.uniqueResult();
        return product;
    }
}
