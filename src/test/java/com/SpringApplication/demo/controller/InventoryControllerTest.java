package com.SpringApplication.demo.controller;

import com.SpringApplication.demo.controller.InventoryController;
import com.SpringApplication.demo.model.Inventory;
import com.SpringApplication.demo.repository.InventoryRepository;
import com.SpringApplication.demo.service.InventoryService;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jdk.jfr.ContentType;
import lombok.Data;
import lombok.NonNull;
import org.json.JSONObject;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.persistence.EntityManager;
import javax.print.attribute.standard.Media;
import javax.validation.Valid;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
@Profile("test")
public class InventoryControllerTest
{
    @InjectMocks
    private InventoryController invCon;

    @Mock
    private InventoryService invSvc;

    //Test Data
    Inventory temp = new Inventory();
    Inventory temp2 = new Inventory();

    @BeforeEach
    void setupTest()
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        temp = new Inventory(1, "a", "a", 5, 5f);
        temp2 = new Inventory(2, "b", "b", 5, 10f);
    }

    @Test
    void setInventoryTest()
    {
        invSvc.Insert(temp);
        ResponseEntity<Inventory> responseEntity = invCon.setInventory(temp);
        Assertions.assertEquals(responseEntity.getStatusCodeValue(), 200);
    }

    @Test
    void getInventoryTest()
    {
        invSvc.Retrieve(temp.getId());
        ResponseEntity<Inventory> responseEntity = invCon.getInventory(temp.getId());
        Assertions.assertEquals(responseEntity.getStatusCodeValue(), 200);
    }

    @Test
    void getInventoryAllTest()
    {
        List<Inventory> list = Arrays.asList(temp, temp2);
        Mockito.when(invSvc.RetrieveAll()).thenReturn(list);
        ResponseEntity<List<Inventory>> responseEntity = invCon.getAllInventory();
        Assertions.assertEquals(invSvc.RetrieveAll().size(), 2);
        Assertions.assertEquals(invSvc.RetrieveAll().get(0).getAlbum(), "a");
        Assertions.assertEquals(invSvc.RetrieveAll().get(1).getAlbum(), "b");
        Assertions.assertEquals(responseEntity.getStatusCodeValue(), 200);
    }

    @Test
    void updateInventoryTest()
    {
        when(invSvc.Retrieve(temp.getId())).thenReturn(temp);
        Inventory index = invSvc.Retrieve(temp.getId());
        index.setArtist(temp2.getArtist());
        invSvc.Insert(index);
        ResponseEntity<Inventory> responseEntity2 = invCon.updateInventory(1, temp2);
        Assertions.assertEquals(responseEntity2.getStatusCodeValue(), 200);
    }
}
