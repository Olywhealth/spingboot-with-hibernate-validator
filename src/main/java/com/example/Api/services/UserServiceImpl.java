package com.example.Api.services;

import com.cloudinary.Cloudinary;
import com.example.Api.dtos.UsersDto;
import com.example.Api.entities.User;
import com.example.Api.exception.CustomException;
import com.example.Api.repoository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Map;
import static com.example.Api.constant.CloudinaryConstant.PUBLIC_ID;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final Cloudinary cloudinary;
    private final UserRepository userRepository;

    @Override
    public User registerUser(UsersDto userDto, MultipartFile file)throws IOException {
        if (userRepository.findByEmail(userDto.email()) != null) {
            throw new CustomException("User with "+userDto.email() + " already exist");
        }
        String picUrl = cloudinary.uploader().upload(file.getBytes(), Map.of("public_id", PUBLIC_ID))
                .get("url").toString();
        User newUser = new User();
        newUser.setName(userDto.name());
        newUser.setEmail(userDto.email());
        newUser.setPhoneNumber(userDto.phoneNumber());
        newUser.setProfilePic(picUrl);
        return userRepository.save(newUser);
    }
}
