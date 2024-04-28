package com.dailystudy.dtmsapi.mapper;

import com.dailystudy.dtmsapi.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
    int userUpdate(User user);

    //Optional은 주로 단일 객체나 null일 수 있는 객체를 감싸는 데 사용
    //단일 객체가 아니면 sevice단에서 orElseThrow 쓰지 못하고, try/catch 사용, 타입은 List<User>
    Optional<User> selectUser(int id);

    Optional<User> selectProfile(int id); // 1:N 의 테이블 결과값을 얻으려면 ResultMap Collection 사용
}
