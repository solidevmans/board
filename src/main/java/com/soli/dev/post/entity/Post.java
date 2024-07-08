package com.soli.dev.post.entity;


import com.soli.dev.common.entity.BaseEntity;
import com.soli.dev.post.dto.PostDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 사업추진협의회 엔티티
 */
@Entity
@Getter
@Setter(AccessLevel.PROTECTED)
@NoArgsConstructor
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String author;

    public Post(PostDto postDto) {
        this.id = postDto.getId();
        this.title = postDto.getTitle();
        this.content = postDto.getContent();
        this.author = postDto.getAuthor();
    }

    public void update(PostDto postDto) {
//        this.id = postDto.getId();
        this.title = postDto.getTitle();
        this.content = postDto.getContent();
        this.author = postDto.getAuthor();
    }
}
