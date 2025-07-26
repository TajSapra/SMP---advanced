package com.mysmppracticeadvwebdev.posts.repository;

import com.mysmppracticeadvwebdev.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, String> {
}
