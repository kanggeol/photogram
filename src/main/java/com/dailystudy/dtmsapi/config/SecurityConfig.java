package com.dailystudy.dtmsapi.config;

import com.dailystudy.dtmsapi.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
//SpringSecurity 5.4 이하 일때 WebSecurityConfigurerAdapter, 5.5 이상일때는 SecurityFilterChain을 사용해야 함(람다식)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider jwtTokenProvider;

    //    MySQL의 password() 함수로 저장된 해시된 비밀번호를 사용하기 때문에 인코더 따로 사용X
// TODO: 4/23/24 임시로 테스트 해봄
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // csrf 사용 안함
                .authorizeRequests()
                .antMatchers("/", "/user/**", "/image/**", "/subscribe/**", "/comment/**", "/api/**").authenticated()
//                .anyRequest().hasAnyRole("ADMIN", "USER")
                .anyRequest().permitAll() // 모든 요청 허용
                .and()
                .formLogin()
                .loginPage("/auth/signin") //GET
                .loginProcessingUrl("/auth/signin") //POST -> 스프링 시큐리티가 로그인 프로세스 진행
                .defaultSuccessUrl("/");
        /*
                .and()
                .exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler())
                .and()
                .exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint())

                .and()
                .addFilterBefore(new JwtFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class); // ID, Password 검사 전에 jwt 필터 먼저 수
    */
    }
}
