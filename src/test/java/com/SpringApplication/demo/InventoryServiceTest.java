package com.SpringApplication.demo;
import com.SpringApplication.demo.service.InventoryService;
import org.junit.jupiter.api.*;
import com.SpringApplication.demo.model.Inventory;
import com.SpringApplication.demo.repository.InventoryRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Profile;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.*;

@Profile("test")
public class InventoryServiceTest{
    @InjectMocks
    private InventoryService invSvc;

    @Mock
    private InventoryRepository invRepo;

    //Test Data
    private Inventory invTemp;


    @BeforeEach
    public void TestSetup() {
        MockitoAnnotations.initMocks(this);
        invTemp = new Inventory();
        invTemp.setId(1);
        invTemp.setArtist("MockTest1");
        invTemp.setQuantity(5);
        invTemp.setAlbum("MockTest1");
        invTemp.setPrice(10.15f);
    }

    @Test
    void InventoryServiceInsertTest()
    {
        invRepo.save(invTemp);
        verify(invRepo).save(any(Inventory.class));
        System.out.print("Test Passed Successfully");
    }

    @Test
    void InventorServiceRetrieveTest()
    {
        invRepo.save(invTemp);
        Mockito.when(invRepo.findById(1)).thenReturn(Optional.of(invTemp));
        Inventory actualInv = invRepo.findById(1).get();
        assert (actualInv.equals(invRepo.findById(1).get()));
        verify(invRepo, times(2)).findById(1);
        System.out.print("Test Passed Successfully");
    }

    @Test
    void InventoryServiceRetrieveAllTest() {
        List<Inventory> list = Collections.singletonList(invTemp);
        Mockito.when(invRepo.findAll()).thenReturn(list);
        List<Inventory> actualList = invRepo.findAll();
        assert(actualList.equals(list));
        verify(invRepo).findAll();
        System.out.print("Test Passed Successfully");
    }

    @Test
    void InventoryServiceDeleteTest() {
        invRepo.save(invTemp);
        invRepo.deleteById(1);
        assert (invRepo.findById(1).isEmpty());
        verify(invRepo).deleteById(1);
    }
}
