package com.SpringApplication.demo;

import com.SpringApplication.demo.controller.InventoryController;
import com.SpringApplication.demo.model.Inventory;
import com.SpringApplication.demo.repository.InventoryRepository;
import com.SpringApplication.demo.service.InventoryService;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.json.JSONObject;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
@ExtendWith(SpringExtension.class)
public class InventoryControllerTest
{

    @InjectMocks
    private InventoryController invCon;

    @Mock
    private InventoryService invSvc;
    private InventoryRepository invRepo;

    //Test Data
    private Inventory invTemp;
    @BeforeEach
    void setupTest() throws Exception
    {
        invRepo = mock(InventoryRepository.class);
        invSvc = mock(InventoryService.class);
        invTemp = new Inventory();
        invTemp.setQuantity(5);
        invTemp.setPrice(5f);
        invTemp.setArtist("aoao");
        invTemp.setId(2);
    }
    @Test
    void getInventoryTest() throws Exception
    {
        EntityManager entityManager = mock(EntityManager.class);
        Mockito.when(entityManager.find(Inventory.class, invTemp)).thenReturn(invTemp);
        InventoryReader invRdr = new InventoryReader();
        invRdr.setEntityManager(entityManager);
        Inventory temp = invRdr.findInventory(invTemp);
        assert(temp.equals(invTemp));
    }
    @ParameterizedTest
    @MethodSource
    void setInventoryTest(JsonNode jsonNode)
    {
        Inventory temp = new Inventory();
        temp.setArtist(jsonNode.findValue("Artist").toString());

        temp.setAlbum(jsonNode.findValue("Album").toString());

        temp.setQuantity(jsonNode.findValue("Quantity").asInt());

        temp.setPrice(jsonNode.findValue("Price").floatValue());
        invSvc.Insert(temp);
        verify(invSvc).Insert(temp);

    }



    private static JsonNode setInventoryTest(){
        ObjectMapper mapper = new ObjectMapper();
        Inventory temp = new Inventory();
        temp.setAlbum("a");
        temp.setQuantity(5);
        temp.setPrice(4f);
        temp.setArtist("b");
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        List<Inventory> list = new ArrayList<>();
        list.add(temp);
        return mapper.convertValue(list, JsonNode.class);
    }
}
