package com.SpringApplication.demo;
/*
import com.SpringApplication.demo.model.Inventory;
import com.SpringApplication.demo.repository.InventoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;

import static org.mockito.Mockito.verify;
@DataJpaTest
@Profile("Test")
@EnableAutoConfiguration
public class InventoryRepositoryTest
{
    @Mock
    private InventoryRepository invRepo;
    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setup()
    {
        //Data
        Inventory invTemp = Inventory.builder().Album("a").id(1).Price(1f).Quantity(1).build();
        testEntityManager.persist(invTemp);
    }
    @Test
    void findByID_ReturnInventory()
    {
        Inventory invTemp = invRepo.findById(1).get();
        assert(invTemp.getId().equals(1));
        verify(invRepo).findById(1);
    }
    @Test
    public void testCount() {
        Assertions.assertNotNull(invRepo, "Data on demand for 'MyBean' failed to initialize correctly");
    }
}*/

