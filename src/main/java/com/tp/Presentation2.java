package com.tp;

import com.tp.dao.IDao;
import com.tp.entities.Category;
import com.tp.entities.Product;
import com.tp.util.HibernateConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author radouane
 **/
public class Presentation2 {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);


        IDao<Product> productDao = context.getBean("productDaoImpl", IDao.class);
        IDao<Category> categoryIDao = context.getBean("categoryDaoImpl", IDao.class);

        Category category = new Category("Cat01", "Categorie1");
        categoryIDao.create(category);
        System.out.println("Categorie sauvegardé : " + category.getLibelle());


        Product product = new Product();
        product.setName("Produit 2");
        product.setPrice(600.0);
        product.setCategory(categoryIDao.findById(1));
        productDao.create(product);
        System.out.println("Produit sauvegardé : " + product.getName());


        System.out.println("Categorie du produit " + product.getId() + " est : " + product.getCategory().getLibelle());


    }
}
