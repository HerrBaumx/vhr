package org.jxiao.vhrself;

import org.junit.jupiter.api.Test;
import org.jxiao.vhrself.mapper.HrMapper;
import org.jxiao.vhrself.service.HrSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class VhrselfApplicationTests extends WebSecurityConfigurerAdapter {

    @Autowired
    HrSerice hrSerice;


    @Bean
    PasswordEncoder passwordEncoder(){


        return new BCryptPasswordEncoder();
    }
    @Test
    void contextLoads() {


       System.out.println(new BCryptPasswordEncoder().encode("123"));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(hrSerice);
    }
}
