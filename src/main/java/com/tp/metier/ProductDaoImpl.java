package com.tp.metier;

import com.tp.dao.IDao;
import com.tp.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author radouane
 **/

@Repository
@Transactional
public class ProductDaoImpl implements IDao<Product> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public boolean create(Product o) {
        Session session = sessionFactory.getCurrentSession();
        session.save(o);
        return true;
    }

    @Override
    public boolean delete(Product o) {
        sessionFactory.getCurrentSession().delete(o);
        return true;
    }

    @Override
    public boolean update(Product o) {
        sessionFactory.getCurrentSession().update(o);
        return true;
    }

    @Override
    public Product findById(int id) {
        return sessionFactory.getCurrentSession().get(Product.class, id);
    }

    @Override
    public List<Product> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Product", Product.class).list();
    }
}
