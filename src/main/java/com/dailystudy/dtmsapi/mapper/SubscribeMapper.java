package com.dailystudy.dtmsapi.mapper;

import com.dailystudy.dtmsapi.domain.SubscribeResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubscribeMapper {
    void subscribe(int fromUserId, int toUserId); //성공하면 변경된 행의 개수가 리턴, -1(실패), 0(실패아닌 변경된 건이 없음)

    void unSubscribe(int fromUserId, int toUserId);

    int subscribeState(int principalId, int pageUserId);

    int subscribeCount(int pageUserId);

    List<SubscribeResponse> subscibeList(int principalId, int pageUserId);
}
