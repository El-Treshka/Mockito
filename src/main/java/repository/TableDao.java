package repository;

import java.util.List;

public interface TableDao<T> {
    public T findById(int id);

    public void save(T obj);

    public void update(T obj);

    public void delete(T obj);

    public List<T> findAll();
}
