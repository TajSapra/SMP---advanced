package com.mysmppracticeadvwebdev.posts.DTO;

import com.mysmppracticeadvwebdev.dto.GetUserDTO;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@Builder
public class CreatePostDTO {
    private Set<String> userIds;

    private String post_description;

    private List<String> resourceUrls;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Set<String> getUserIds() {
        return userIds;
    }
}
