package com.SpringApplication.demo.service;
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
public class InventoryServiceTest
{
    @InjectMocks
    private InventoryService invSvc;

    @Mock
    private InventoryRepository invRepo;

    //Test Data
    private Inventory invTemp;


    @BeforeEach
    public void TestSetup() {
        MockitoAnnotations.initMocks(this);
        invTemp = new Inventory(1, "MockTest1", "MockTest1", 5, 10f);
    }

    @Test
    void insertTest()
    {
        invRepo.save(invTemp);
        verify(invRepo).save(any(Inventory.class));
    }

    @Test
    void retrieveTest()
    {
        invRepo.save(invTemp);
        Mockito.when(invRepo.findById(1)).thenReturn(Optional.of(invTemp));
        Inventory actualInv = invRepo.findById(1).get();
        assert (actualInv.equals(invRepo.findById(1).get()));
        verify(invRepo, times(2)).findById(1);
    }

    @Test
    void retrieveAllTest() {
        List<Inventory> list = Collections.singletonList(invTemp);
        Mockito.when(invRepo.findAll()).thenReturn(list);
        List<Inventory> actualList = invRepo.findAll();
        assert(actualList.equals(list));
        verify(invRepo).findAll();
    }

    @Test
    void deleteTest() {
        invRepo.save(invTemp);
        invRepo.deleteById(1);
        assert (invRepo.findById(1).isEmpty());
        verify(invRepo).deleteById(1);
    }
}
