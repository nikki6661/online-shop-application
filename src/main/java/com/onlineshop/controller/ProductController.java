package com.onlineshop.controller;

import com.onlineshop.model.dto.request.ProductRequestEntityDto;
import com.onlineshop.model.dto.response.ProductResponseEntityDto;
import com.onlineshop.model.product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import com.onlineshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/products")
@Tag(name ="products-api")
public class ProductController {

    private final ProductService service ;
    private final ModelMapper modelMapper;


    @Autowired
    public ProductController(ProductService service,ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper= modelMapper ;
    }

    @PostMapping("/create")
    @Operation(description = "To create a product " , summary = "Create a product by sending POST request to /products/create endpoint with the product details in the request body")
    public ProductResponseEntityDto createProduct( @Valid @RequestBody ProductRequestEntityDto product) {
       product productEntity = modelMapper.map(product,product.class) ;
        product response = service.createProduct(productEntity) ;
        return modelMapper.map(response,ProductResponseEntityDto.class)  ;

    }
    @GetMapping("")
    @Operation(description = "To get list of available products " , summary = "Get list of products by sending GET request to /products endpoint")
    public List<ProductResponseEntityDto> getAllProducts() {
        List<product> response = service.findAll();
        return response.stream().map(product-> modelMapper.map(product,ProductResponseEntityDto.class)).collect(Collectors.toList()) ;
    }
    @PutMapping("/update/{ID}")
    @Operation(description ="To Update a product",summary ="Update a product by sending PUT request to /products/update/{id} endpoint with the product details in the request body")
    public ProductResponseEntityDto updateProduct(@RequestBody ProductRequestEntityDto product,@PathVariable String ID){
        product productEntity = modelMapper.map(product,product.class) ;
        product response = service.updateProduct(productEntity,ID) ;
        return modelMapper.map(response,ProductResponseEntityDto.class)  ;

    }
    @DeleteMapping("/delete/{ID}")

    @Operation(description = "To delete a product", summary = "Delete a product by sending DELETE request to /products/delete/{id} endpoint")
    public ResponseEntity<String> deleteProduct(@PathVariable String ID) {
        service.deleteProduct(ID);
        return  new ResponseEntity<>("Deleted Successfully",HttpStatus.NO_CONTENT);
    }
}
