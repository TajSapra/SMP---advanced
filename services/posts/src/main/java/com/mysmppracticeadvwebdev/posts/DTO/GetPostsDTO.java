package com.mysmppracticeadvwebdev.posts.DTO;

import com.mysmppracticeadvwebdev.dto.GetUserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetPostsDTO {

    private String post_id;

    private Set<GetUserDTO> users;

    private String post_description;

    private List<String> resourceUrls;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
