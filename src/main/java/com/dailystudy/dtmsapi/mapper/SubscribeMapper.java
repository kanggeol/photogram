package com.dailystudy.dtmsapi.mapper;

import com.dailystudy.dtmsapi.domain.Subscribe;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubscribeMapper {
    void subscribe(int fromUserId, int toUserId); //성공하면 변경된 행의 개수가 리턴, -1(실패), 0(실패아닌 변경된 건이 없음)

    void unSubscribe(int fromUserId, int toUserId);
}
