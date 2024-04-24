package com.dailystudy.dtmsapi.config.auth;

import com.dailystudy.dtmsapi.domain.User;
import com.dailystudy.dtmsapi.mapper.AuthMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class PrincipalDetailsService implements UserDetailsService {
    private final AuthMapper authMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //사용자 정보 가져오는 로직
        log.info("사용자 로드 시도: {}", username);

        User user = authMapper.selectUser(username);
//        log.info(user.toString());
        if (user == null) {
            return null;
        } else {
            return new PrincipalDetails(user);
        }
    }

}
