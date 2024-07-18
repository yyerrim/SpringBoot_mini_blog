package com.example.mini_blog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity(name = "comment")
@Data
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Transient // entity의 역할은 하지 않음(컬럼으로 만들어지지 않음)
    Long postId;

    String content;

    @JsonIgnore // 무한반복 끊어주기(완벽한 해결방법은 아님)
    @ManyToOne
    PostEntity post;
}
