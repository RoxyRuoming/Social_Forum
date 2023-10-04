package com.rawcoder.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
public class AlphaConfig {
    @Bean // third party bean; bean name = method name
    public SimpleDateFormat simpleDateFormat() {
        return new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
    }
}
