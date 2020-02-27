package com.SpringApplication.demo.controller;

import com.SpringApplication.demo.model.Inventory;
import com.SpringApplication.demo.service.InventoryService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@AutoConfigurationPackage
//Controller
public class InventoryController
{
    @Autowired
    private InventoryService invSvc;

    @PostMapping("/SetInventory/")
    @ResponseBody
    public ResponseEntity<Inventory> setInventory(@Valid @NonNull @RequestBody Inventory invTemp)
    {
        invSvc.Insert(invTemp);
        return ResponseEntity.ok(invTemp);
    }
    @GetMapping("/GetInventory/{id}")
    @ResponseBody
    public ResponseEntity<Inventory> getInventory(@NonNull @Valid @PathVariable Integer id)
    {
        return ResponseEntity.ok(invSvc.Retrieve(id));
    }
    @GetMapping("GetInventory/all")
    @ResponseBody
    public ResponseEntity <List<Inventory>> getAllInventory()
    {
        return ResponseEntity.ok(invSvc.RetrieveAll());
    }

    @PutMapping("/UpdateInventory/{id}")
    @ResponseBody
    public ResponseEntity<Inventory> updateInventory(@Valid @PathVariable Integer id, @NonNull @RequestBody @Valid Inventory invTemp)
    {
        Inventory index = invSvc.Retrieve(id);

        if ((invTemp.getArtist() != null)) {
            index.setArtist(invTemp.getArtist());
        }

        if ((invTemp.getAlbum() != null)) {
            index.setAlbum(invTemp.getAlbum());
        }

        if ((invTemp.getQuantity() != null)) {
            index.setQuantity(invTemp.getQuantity());
        }

        if ((invTemp.getPrice() != null)) {
            index.setPrice(invTemp.getPrice());
        }
        invSvc.Insert(index);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/DelInventory/{id}")
    @ResponseBody
    public void delInventory(@Valid @RequestBody @PathVariable Integer id)
    {
        invSvc.Delete(id);
    }

}
