package com.dailystudy.dtmsapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comment {//N
    private int id;

    private String content;

    private User user;//1

    private Image image;//1

    private LocalDateTime createDate;

    private int imageId;
    private int userId;
}
