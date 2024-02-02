package com.moblog.dev.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.moblog.dev.Blog;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final ArrayList<Blog> blogs;

    public void addBlog(Blog blog) {
        blogs.add(blog);
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public Blog getBlog(int index) {
        return blogs.get(index);
    }
}