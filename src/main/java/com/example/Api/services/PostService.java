package com.example.Api.services;

import com.example.Api.dtos.PostDto;
import com.example.Api.entities.Post;

public interface PostService {
    Post createPost(PostDto postDto, String email);
    Void deletePost(Long id);
}
