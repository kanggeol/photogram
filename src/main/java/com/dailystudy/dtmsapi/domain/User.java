package com.dailystudy.dtmsapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Size(min = 4, max = 20)
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String email;
    @NotBlank
    private String name;
    private String role;
    private int id;
    private String bio;
    private LocalDateTime createDate;
    private String gender;
    private String phone;
    private String profileImageUrl;
    private String website;
    private List<Image> images;

    public void createDate() {
        this.createDate = LocalDateTime.now();
    }
}
