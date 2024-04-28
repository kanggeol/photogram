package com.dailystudy.dtmsapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Image {
    private int id;
    private String caption;
    private String postImageUrl; // 사진을 전송받아서 그 사진을 서버에 특정 폴더에 저장 - DB에 그 저장된 경로를 insert
    private User user; //resultMap <association>
    private List<Likes> likes;  //resultMap <collection>
    private List<Comment> comments;
    private boolean likeState;
    private int likeCount;
    private LocalDateTime createDate;

}
