package service;

import repository.ProductDao;
import entity.Brand;
import entity.Category;
import entity.Product;

import java.util.List;

public class ProductService implements TableService<Product> {

    private ProductDao dao = new ProductDao();

    public boolean isUniq(Product product){
        return dao.findByArgs(product.getBrand(),product.getName(),product.getCategory(),
                product.getUnit(),product.getValue()).isEmpty();
    }

    public List<Product> findByCategory(Category category){
        return dao.findByCategory(category);
    }

    public List<Product> findByName(String name){
        return dao.findByName(name);
    }

    public List<Product> findByBrand(Brand brand){
        return dao.findByBrand(brand);
    }

    @Override
    public Product findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(Product obj) {
        dao.save(obj);
    }

    @Override
    public void delete(Product obj) {
        dao.delete(obj);
    }

    @Override
    public void update(Product obj) {
        dao.update(obj);
    }

}
