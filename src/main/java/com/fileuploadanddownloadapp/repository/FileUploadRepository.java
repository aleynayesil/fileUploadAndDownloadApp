package com.fileuploadanddownloadapp.repository;

import com.fileuploadanddownloadapp.domain.FileUpload;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FileUploadRepository extends JpaRepository<FileUpload,UUID> {
}
