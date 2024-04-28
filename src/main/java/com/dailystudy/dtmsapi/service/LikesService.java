package com.dailystudy.dtmsapi.service;

import com.dailystudy.dtmsapi.mapper.LikesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class LikesService {
    private final LikesMapper likesMapper;

    @Transactional
    public void like(int imageId, int principalId) {
        likesMapper.like(imageId, principalId);
    }

    @Transactional
    public void unlike(int imageId, int principalId) {
        likesMapper.unlike(imageId, principalId);
    }
}
