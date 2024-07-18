package com.example.mini_blog.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mini_blog.entity.PostEntity;
import com.example.mini_blog.repository.PostRepository;

@RestController
@CrossOrigin
public class PostController {
    @Autowired
    PostRepository postRepository;

    // 입력을 받기 위해서 PostMapping 사용
    // json 연습하기 위해서 RequestBody 사용
    // @PostMapping("/post-write")
    // public PostEntity postWrite(@RequestBody PostEntity post) {
    // PostEntity result = postRepository.save(post);
    // return result;
    // }
    @PostMapping("/post-write")
    public Map<String, Object> postWrite(@RequestBody PostEntity post) {
        PostEntity result = postRepository.save(post);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        // 보통 성공의 의미로 200 사용
        map.put("msg", "입력 완료");
        map.put("result", result);
        return map;
    }
}
