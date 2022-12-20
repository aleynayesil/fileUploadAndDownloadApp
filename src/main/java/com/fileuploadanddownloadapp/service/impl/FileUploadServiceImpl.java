package com.fileuploadanddownloadapp.service.impl;

import com.fileuploadanddownloadapp.domain.FileUpload;
import com.fileuploadanddownloadapp.repository.FileUploadRepository;
import com.fileuploadanddownloadapp.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

import static java.nio.file.Paths.get;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Autowired
    private FileUploadRepository fileUploadRepository;
    public static final String DIRECTORY = System.getProperty("user.dir") +
            "/src/main/resources/static/fileUploads/";

    @Override
    public FileUpload uploadFile(MultipartFile multipartFile) throws IOException {
        final FileUpload file = new FileUpload();

        String fileName = multipartFile.getOriginalFilename();
        Path filePath = get(DIRECTORY,fileName).toAbsolutePath().normalize();
        Files.copy(multipartFile.getInputStream(),filePath,REPLACE_EXISTING);
        long size = multipartFile.getSize();

        file.setFileName(fileName);
        file.setSize(size);
        file.setFileDownloadLink("/downloadFile/" + fileName);
        file.setCreationDate(LocalDate.now());

        fileUploadRepository.save(file);

        return file;
    }

    @Override
    public List<FileUpload> getUploadFile() {
        return fileUploadRepository.findAll();
    }
}
