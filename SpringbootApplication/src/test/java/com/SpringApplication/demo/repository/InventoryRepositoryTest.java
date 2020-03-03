package com.SpringApplication.demo.repository;
import com.SpringApplication.demo.model.Inventory;
import com.SpringApplication.demo.repository.InventoryRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;

import javax.persistence.EntityManagerFactory;
import static org.mockito.Mockito.*;
@DataJpaTest
public class InventoryRepositoryTest
{
    @Autowired
    private InventoryRepository invRepo = mock(InventoryRepository.class);
    //Test Data
    private Inventory invTemp;
    @BeforeEach
    void testSetup()
    {
        invTemp = new Inventory(1, "Test1", "Test1", 10, 5f);
    }
    @Test
    void findByID_ReturnInventory()
    {
        invRepo.save(invTemp);
        assert(invTemp.getId().equals(1));
        Assertions.assertEquals(invRepo.findById(1).get(), invTemp);
    }
}

