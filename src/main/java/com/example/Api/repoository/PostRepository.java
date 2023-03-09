package com.example.Api.repoository;

import com.example.Api.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository  extends JpaRepository<Post, Long> {
}
