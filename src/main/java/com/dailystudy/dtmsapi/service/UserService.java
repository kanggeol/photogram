package com.dailystudy.dtmsapi.service;

import com.dailystudy.dtmsapi.domain.Profile;
import com.dailystudy.dtmsapi.domain.User;
import com.dailystudy.dtmsapi.exception.CustomValidationApiException;
import com.dailystudy.dtmsapi.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    Logger log = LoggerFactory.getLogger(UserService.class);

    @Transactional
    public User updateUser(int id, User user) {
        User userEntity = userMapper.selectUser(id)
                .orElseThrow(() -> {
                    return new CustomValidationApiException("찾을 수 없는 id입니다.");
                });

        userEntity.setName(user.getName());

        String rawPassword = user.getPassword();
        String encPassword = passwordEncoder.encode(rawPassword);

        userEntity.setPassword(encPassword);
        userEntity.setBio(user.getBio());
        userEntity.setWebsite(user.getWebsite());
        userEntity.setPhone(user.getPhone());
        userEntity.setGender(user.getGender());
//        log.info("userEntity: {}", userEntity);
        userMapper.updateUser(userEntity); //마이바티스는 객체의 상태 변화를 감지하여 자동으로 데이터베이스에 변경을 반영하는 더티체킹을 지원 X
        return userEntity;
    }


    public Profile profile(int pageUserId, int principalId) {
        User userEntity = userMapper.selectUser(pageUserId)
                .orElseThrow(() -> {
                    return new CustomValidationApiException("해당 프로필 페이지는 없는 페이지입니다.");
                });

        Profile dto = new Profile();
        dto.setUser(userEntity);
        dto.setPageOwnerState(pageUserId == principalId);

        return dto;
    }
}
