package com.dailystudy.dtmsapi.mapper;

import com.dailystudy.dtmsapi.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthMapper {
    int insertUser(User user);

    User selectUser(String username);

}
