package com.microservice.cyz.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author 崔耀中
 * @since 2020-12-25
 */
@EnableWebSecurity
@Configuration
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    @Autowired
    public WebSecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    public static void main(String[] args) {
        // 计算 BCryptPasswordEncoder 密文
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("12345678"));
        System.out.println(bCryptPasswordEncoder.matches("12345678", "$2a$10$kY9C1iTGUVyok0pTNM/r.ekp5D0mSOeMAK19r79eNSGeT/Xs9u4BW"));

    }

//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                    //URL 以“/resources /”开头，等于“/signup”或等于“/about”，则任何用户都可以访问请求。
//                    .antMatchers("/resources/**", "/signup", "/about").permitAll()
//                    //任何以“/admin /”开头的 URL 都将限于角色为“ ROLE_ADMIN”的用户
//                    .antMatchers("/admin/**").hasRole("ADMIN")
//                    //任何以“/db /”开头的 URL 都要求用户同时具有“ ROLE_ADMIN”和“ ROLE_DBA”
//                    .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
//                    //尚未匹配的任何 URL 仅要求对用户进行身份验证
//                    .anyRequest().authenticated()
//                    .and()
//                .formLogin()
//                    //更新后的配置指定登录页面的位置
//                    .loginPage("/login")
//                    //允许向所有用户授予与基于表单的登录相关的所有 URL 的访问权限。
//                    .permitAll();
//    }


}
