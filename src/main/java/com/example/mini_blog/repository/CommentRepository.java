package com.example.mini_blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mini_blog.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

}
