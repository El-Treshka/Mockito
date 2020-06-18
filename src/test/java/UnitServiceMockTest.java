import entity.Unit;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.UnitDao;
import service.UnitService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

public class UnitServiceMockTest {
    @Mock
    UnitDao daoMock;

    @InjectMocks
    UnitService service;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindByName() {
        Unit unit = new Unit();
        when(daoMock.findByName(anyString())).thenReturn(unit);
        assertNotNull(service.findByName(anyString()));
        when(daoMock.findByName(anyString())).thenReturn(null);
        assertNull(service.findByName(anyString()));
    }

    @Test
    public void testFindById() {
        when(daoMock.findById(anyInt())).thenReturn(null);
        assertNull(service.findById(anyInt()));
        when(daoMock.findById(anyInt())).thenReturn(new Unit());
        assertNotNull(service.findById(anyInt()));
    }

    @Test
    public void testFindAll() {
        when(daoMock.findAll()).thenReturn(null);
        assertNull(service.findAll());
        List<Unit> list = new ArrayList<>();
        when(daoMock.findAll()).thenReturn(list);
        assertSame(service.findAll(), list);
        list.add(new Unit());
        assertNotNull(service.findAll());
    }

    @Test
    public void testSave() {
        doNothing().when(daoMock).save(any(Unit.class));
        Unit unit = any(Unit.class);
        service.save(unit);
        verify(daoMock, times(1)).save(unit);
    }

    @Test
    public void testDelete() {
        doNothing().when(daoMock).delete(any(Unit.class));
        Unit unit = any(Unit.class);
        service.delete(unit);
        verify(daoMock, times(1)).delete(unit);
    }

    @Test
    public void testUpdate() {
        doNothing().when(daoMock).update(any(Unit.class));
        Unit unit = any(Unit.class);
        service.update(unit);
        verify(daoMock, times(1)).update(unit);
    }

}
