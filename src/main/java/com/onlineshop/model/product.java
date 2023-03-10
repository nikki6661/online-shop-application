package com.onlineshop.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class product {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private String id;
    @Column(name="name" ,nullable = false)
    private String name ;
    @Column(name="description" )
    private String description ;
    @Column(name="price",nullable = false )
    private Long price ;
    @Column(name="productInformation")
    private List<ProductInformation> productInformation;
    @Column(name="availabilityStock")
    private Integer availabilityStock ;
    @Column(name="deliveryTime")
    private Integer deliveryTime ;
    @Column(name="categoryid")
    private Integer categoryid;
    @Column(name="enabled")
    private Boolean enabled ;


}
