package com.example.mini_blog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mini_blog.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
    Page<PostEntity> findByTitleContainingOrDescContaining(String s1, String s2, Pageable p);
}
