package com.dailystudy.dtmsapi.mapper;

import com.dailystudy.dtmsapi.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserMapper {
    int updateUser(User user);

    Optional<User> selectUser(int id);
}
