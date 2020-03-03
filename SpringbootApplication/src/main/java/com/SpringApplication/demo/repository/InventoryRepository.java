package com.SpringApplication.demo.repository;

import com.SpringApplication.demo.model.Inventory;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer>{
}
