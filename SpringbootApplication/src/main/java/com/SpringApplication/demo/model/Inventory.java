package com.SpringApplication.demo.model;
import lombok.*;
import org.springframework.data.annotation.Id;
import javax.persistence.*;

@Data
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode @ToString
@Entity @Table (name = "tbl_Inventory")
public class Inventory{
    @javax.persistence.Id
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String Artist;
    private String Album;
    private Integer Quantity;
    private Float Price;
}

