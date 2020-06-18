package repository;

import entity.Unit;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateSessionFactoryUtil;

import java.util.List;

public class UnitDao implements TableDao<Unit> {
    @Override
    public Unit findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Unit.class, id);
    }

    public Unit findByName(String name) {
        return (Unit) HibernateSessionFactoryUtil.getSessionFactory().openSession().
                createQuery("from Unit where name=:name").setParameter("name", name).uniqueResult();
    }

    @Override
    public void save(Unit obj) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(obj);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Unit obj) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(obj);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Unit obj) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(obj);
        tx1.commit();
        session.close();
    }

    @Override
    public List<Unit> findAll() {
        List<Unit> list = (List<Unit>) HibernateSessionFactoryUtil.getSessionFactory()
                .openSession().createQuery("From Unit").list();
        return list;
    }
}
