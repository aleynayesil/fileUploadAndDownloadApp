package com.fileuploadanddownloadapp.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "file_upload")
public class FileUpload extends AbstractIdEntity{

    @Column(nullable = false)
    private String fileName;

    @Column(nullable = false)
    private Long size;

    @Column(nullable = false)
    private String fileDownloadLink;

    @Column(nullable = false)
    private LocalDate creationDate;

}
