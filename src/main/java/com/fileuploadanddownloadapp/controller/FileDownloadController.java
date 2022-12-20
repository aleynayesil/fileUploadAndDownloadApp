package com.fileuploadanddownloadapp.controller;

import com.fileuploadanddownloadapp.service.FileDownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

@RestController
public class FileDownloadController {

    @Autowired
    private FileDownloadService fileDownloadService;

    @GetMapping("/downloadFile/{fileName}")
    public ResponseEntity<Resource> downloadPDFSource(@ModelAttribute("download") @PathVariable final String fileName) throws FileNotFoundException, URISyntaxException {

        final InputStreamResource fileResource = fileDownloadService.downloadFile(fileName);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;fileName=\"" + fileName +"\"")
                .body(fileResource);
    }
}
