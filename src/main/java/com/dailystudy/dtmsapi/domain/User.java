package com.dailystudy.dtmsapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // 이 필드는 JSON으로 출력할 때만 사용되고, JSON으로부터의 입력은 무시됨
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
    private List<Image> images; // 1:N 관계, xml은 resultMap-collection 작성.

}
