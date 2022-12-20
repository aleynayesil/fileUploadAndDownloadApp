package com.fileuploadanddownloadapp.controller;

import com.fileuploadanddownloadapp.domain.FileUpload;
import com.fileuploadanddownloadapp.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @GetMapping("/uploadFile")
    public ResponseEntity<List<FileUpload>> uploadFile(){
        return ResponseEntity.ok(fileUploadService.getUploadFile());
    }

    @PostMapping("/uploadFile")
    public ResponseEntity<FileUpload> uploadFile(@RequestParam("files")
                                                 @ModelAttribute("upload")
                                                 MultipartFile multipartFile) throws IOException {
        final FileUpload fileUpload = fileUploadService.uploadFile(multipartFile);

        return ResponseEntity.ok().body(fileUpload);
    }
}
