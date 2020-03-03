package com.SpringApplication.demo.model;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import javax.persistence.*;
import javax.persistence.Id;

@Data
@JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode @ToString @Builder
@Table (name = "tbl_Inventory")
@Entity
public class Inventory{
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY) private Integer Id;
    private String Artist;
    private String Album;
    private Integer Quantity;
    private Float Price;

}

