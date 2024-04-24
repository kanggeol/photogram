package com.dailystudy.dtmsapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ImageUpload {
    private MultipartFile file;
    private String caption;
}
