package com.dailystudy.dtmsapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Profile {
    private boolean pageOwnerState;
    private int imageCount;
    private boolean subscribeState;
    private int subscribeCount;
    private User user;
}
