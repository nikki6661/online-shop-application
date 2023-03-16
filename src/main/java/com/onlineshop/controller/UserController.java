package com.onlineshop.controller;

import com.onlineshop.model.Users;
import com.onlineshop.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
@Tag(name ="products-api")
public class UserController {

    private final UserService service ;
    private final ModelMapper modelMapper;


    @Autowired
    public UserController(UserService service,ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper= modelMapper ;
    }
    @GetMapping("")
    @Operation(description = "To get list of available users " , summary = "Get list of users by sending GET request to /users endpoint")
    public Users[] getAllUsers() {
        Users[] response = service.findAllUsers();
      return  response;
    }
}
