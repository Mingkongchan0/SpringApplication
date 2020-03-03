package com.SpringApplication.demo.repository;

import com.SpringApplication.demo.controller.InventoryController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

public class InventoryRepositoryTest
{
    @InjectMocks
    private InventoryRepository invRepo;

    @Test
    void testMarkerMethod()
    {

    }
    @Test
    public void testCount() {
        Assertions.assertNotNull(invRepo, "Data on demand for 'MyBean' failed to initialize correctly");
    }
}
