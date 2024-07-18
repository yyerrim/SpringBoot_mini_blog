package com.example.mini_blog.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mini_blog.entity.CommentEntity;
import com.example.mini_blog.entity.PostEntity;
import com.example.mini_blog.repository.CommentRepository;

@RestController
@CrossOrigin
public class CommentController {
    @Autowired
    CommentRepository commentRepository;

    @PostMapping("/comment-write")
    public Map<String, Object> commentWrite(@RequestBody CommentEntity comment) {
        PostEntity post = new PostEntity();
        post.setId(comment.getPostId());
        comment.setPost(post);
        CommentEntity result = commentRepository.save(comment);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "입력 완료");
        map.put("result", result);
        return map;
    }

}
