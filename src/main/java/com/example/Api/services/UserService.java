package com.example.Api.services;

import com.example.Api.dtos.UserDto;
import com.example.Api.entities.User;

public interface UserService {
    User registerUser(UserDto userDto);
}
