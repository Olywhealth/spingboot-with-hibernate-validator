package com.example.Api.services;

import com.example.Api.dtos.UserDto;
import com.example.Api.entities.User;
import com.example.Api.exception.CustomException;
import com.example.Api.repoository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public User registerUser(UserDto userDto){
        if (userRepository.findByEmail(userDto.getEmail()) != null) {
            throw new CustomException("User with "+userDto.getEmail()+ " already exist");
        }
        User newUser = new User();
        newUser.setName(userDto.getName());
        newUser.setEmail(userDto.getEmail());
        newUser.setPhoneNumber(userDto.getPhoneNumber());
        return userRepository.save(newUser);
    }
}
