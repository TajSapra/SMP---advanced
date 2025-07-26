package com.mysmppracticeadvwebdev.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mysmppracticeadvwebdev.entities.ResourceEntity;

@Repository
public interface ResourceRepository extends JpaRepository<ResourceEntity, String> {
}
