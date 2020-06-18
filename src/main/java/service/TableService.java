package service;

import java.util.List;

interface TableService<T> {
    public T findById(int id);

    public List<T> findAll();

    public void save(T obj);

    public void delete(T obj);

    public void update(T obj);
}
