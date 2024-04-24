package com.dailystudy.dtmsapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Likes {
    private int id;

    private Image image; // 1

    private User user; // 1

    private LocalDateTime createDate;

    public void createDate() {
        this.createDate = LocalDateTime.now();
    }
}
