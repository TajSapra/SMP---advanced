package com.mysmppracticeadvwebdev.users.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String email;

    private String name;

    private String phone_number;

    private Boolean is_phone_verified;

    private String password;
}
