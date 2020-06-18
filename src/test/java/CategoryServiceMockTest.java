import entity.Category;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.CategoryDao;
import service.CategoryService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

public class CategoryServiceMockTest {
    @Mock
    CategoryDao daoMock;

    @InjectMocks
    CategoryService service;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindByName() {
        Category category = new Category();
        when(daoMock.findByName(anyString())).thenReturn(category);
        assertNotNull(service.findByName(anyString()));
        when(daoMock.findByName(anyString())).thenReturn(null);
        assertNull(service.findByName(anyString()));
    }

    @Test
    public void testFindById() {
        when(daoMock.findById(anyInt())).thenReturn(null);
        assertNull(service.findById(anyInt()));
        when(daoMock.findById(anyInt())).thenReturn(new Category());
        assertNotNull(service.findById(anyInt()));
    }

    @Test
    public void testFindAll() {
        when(daoMock.findAll()).thenReturn(null);
        assertNull(service.findAll());
        List<Category> list = new ArrayList<>();
        when(daoMock.findAll()).thenReturn(list);
        assertSame(service.findAll(), list);
        list.add(new Category());
        assertNotNull(service.findAll());
    }

    @Test
    public void testSave() {
        doNothing().when(daoMock).save(any(Category.class));
        Category category = any(Category.class);
        service.save(category);
        verify(daoMock, times(1)).save(category);
    }

    @Test
    public void testDelete() {
        doNothing().when(daoMock).delete(any(Category.class));
        Category category = any(Category.class);
        service.delete(category);
        verify(daoMock, times(1)).delete(category);
    }

    @Test
    public void testUpdate() {
        doNothing().when(daoMock).update(any(Category.class));
        Category category = any(Category.class);
        service.update(category);
        verify(daoMock, times(1)).update(category);
    }

}
