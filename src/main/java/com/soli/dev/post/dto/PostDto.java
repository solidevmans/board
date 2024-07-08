package com.soli.dev.post.dto;

import com.soli.dev.common.dto.BaseDto;
import com.soli.dev.post.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 사업추진협의회 DTO
 */
@Getter
@Setter
public class PostDto extends BaseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    // 기본 생성자
    public PostDto() {
    }

    public PostDto(Post post){
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.author = post.getAuthor();
    }

}
