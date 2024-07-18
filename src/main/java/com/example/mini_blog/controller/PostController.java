package com.example.mini_blog.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

    // PostMapping 써도 되지만 보통 조회할때는 GetMapping 사용
    @GetMapping("/post-list")
    public Map<String, Object> postList(
            @RequestParam(defaultValue = "1") int page) {
        Pageable pageable = PageRequest.of(page - 1, 10);
        Page<PostEntity> p = postRepository.findAll(pageable);
        long totalCount = p.getTotalElements();
        int totalPage = p.getTotalPages();

        int startPage = (page - 1) / 10 * 10 + 1;
        int endPage = startPage + 9;
        endPage = totalPage < endPage ? totalPage : endPage;

        List<PostEntity> list = p.getContent();

        Map<String, Object> map = new HashMap<>();
        map.put("totalCount", totalCount);
        map.put("totalPage", totalPage);
        map.put("startPage", startPage);
        map.put("endPage", endPage);
        map.put("list", list);
        return map;
    }

    @GetMapping("/post/{postId}")
    public PostEntity post(@PathVariable Long postId) {
        Optional<PostEntity> opt = postRepository.findById(postId);
        PostEntity post = opt.get();
        return post;
    }

}
