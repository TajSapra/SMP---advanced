package com.mysmppracticeadvwebdev.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.Set;

@Entity
@Data
@Table(name="users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "name", nullable = false, unique = false)
    private String name;

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phone_number;

    @Column(name = "is_phone_verified", nullable = false, columnDefinition = "boolean default false")
    private Boolean is_phone_verified;

    @Column(name = "password", nullable = false, unique = false)
    private String password;

    @ManyToMany
    @JoinTable(
            name = "user_followers",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns =@JoinColumn(name = "follower_id")
    )
    private Set<UserEntity> followers;

    @ManyToMany(mappedBy = "followers")
    private Set<UserEntity> following;


    public String getPassword(){
        return password;
    }

    public String getEmail(){
        return email;
    }

    public String getId(){
        return id;
    }
}
