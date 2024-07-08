package com.soli.dev.post.web;

import com.soli.dev.common.dto.ResponseDto;
import com.soli.dev.post.dto.PostDto;
import com.soli.dev.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 게시판 Controller
 */
@RestController
@RequiredArgsConstructor
public class PostController {

    /**
     * 게시판 Service
     */
    private final PostService postService;


    /**
     * 게시판 현황 목록 조회
     * @return
     */
    @GetMapping(path = "/api/posts")
    public List<PostDto> list() {
        return postService.getPosts();
    }

    /**
     * 게시물 등록
     * @return
     */
    @PostMapping(path = "/api/post")
    public PostDto createPost(@RequestBody PostDto postDto) {
        return postService.createPost(postDto);
    }

    /**
     * 게시물 단건 조회
     * @return
     */
    @PostMapping(path = "/api/post/{id}")
    public PostDto getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    /**
     * 게시물 단건 수정
     * @return
     */
    @PutMapping(path = "/api/post/{id}")
    public PostDto updatePost(@PathVariable Long id,@RequestBody PostDto postDto) {
        return postService.updatePost(id,postDto);
    }

    /**
     * 게시물 단건 삭제
     * @return
     */
    @DeleteMapping(path = "/api/post/{id}")
    public ResponseDto deletePost(@PathVariable Long id, @RequestBody PostDto postDto) {
        return postService.deletePost(id,postDto);
    }

}
