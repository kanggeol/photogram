package com.dailystudy.dtmsapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SubscribeResponse {
    //구독정보
    private int userId;
    private String username;
    private Integer subscribeState;
    private Integer equalUserState;

}
