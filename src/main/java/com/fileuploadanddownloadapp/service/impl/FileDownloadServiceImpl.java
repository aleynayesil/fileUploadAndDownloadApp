package com.fileuploadanddownloadapp.service.impl;

import com.fileuploadanddownloadapp.service.FileDownloadService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;

@Service
public class FileDownloadServiceImpl implements FileDownloadService {

    public static final String DIRECTORY = System.getProperty("user.dir") +
            "/src/main/resources/static/fileUploads/";
    @Override
    public InputStreamResource downloadFile(String fileName) throws URISyntaxException, FileNotFoundException {

        final URL resource = getClass().getResource("/static/fileUploads/"+ fileName);
        final File file = new File(resource.toURI());

        final InputStreamResource fileResource  = new InputStreamResource(new FileInputStream(file));

        return fileResource;
    }
}
