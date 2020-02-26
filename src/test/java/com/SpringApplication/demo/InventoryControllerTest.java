package com.SpringApplication.demo;

import com.SpringApplication.demo.controller.InventoryController;
import com.SpringApplication.demo.model.Inventory;
import com.SpringApplication.demo.repository.InventoryRepository;
import com.SpringApplication.demo.service.InventoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Profile("test")
public class InventoryControllerTest
{
    @InjectMocks
    private InventoryController invCon;

    @Mock
    private InventoryService invSvc;
    private InventoryRepository invRepo;

    //Test Data
    private Inventory invTemp;

    public InventoryControllerTest() {
    }

    @BeforeEach
    void setupTest() {
    }
    @Test
     void setInventoryTest()
    {

    }
}
