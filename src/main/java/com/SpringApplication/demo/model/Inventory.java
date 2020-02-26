package com.SpringApplication.demo.model;
import lombok.*;
import javax.persistence.*;

@Data
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode @ToString @Builder
@Table (name = "tbl_Inventory")
@Entity
public class Inventory{
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY) private Integer id;
    private String Artist;
    private String Album;
    private Integer Quantity;
    private Float Price;
}

