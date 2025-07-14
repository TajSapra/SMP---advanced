package com.mysmppracticeadvwebdev.users.repository;

import com.mysmppracticeadvwebdev.users.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
}
