package com.example.mini_blog.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CommentController {
    @GetMapping("/comment/{commentId}")
    public void comment(@PathVariable Long commentId) {
    }

}
