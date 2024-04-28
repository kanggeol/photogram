package com.dailystudy.dtmsapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Subscribe {
    private int id;
    private User fromUser; //구독하는 사람
    private User toUser;  //구독받는 사람
    private LocalDateTime createDate;
}
