
import org.junit.Before;
import org.mockito.*;
import repository.ProductDao;
import entity.Brand;
import entity.Category;
import entity.Product;
import entity.Unit;
import org.junit.Test;
import service.ProductService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

public class ProductServiceMockTest {
    @Mock
    ProductDao daoMock;

    @InjectMocks
    ProductService service;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testIsUniq() {
        Brand brand = new Brand("Coca-Cola");
        brand.setId(1);
        String name = "Cola";
        Category category = new Category("Water");
        category.setId(2);
        Unit unit = new Unit("L");
        unit.setId(1);
        float value = 1.0f;
        Product product = new Product(brand, name, value, unit, category);
        product.setId(2);
        List<Product> list = new ArrayList<>();
        when(daoMock.findByArgs(brand, name, category, unit, value)).thenReturn(list);
        assertTrue(service.isUniq(product));
        list.add(product);
        assertFalse(service.isUniq(product));
    }

    @Test
    public void testFindByCategory() {
        when(daoMock.findByCategory(any(Category.class))).thenReturn(null);
        assertNull(service.findByCategory(any(Category.class)));
        List<Product> list = new ArrayList<>();
        when(daoMock.findByCategory(any(Category.class))).thenReturn(list);
        assertSame(service.findByCategory(any(Category.class)), list);
        list.add(new Product());
        assertNotNull(service.findByCategory(any(Category.class)));
    }

    @Test
    public void testFindByBrand() {
        when(daoMock.findByBrand(any(Brand.class))).thenReturn(null);
        assertNull(service.findByBrand(any(Brand.class)));
        List<Product> list = new ArrayList<>();
        when(daoMock.findByBrand(any(Brand.class))).thenReturn(list);
        assertSame(service.findByBrand(any(Brand.class)), list);
        list.add(new Product());
        assertNotNull(service.findByBrand(any(Brand.class)));
    }

    @Test
    public void testFindByName() {
        when(daoMock.findByName(anyString())).thenReturn(null);
        assertNull(service.findByName(anyString()));
        List<Product> list = new ArrayList<>();
        when(daoMock.findByName(anyString())).thenReturn(list);
        assertSame(service.findByName(anyString()), list);
        list.add(new Product());
        assertNotNull(service.findByName(anyString()));
    }

    @Test
    public void testFindAll() {
        when(daoMock.findAll()).thenReturn(null);
        assertNull(service.findAll());
        List<Product> list = new ArrayList<>();
        when(daoMock.findAll()).thenReturn(list);
        assertSame(service.findAll(), list);
        list.add(new Product());
        assertNotNull(service.findAll());
    }

    @Test
    public void testFindById() {
        when(daoMock.findById(anyInt())).thenReturn(null);
        assertNull(service.findById(anyInt()));
        when(daoMock.findById(anyInt())).thenReturn(new Product());
        assertNotNull(service.findById(anyInt()));
    }

    @Test
    public void testSave() {
        doNothing().when(daoMock).save(any(Product.class));
        Product product = any(Product.class);
        service.save(product);
        verify(daoMock, times(1)).save(product);
    }

    @Test
    public void testDelete() {
        doNothing().when(daoMock).delete(any(Product.class));
        Product product = any(Product.class);
        service.delete(product);
        verify(daoMock, times(1)).delete(product);
    }

    @Test
    public void testUpdate() {
        doNothing().when(daoMock).update(any(Product.class));
        Product product = any(Product.class);
        service.update(product);
        verify(daoMock, times(1)).update(product);
    }

}
