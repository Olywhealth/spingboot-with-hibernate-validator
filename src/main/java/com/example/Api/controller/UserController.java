package com.example.Api.controller;

import com.example.Api.dtos.ApiResponse;
import com.example.Api.dtos.UserDto;
import com.example.Api.entities.User;
import com.example.Api.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/user/v1/api")
public class UserController {

    private final UserService userService;


    @PostMapping("/createUser")
    public ResponseEntity<ApiResponse<?>> createUser(@Valid @RequestBody UserDto userDto){
        try {
            User newUser = userService.registerUser(userDto);
            return new ResponseEntity<>(new ApiResponse<>( "User successfully created", newUser), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(new ApiResponse<>(e.getMessage(), null), HttpStatus.BAD_REQUEST);
        }

    }
}
