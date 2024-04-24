package com.dailystudy.dtmsapi.service;

import com.dailystudy.dtmsapi.domain.User;
import com.dailystudy.dtmsapi.mapper.AuthMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AuthService {

    Logger log = LoggerFactory.getLogger(AuthService.class);

    private final AuthMapper authMapper;
    private final PasswordEncoder passwordEncoder;

    @Transactional // Write 할 때는 트랜잭션을 걸어준다 insert,update,delete
    public int insertUser(User user) {
        String rawPassword = user.getPassword();
        String encPassword = passwordEncoder.encode(rawPassword);
        user.setPassword(encPassword);
        user.setRole("ROLE_USER"); // TODO: 4/23/24 관리자는 ROLE_ADMIN
        log.info(user.toString());
        return authMapper.insertUser(user);
    }

//    public User selectUser(String username) {
//        log.info(username);
//        return authMapper.selectUser(username);
//    }
}
