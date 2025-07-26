package com.mysmppracticeadvwebdev.storage.service;

import com.mysmppracticeadvwebdev.entities.ResourceEntity;
import com.mysmppracticeadvwebdev.entities.UserEntity;
import com.mysmppracticeadvwebdev.storage.repository.ResourceRepository;
import com.mysmppracticeadvwebdev.storage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service
public class MyStorageService{

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private UserRepository userRepository;

    public ResourceEntity storeResource(MultipartFile file, String resourceType, String id){
        if(file.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Empty File");
        }
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String baseDir = new File("data").getAbsolutePath();
        String uploadDir = baseDir + File.separator + resourceType;

        File directory = new File(uploadDir);

        if(!directory.exists()){
            directory.mkdirs();
        }

        System.out.println(uploadDir + File.separator + fileName);
        File destinationFile = new File(uploadDir + File.separator + fileName);

        System.out.println(destinationFile);

        try{
            file.transferTo(destinationFile);

            ResourceEntity resource = new ResourceEntity();

            resource.setPath(destinationFile.getPath());
            resource.setType(Files.probeContentType(destinationFile.toPath()));

            Optional<UserEntity> foundUser = this.userRepository.findById(id);

            if(foundUser.isEmpty()){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Details not Found");
            }

            resource.setUploadedBy(foundUser.get());

            return this.resourceRepository.save(resource);
        }
        catch (IOException e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to upload files at this moment.");
        }
        catch (ResponseStatusException ex){
            ex.printStackTrace();
            throw ex;
        }

    }
}
