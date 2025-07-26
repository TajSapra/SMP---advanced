package com.mysmppracticeadvwebdev.posts.service;

import com.mysmppracticeadvwebdev.entities.PostEntity;
import com.mysmppracticeadvwebdev.entities.UserEntity;
import com.mysmppracticeadvwebdev.posts.DTO.CreatePostDTO;
import com.mysmppracticeadvwebdev.posts.DTO.GetPostsDTO;
import com.mysmppracticeadvwebdev.posts.repository.PostRepository;
import com.mysmppracticeadvwebdev.posts.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;


    public List<GetPostsDTO> getPosts() {
        return this.postRepository.findAll().stream().map(postEntity -> this.modelMapper.map(postEntity, GetPostsDTO.class)).collect(Collectors.toList());
    }

    public GetPostsDTO createPost(CreatePostDTO postDTO) {
        PostEntity postEntity = modelMapper.map(postDTO, PostEntity.class);
        Set<UserEntity> users = postDTO.getUserIds().stream()
                .map(id -> userRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("User not found: " + id)))
                .collect(Collectors.toSet());
        postEntity.setUsers(users);
        return modelMapper.map(postRepository.save(postEntity), GetPostsDTO.class);
    }

    public GetPostsDTO getPostById(String id){
        Optional<PostEntity> foundPost = this.postRepository.findById(id);
        System.out.println(foundPost);
        if(foundPost.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post Not Found");
        }
        return modelMapper.map(foundPost.get(), GetPostsDTO.class);
    }

}
