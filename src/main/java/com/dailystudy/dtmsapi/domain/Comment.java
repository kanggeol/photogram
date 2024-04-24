package com.dailystudy.dtmsapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comment {
    private int id;

    private String content;

    private User user;

    private Image image;

    private LocalDateTime createDate;

    public void createDate() {
        this.createDate = LocalDateTime.now();
    }
}
