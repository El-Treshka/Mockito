package repository;

import entity.Brand;
import entity.Category;
import entity.Product;
import entity.Unit;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateSessionFactoryUtil;

import java.util.List;

public class ProductDao implements TableDao<Product> {
    @Override
    public Product findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Product.class, id);
    }

    @Override
    public void save(Product obj) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(obj);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Product obj) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(obj);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Product obj) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(obj);
        tx1.commit();
        session.close();
    }

    @Override
    public List<Product> findAll() {
        List<Product> list = (List<Product>) HibernateSessionFactoryUtil.getSessionFactory()
                .openSession().createQuery("From Product ORDER BY id").list();
        return list;
    }

    public List<Product> findByName(String name) {
        List<Product> list = (List<Product>) HibernateSessionFactoryUtil.getSessionFactory().openSession().
                createQuery("from Product where name=:name").setParameter("name", name).list();
        return list;
    }

    public List<Product> findByCategory(Category category) {
        List<Product> list = (List<Product>) HibernateSessionFactoryUtil.getSessionFactory().openSession().
                createQuery("from Product where category=:category").setParameter("category", category).list();
        return list;
    }

    public List<Product> findByBrand(Brand brand) {
        List<Product> list = (List<Product>) HibernateSessionFactoryUtil.getSessionFactory().openSession().
                createQuery("from Product where brand=:brand").setParameter("brand", brand).list();
        return list;
    }

    public List<Product> findByArgs(Brand brand, String name, Category category, Unit unit, Float value) {
        List<Product> list = (List<Product>) HibernateSessionFactoryUtil.getSessionFactory().openSession().
                createQuery("from Product where brand=:brand and name=:name and category=:category and unit=:unit and value=:value ")
                .setParameter("brand", brand).setParameter("name", name).setParameter("category", category)
                .setParameter("unit", unit).setParameter("value", value).list();
        return list;
    }


}
