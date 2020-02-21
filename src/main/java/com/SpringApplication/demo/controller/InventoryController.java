package com.SpringApplication.demo.controller;

import com.SpringApplication.demo.model.Inventory;
import com.SpringApplication.demo.service.InventoryService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
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
    public void setInventory(@Valid @NonNull JsonNode jsonnode )
    {
        Inventory temp = new Inventory();

        temp.setArtist(jsonnode.findValue("Artist").toString());

        temp.setAlbum(jsonnode.findValue("Album").toString());

        temp.setQuantity(jsonnode.findValue("Quantity").asInt());

        temp.setPrice(jsonnode.findValue("Price").floatValue());

        invSvc.Insert(temp);

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
    public void updateInventory(@Valid @RequestBody  @PathVariable Integer id, @NonNull @RequestBody @Valid JsonNode jsonnode)
    {
        Inventory index = invSvc.Retrieve(id);

        if ((jsonnode.findValue("Artist") != null)) {
            index.setArtist(jsonnode.findValue("Artist").toString());
        }

        if ((jsonnode.findValue("Album") != null)) {
            index.setAlbum(jsonnode.findValue("Album").toString());
        }

        if ((jsonnode.findValue("Quantity") != null)) {
            index.setQuantity(jsonnode.findValue("Quantity").asInt());
        }

        if ((jsonnode.findValue("Price") != null)) {
            index.setPrice(jsonnode.findValue("Price").floatValue());
        }
        invSvc.Insert(index);
    }

    @RequestMapping("/DelInventory/{id}")
    @ResponseBody
    public void delInventory(@Valid @RequestBody @PathVariable Integer id)
    {
        invSvc.Delete(id);
    }

}
