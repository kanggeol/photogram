package com.dailystudy.dtmsapi.config.auth;

import com.dailystudy.dtmsapi.domain.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Data
public class PrincipalDetails implements UserDetails {

    private static final long serialVersionUID = -8966937564680898411L;

    private User user;

    public PrincipalDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { //권한은 1개가 아닐 수 있다. return user.getRole() X
        Collection<GrantedAuthority> collector = new ArrayList<>();
        String role = "ROLE_USER"; // 기본 역할은 ROLE_USER로 설정
        // 사용자의 userId가 "birth0114"인 경우 ROLE_ADMIN으로 설정
        if ("birth0114".equals(user.getUsername())) {
            role = "ROLE_ADMIN";
        }

        // 역할을 GrantedAuthority 객체로 변환하여 collector에 추가
        collector.add(new SimpleGrantedAuthority(role));
        return collector;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
//        return user.getExpired(); // TODO: 4/23/24 이런식으로 관리해줄 수 있다
        return true; //true 만기가 안된거, false 만기가 지난거.
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
