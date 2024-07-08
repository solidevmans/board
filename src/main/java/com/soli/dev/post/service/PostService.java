package com.soli.dev.post.service;

import com.soli.dev.common.dto.ResponseDto;
import com.soli.dev.post.dto.PostDto;
import com.soli.dev.post.entity.Post;
import com.soli.dev.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public List<PostDto> getPosts() {
        return postRepository.findAllByOrderByUpdatedAtDesc().stream().map(PostDto::new).toList();
    }

    @Transactional
    public PostDto createPost(PostDto postDto) {
        Post post = new Post(postDto);
        postRepository.save(post);
        return new PostDto(post);
    }

    @Transactional
    public PostDto getPost(Long id) {
        return postRepository.findById(id).map(PostDto::new)
                .orElseThrow(() -> new IllegalArgumentException("아이디가 존재하지 않습니다."));
    }

    @Transactional
    public PostDto updatePost(Long id, PostDto postDto) {
        Post post = postRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );

        post.update(postDto);
        return new PostDto(post);
    }

    @Transactional
    public ResponseDto deletePost(Long id, PostDto postDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );

        postRepository.deleteById(id);
        return new ResponseDto(true);
    }
}
