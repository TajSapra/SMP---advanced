package com.mysmppracticeadvwebdev.storage.controller.v1;

import com.mysmppracticeadvwebdev.annotations.RequireAuth;
import com.mysmppracticeadvwebdev.entities.ResourceEntity;
import com.mysmppracticeadvwebdev.storage.service.MyStorageService;
import com.mysmppracticeadvwebdev.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/storage")
public class StorageController {

    @Autowired
    private MyStorageService myStorageService;

    @Autowired
    private JwtUtil jwtUtil;

    @RequireAuth
    @PostMapping
    public ResourceEntity handleFileUpload(
            @RequestParam("file") MultipartFile file,
            @RequestParam("resourceType") String resourceType,
            @RequestHeader("Authorization") String authToken
    ){
        String jwt = authToken.split("Bearer ")[1];
        Map<String, String> userDetails = jwtUtil.validateTokenAndRetrieveDetails(jwt);
        String id = userDetails.get("user_id");
        return this.myStorageService.storeResource(file, resourceType, id);
    }
}
