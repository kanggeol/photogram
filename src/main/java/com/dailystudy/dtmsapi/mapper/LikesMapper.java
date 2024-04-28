package com.dailystudy.dtmsapi.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LikesMapper {
    void like(int imageId, int principalId);

    void unlike(int imageId, int principalId);
}
