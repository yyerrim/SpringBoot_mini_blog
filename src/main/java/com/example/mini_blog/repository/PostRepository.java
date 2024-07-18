package com.example.mini_blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mini_blog.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

}
