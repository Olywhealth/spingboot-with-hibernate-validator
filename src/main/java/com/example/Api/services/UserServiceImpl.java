package com.example.Api.services;

import com.example.Api.dtos.UserDto;
import com.example.Api.dtos.UsersDto;
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
    public User registerUser(UsersDto userDto){
        if (userRepository.findByEmail(userDto.email()) != null) {
            throw new CustomException("User with "+userDto.email() + " already exist");
        }
        User newUser = new User();
//        ModelMapper mapper = new ModelMapper();
//        newUser= mapper.map(userDto, User.class);
        newUser.setName(userDto.name());
        newUser.setEmail(userDto.email());
        newUser.setPhoneNumber(userDto.phoneNumber());
        return userRepository.save(newUser);
    }
}
