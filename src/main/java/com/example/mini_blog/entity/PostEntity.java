package com.example.mini_blog.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "post")
@Data
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;

    String desc;
    // description : DB는 DESC 명령어가 있어서 이렇게 작성하면 에러 발생
    // SpringBoot PDF 4.33 ===> application.properties에 추가
}
