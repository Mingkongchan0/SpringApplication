package com.SpringApplication.demo.service;
import lombok.NonNull;
import org.junit.jupiter.api.Assertions;
import com.SpringApplication.demo.model.Inventory;
import com.SpringApplication.demo.repository.InventoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AssertionsKt;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.mock;

public class InventoryServiceTest
{

    @InjectMocks
    private InventoryService invSvc;

    @Mock
    private InventoryRepository invRepo;
    @Autowired
    private MockMvc mockMvc;

    //Test Data
    @NonNull private Inventory invTemp;

    @BeforeEach
    public void TestSetup()
    {
       invRepo = mock(InventoryRepository.class);
        invTemp = new Inventory();
        invTemp.setId(16);
        invTemp.setArtist("MockTest1");
        invTemp.setQuantity(5);
        invTemp.setAlbum("MockTest1");
        invTemp.setPrice(10.15f);
    }

    @Test
    void InventorServiceRetrieveTest()
    {
        Mockito.when(invRepo.findById(16)).thenReturn(Optional.of(invTemp));
    }
    @Test
    void InventoryServiceRetrieveAllTest(){
        ArrayList<Inventory> list = new ArrayList<>();
        Mockito.when(invRepo.findAll()).thenReturn(list);
    }
    @Test
    void InventoryServiceInsertTest()
    {
        Inventory inv = new Inventory();
        Mockito.when(invRepo.save(invTemp)).thenReturn(inv);
    }
    @Test
    void InventoryServiceDeleteTest()
    {
        invRepo.deleteById(16);
        assert (invRepo.findById(16).isEmpty());
    }
}
