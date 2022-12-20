package com.fileuploadanddownloadapp.service;

import com.fileuploadanddownloadapp.domain.FileUpload;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileUploadService {

    FileUpload uploadFile(MultipartFile multipartFile) throws IOException;

    List<FileUpload> getUploadFile();
}
