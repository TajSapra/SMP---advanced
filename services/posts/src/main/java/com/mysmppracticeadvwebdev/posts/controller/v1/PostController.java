package com.mysmppracticeadvwebdev.posts.controller.v1;

import com.mysmppracticeadvwebdev.posts.DTO.CreatePostDTO;
import com.mysmppracticeadvwebdev.posts.DTO.GetPostsDTO;
import com.mysmppracticeadvwebdev.posts.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping(path = "")
    public Map<String, Object> getPosts(){
        Map<String, Object> response = new HashMap<>();
        response.put("records", this.postService.getPosts());
        return response;
    }

    @GetMapping(path = "/{id}")
    public GetPostsDTO getPost(@PathVariable String id){
        return this.postService.getPostById(id);
    }

    @PostMapping(path = "")
    public GetPostsDTO createPost(@RequestBody @Valid CreatePostDTO createPostDTO){
        return this.postService.createPost(createPostDTO);
    }
}
