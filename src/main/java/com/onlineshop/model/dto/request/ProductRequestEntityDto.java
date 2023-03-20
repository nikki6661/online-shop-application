package com.onlineshop.model.dto.request;

import com.onlineshop.model.ProductInformation;
import com.onlineshop.model.ProductInformationDto;
import com.onlineshop.model.product;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ProductRequestEntityDto implements Serializable {

    @NotNull(message = "Name is Mandatory")
    private String name ;
    private String description ;
    @NotNull(message = "Price is Mandatory")
    private Long price ;
    private List<ProductInformationDto> productInformation;
    private Integer availabilityStock;
    private Integer deliveryTime ;
    private Integer categoryid;
    private Boolean enabled ;

}
