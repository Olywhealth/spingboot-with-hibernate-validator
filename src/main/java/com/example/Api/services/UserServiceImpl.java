package com.example.Api.services;

import com.example.Api.dtos.UserDto;
import com.example.Api.entities.User;
import com.example.Api.exception.CustomException;
import com.example.Api.repoository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
        ModelMapper mapper = new ModelMapper();
        mapper.map(userDto, newUser);
        return userRepository.save(newUser);
    }
}
