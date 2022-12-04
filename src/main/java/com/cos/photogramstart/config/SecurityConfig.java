package com.cos.photogramstart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/", "/user/**", "/image/**", "/subscribe/**", "/comment/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/auth/signin") //antMatchers에 포함된 주소로 접속하면 인증필요 -> /auth/signin 페이지 연결됨, get방식으로.
                .loginProcessingUrl("/auth/signin") //auth/signin 페이지를 통해 로그인 시도되면 스프링 시큐리티가 로그인 프로세스 진행, post방식으로.
                .defaultSuccessUrl("/");
    }
}