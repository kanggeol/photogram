package com.dailystudy.dtmsapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Image {
    private int id;
    private String caption; // 오늘 나 너무 피곤해!!
    private String postImageUrl; // 사진을 전송받아서 그 사진을 서버에 특정 폴더에 저장 - DB에 그 저장된 경로를 insert
    private User user;
    private List<Likes> likes;  // 이미지 좋아요
    private List<Comment> comments;  // 댓글
    private boolean likeState;
    private int likeCount;
    private LocalDateTime createDate;

    public void createDate() {
        this.createDate = LocalDateTime.now();
    }
}
