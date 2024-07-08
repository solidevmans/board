package com.soli.dev.post.repository;

import com.soli.dev.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 사업추진협의회 Repository 인터페이스
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByOrderByUpdatedAtDesc();
}
