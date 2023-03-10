package com.onlineshop.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductInformation {
    private  String size ;
    private String fit ;
}
