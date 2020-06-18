import entity.Brand;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.BrandDao;
import service.BrandService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

public class BrandServiceMockTest {
    @Mock
    BrandDao daoMock;

    @InjectMocks
    BrandService service;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindByName() {
        Brand brand = new Brand();
        when(daoMock.findByName(anyString())).thenReturn(brand);
        assertNotNull(service.findByName(anyString()));
        when(daoMock.findByName(anyString())).thenReturn(null);
        assertNull(service.findByName(anyString()));
    }

    @Test
    public void testFindById() {
        when(daoMock.findById(anyInt())).thenReturn(null);
        assertNull(service.findById(anyInt()));
        when(daoMock.findById(anyInt())).thenReturn(new Brand());
        assertNotNull(service.findById(anyInt()));
    }

    @Test
    public void testFindAll() {
        when(daoMock.findAll()).thenReturn(null);
        assertNull(service.findAll());
        List<Brand> list = new ArrayList<>();
        when(daoMock.findAll()).thenReturn(list);
        assertSame(service.findAll(), list);
        list.add(new Brand());
        assertNotNull(service.findAll());
    }

    @Test
    public void testSave() {
        doNothing().when(daoMock).save(any(Brand.class));
        Brand brand = any(Brand.class);
        service.save(brand);
        verify(daoMock, times(1)).save(brand);
    }

    @Test
    public void testDelete() {
        doNothing().when(daoMock).delete(any(Brand.class));
        Brand brand = any(Brand.class);
        service.delete(brand);
        verify(daoMock, times(1)).delete(brand);
    }

    @Test
    public void testUpdate() {
        doNothing().when(daoMock).update(any(Brand.class));
        Brand brand = any(Brand.class);
        service.update(brand);
        verify(daoMock, times(1)).update(brand);
    }

}
