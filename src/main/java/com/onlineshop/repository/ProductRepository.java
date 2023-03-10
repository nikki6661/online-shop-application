package com.onlineshop.repository;

import com.onlineshop.model.product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository  extends MongoRepository<product,String> {
    List<product> findAll();


}
