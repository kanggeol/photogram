package com.dailystudy.dtmsapi.service;

import com.dailystudy.dtmsapi.exception.CustomApiException;
import com.dailystudy.dtmsapi.mapper.SubscribeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SubscribeService {
    private final SubscribeMapper subscribeMapper;

    @Transactional
    public void subscibe(int fromUserId, int toUserId) {
        try {
            subscribeMapper.subscribe(fromUserId, toUserId);
        } catch (Exception e) {
            throw new CustomApiException("이미 구독을 하였습니다.");
        }
    }

    @Transactional
    public void unSubscibe(int fromUserId, int toUserId) {
        subscribeMapper.unSubscribe(fromUserId, toUserId); //삭제는 오류날게 없어서 try/catch 적용X
    }
}
