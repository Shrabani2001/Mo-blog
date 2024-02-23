package com.moblog.dev.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.moblog.dev.model.Blog;

@Configuration
public class BlogConfig {
    @Bean
    ArrayList<Blog> arrayList() {
        return new ArrayList<>();
    }
}