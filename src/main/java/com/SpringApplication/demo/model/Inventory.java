package com.SpringApplication.demo.model;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.web.servlet.MockMvc;

import javax.persistence.*;

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

