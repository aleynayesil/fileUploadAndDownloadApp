package com.fileuploadanddownloadapp.service;

import org.springframework.core.io.InputStreamResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

public interface FileDownloadService {
    InputStreamResource downloadFile(String fileName) throws URISyntaxException, FileNotFoundException;
}
