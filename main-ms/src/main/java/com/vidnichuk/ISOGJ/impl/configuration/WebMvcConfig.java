package com.vidnichuk.ISOGJ.impl.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by vadim on 16.10.17.
 * configuration to project
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    /**
     *
     * @return
     * return byte encoder to class
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
