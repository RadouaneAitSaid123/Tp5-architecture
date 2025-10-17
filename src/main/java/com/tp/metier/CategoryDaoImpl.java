package com.tp.metier;

import com.tp.dao.IDao;
import com.tp.entities.Category;
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
public class CategoryDaoImpl implements IDao<Category> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public boolean create(Category o) {
        Session session = sessionFactory.getCurrentSession();
        session.save(o);
        return true;
    }

    @Override
    public boolean delete(Category o) {
        sessionFactory.getCurrentSession().delete(o);
        return true;
    }

    @Override
    public boolean update(Category o) {
        sessionFactory.getCurrentSession().update(o);
        return true;
    }

    @Override
    public Category findById(int id) {
        return sessionFactory.getCurrentSession().get(Category.class, id);
    }

    @Override
    public List<Category> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Category", Category.class).list();
    }
}
