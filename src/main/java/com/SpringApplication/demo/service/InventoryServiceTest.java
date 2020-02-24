package com.SpringApplication.demo.service;
import org.junit.jupiter.api.*;
import com.SpringApplication.demo.model.Inventory;
import com.SpringApplication.demo.repository.InventoryRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.*;

public class InventoryServiceTest{
    @InjectMocks
    private InventoryService invSvc;

    @Mock
    private InventoryRepository invRepo;

    //Test Data
    private Inventory invTemp;

    @BeforeEach
    public void TestSetup() {
        invRepo = mock(InventoryRepository.class);
        invTemp = new Inventory();
        invTemp.setArtist("MockTest1");
        invTemp.setQuantity(5);
        invTemp.setAlbum("MockTest1");
        invTemp.setPrice(10.15f);
    }

    @Test
    void InventoryServiceInsertTest()
    {
        Inventory temp = new Inventory();
        Mockito.when(invRepo.save(invTemp)).thenReturn(temp);
        Inventory actualTemp = invRepo.getOne(invTemp.getId());
        assert(actualTemp.getId().equals(temp.getId()));
    }

    @Test
    void InventorServiceRetrieveTest()
    {
        invRepo.save(invTemp);
        Mockito.when(invRepo.findById(16)).thenReturn(Optional.of(invTemp));
        Inventory actualInv = invRepo.getOne(invTemp.getId());
        assert (actualInv.equals(invRepo.getOne(invTemp.getId())));
    }

    @Test
    void InventoryServiceRetrieveAllTest() {
        List<Inventory> list = Collections.singletonList(invTemp);
        Mockito.when(invRepo.findAll()).thenReturn(list);
        List<Inventory> actualList = invRepo.findAll();
        assert(actualList.equals(list));
    }

    @Test
    void InventoryServiceDeleteTest() {
        Inventory temp = invTemp;
        invRepo.save(invTemp);
        Mockito.when(invRepo.findById(16)).thenReturn(Optional.of(temp));
        invRepo.deleteById(16);
        assert (invRepo.findById(16).isEmpty());
    }
}
