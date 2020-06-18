package service;

import repository.UnitDao;
import entity.Unit;

import java.util.List;


public class UnitService implements TableService<Unit> {
    private UnitDao dao = new UnitDao();

    @Override
    public Unit findById(int id) {
        return dao.findById(id);
    }

    public Unit findByName(String name) {
        return dao.findByName(name);
    }

    @Override
    public List<Unit> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(Unit obj) {
        dao.save(obj);
    }

    @Override
    public void delete(Unit obj) {
        dao.delete(obj);
    }

    @Override
    public void update(Unit obj) {
        dao.update(obj);
    }
}
