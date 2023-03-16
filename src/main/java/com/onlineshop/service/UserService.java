package com.onlineshop.service;

import com.onlineshop.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;


@Transactional
@Service
public class UserService {

@Autowired
private WebClient.Builder webClientBuilder ;

    public Users[] findAllUsers(){
     return webClientBuilder.build().get()
              .uri("https://jsonplaceholder.typicode.com/users").retrieve()
              .bodyToMono(Users[].class).block();
    }



    }


