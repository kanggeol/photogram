package com.dailystudy.dtmsapi.service;

import com.dailystudy.dtmsapi.domain.SubscribeResponse;
import com.dailystudy.dtmsapi.exception.CustomApiException;
import com.dailystudy.dtmsapi.mapper.SubscribeMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SubscribeService {
    private final SubscribeMapper subscribeMapper;
    Logger log = LoggerFactory.getLogger(SubscribeService.class);

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

    public List<SubscribeResponse> subscibeList(int principalId, int pageUserId) {
        return subscribeMapper.subscibeList(principalId, pageUserId);
    }
}
