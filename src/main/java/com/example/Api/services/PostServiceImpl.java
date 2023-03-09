package com.example.Api.services;

import com.example.Api.dtos.PostDto;
import com.example.Api.entities.Post;
import com.example.Api.entities.User;
import com.example.Api.exception.CustomException;
import com.example.Api.repoository.PostRepository;
import com.example.Api.repoository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
//@AllArgsConstructor
@Service
public class PostServiceImpl implements PostService{

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    @Override
    public Post createPost(PostDto postDto, String email) {
        User exisitingUser = userRepository.findByEmail(email);
        if (exisitingUser == null){
            throw new CustomException("User with the "+email+ " does not exist");
        }
        Post newPost = new Post();
        newPost.setName(postDto.getName());
        newPost.setTitle(postDto.getTitle());
        newPost.setDescription(postDto.getDescription());
        newPost.setUser(exisitingUser);
        return postRepository.save(newPost);

    }

    @Override
    public Void deletePost(Long id) {
        return null;
    }
}
