package com.shopp.shoppingcart.dao.hibernate;

import com.shopp.shoppingcart.dao.UserDAO;
import com.shopp.shoppingcart.model.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOHibernate implements UserDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public UserDAOHibernate(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User findUser(int id) {

        Query q = sessionFactory.getCurrentSession().createQuery("SELECT u FROM User u WHERE id =: idUser");
        q.setParameter("idUser", id);
        User user = (User) q.uniqueResult();
        return user;

    }

}
