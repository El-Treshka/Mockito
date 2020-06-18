package repository;

import entity.Category;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateSessionFactoryUtil;

import java.util.List;

public class CategoryDao implements TableDao<Category> {
    @Override
    public Category findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Category.class, id);
    }

    public Category findByName(String name) {
        return (Category) HibernateSessionFactoryUtil.getSessionFactory().openSession().
                createQuery("from Category where name=:name").setParameter("name", name).uniqueResult();
    }

    @Override
    public void save(Category obj) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(obj);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Category obj) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(obj);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Category obj) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(obj);
        tx1.commit();
        session.close();
    }

    @Override
    public List<Category> findAll() {
        List<Category> list = (List<Category>) HibernateSessionFactoryUtil.getSessionFactory()
                .openSession().createQuery("From Category ").list();
        return list;
    }
}
