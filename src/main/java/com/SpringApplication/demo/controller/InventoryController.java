package com.SpringApplication.demo.controller;

import com.SpringApplication.demo.model.Inventory;
import com.SpringApplication.demo.service.InventoryService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.core.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
@Log4j2
@RestController
@AutoConfigurationPackage
//Controller
public class InventoryController
{
    @Autowired
    private InventoryService invSvc;
    
    @PostMapping("/SetInventory/")
    @ResponseBody
    public ResponseEntity<Inventory> setInventory(@RequestHeader(name = "userId", defaultValue="404") String userId, @Valid @NonNull @RequestBody Inventory invTemp)
    {
        invSvc.Insert(invTemp);
        log.debug("userId is: {}", userId);
        return ResponseEntity.ok(invTemp);
    }
    @GetMapping("/GetInventory/{id}")
    @ResponseBody
    public ResponseEntity<Inventory> getInventory(@RequestHeader(name = "userId", defaultValue="404") String userId, @NonNull @Valid @PathVariable Integer id)
    {
        log.debug("userId is: {}", userId);
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
    public ResponseEntity<Inventory> updateInventory(@RequestHeader(name = "userId", defaultValue="404") String userId, @Valid @PathVariable Integer id, @NonNull @RequestBody @Valid Inventory invTemp)
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
        log.debug("userId is: {}", userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/DelInventory/{id}")
    @ResponseBody
    public void delInventory(@RequestHeader(name = "userId", defaultValue="404") String userId, @Valid @RequestBody @PathVariable Integer id)
    {
        log.debug("userId is: {}", userId);
        invSvc.Delete(id);
    }

}
