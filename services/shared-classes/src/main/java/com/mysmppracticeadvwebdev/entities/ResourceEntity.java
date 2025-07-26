package com.mysmppracticeadvwebdev.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "resources")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResourceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String path;

    private String type;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity uploadedBy;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUploadedBy(UserEntity uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

}
