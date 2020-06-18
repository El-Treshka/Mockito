package repository;

import entity.Brand;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateSessionFactoryUtil;

import java.util.List;

public class BrandDao implements TableDao<Brand> {
    @Override
    public Brand findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Brand.class, id);
    }

    public Brand findByName(String name) {
        return (Brand) HibernateSessionFactoryUtil.getSessionFactory().openSession().
                createQuery("from Brand where name=:name").setParameter("name", name).uniqueResult();
    }

    @Override
    public void save(Brand obj) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(obj);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Brand obj) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(obj);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Brand obj) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(obj);
        tx1.commit();
        session.close();
    }

    @Override
    public List<Brand> findAll() {
        List<Brand> list = (List<Brand>) HibernateSessionFactoryUtil.getSessionFactory()
                .openSession().createQuery("From Brand").list();
        return list;
    }
}
