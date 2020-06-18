package service;

import repository.CategoryDao;
import entity.Category;


import java.util.List;

public class CategoryService implements TableService<Category> {
    private CategoryDao dao = new CategoryDao();

    @Override
    public Category findById(int id) {
        return dao.findById(id);
    }

    public Category findByName(String name) {
        return dao.findByName(name);
    }

    @Override
    public List<Category> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(Category obj) {
        dao.save(obj);
    }

    @Override
    public void delete(Category obj) {
        dao.delete(obj);
    }

    @Override
    public void update(Category obj) {
        dao.update(obj);
    }
}
