package com.shopp.shoppingcart.dao.hibernate;

import com.shopp.shoppingcart.dao.SaleDAO;
import com.shopp.shoppingcart.model.Sale;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SaleDAOHibernate implements SaleDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public SaleDAOHibernate(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Sale getSale(int idSale) {
        Query q = sessionFactory.getCurrentSession().createQuery("SELECT s FROM Sale s WHERE s.idSale =:id");
        q.setParameter("id", idSale);
        Sale sale = (Sale) q.uniqueResult();
        return sale;
    }

    @Override
    public List<Sale> getSalesConfirm() {

        Query q = sessionFactory.getCurrentSession().createQuery("SELECT s FROM Sale s WHERE s.status=:status");
        q.setParameter("status", true);
        List<Sale> sales = (List<Sale>) q.list();
        return sales;

    }

    @Override
    public void loadSale(Sale sale) {
    	 sessionFactory.getCurrentSession().save(sale);

    }


}
