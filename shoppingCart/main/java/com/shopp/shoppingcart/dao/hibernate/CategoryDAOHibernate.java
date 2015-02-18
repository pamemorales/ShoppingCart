package com.shopp.shoppingcart.dao.hibernate;

import com.shopp.shoppingcart.dao.CategoryDAO;
import com.shopp.shoppingcart.model.Category;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDAOHibernate implements CategoryDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public CategoryDAOHibernate(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Category findById(int idCategory) {
        Query q = sessionFactory.getCurrentSession().createQuery("SELECT c FROM Category c WHERE c.idCategory =: cat");
        q.setParameter("cat", idCategory);
        return (Category) q.uniqueResult();

    }

    @Override
    public List<Category> findAll() {
        Query q = sessionFactory.getCurrentSession().createQuery("SELECT c FROM Category c ");
        return q.list();

    }
}