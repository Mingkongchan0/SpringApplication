package com.SpringApplication.demo;

import com.SpringApplication.demo.model.Inventory;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Setter
@Getter
public class InventoryReader {
    @PersistenceContext
    private EntityManager entityManager;

    public Inventory findInventory(Inventory invTemp){
        return entityManager.find(Inventory.class, invTemp);

    }
    public Inventory insertInventory()
    {
        return Inventory.builder().Album("a").Id(1).Quantity(2).Price(2f).build();
    }
}
