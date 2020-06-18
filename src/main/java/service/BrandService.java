package service;

import repository.BrandDao;
import entity.Brand;

import java.util.List;

public class BrandService implements TableService<Brand> {
    private BrandDao dao = new BrandDao();

    @Override
    public Brand findById(int id) {
        return dao.findById(id);
    }

    public Brand findByName(String name) {
        return dao.findByName(name);
    }

    @Override
    public List<Brand> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(Brand obj) {
        dao.save(obj);
    }

    @Override
    public void delete(Brand obj) {
        dao.delete(obj);
    }

    @Override
    public void update(Brand obj) {
        dao.update(obj);
    }
}
