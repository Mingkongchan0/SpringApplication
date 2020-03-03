package com.SpringApplication.demo.service;

import com.SpringApplication.demo.model.Inventory;
import com.SpringApplication.demo.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class InventoryService
{
    @Autowired
    private InventoryRepository invRepo;

    public void Insert(Inventory inv)
    {
        invRepo.save(inv);
    }
    public Inventory Retrieve(Integer id)
    {
        return invRepo.findById(id).get();
    }
    public List<Inventory> RetrieveAll()
    {
        return invRepo.findAll();
    }
    public void Delete(Integer id)
    {
        invRepo.deleteById(id);
    }
}
