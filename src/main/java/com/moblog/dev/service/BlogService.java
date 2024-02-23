package com.moblog.dev.service;

import java.util.List;

import com.moblog.dev.model.Blog;

public interface BlogService {
    public void addBlog(Blog blog);// create or add blog

    List<Blog> getBlogs();// retrive the data from the database

    Blog getBlog(int id);// for explore page

    void deleteBlog(int id);// for delete blog

    void updateBlog(Blog blog);// update blog info
}

// import java.util.*;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.jdbc.core.BeanPropertyRowMapper;
// import org.springframework.jdbc.core.JdbcTemplate;
// import org.springframework.jdbc.core.RowMapper;
// import org.springframework.stereotype.Service;

// import com.moblog.dev.model.Blog;

// import lombok.RequiredArgsConstructor;

// @Service
// @RequiredArgsConstructor
// public class BlogService {
// private final JdbcTemplate jdbcTemplate;

// @Value("${prefix}")
// private String prefix;

// @Value("#{${num1}+${num2}}")
// private int result;

// public void addBlog(Blog blog) {
// var heading = prefix + " " + blog.getHeading();
// String sql = "INSERT INTO blog (heading,description) VALUES (?,?)";

// jdbcTemplate.update(sql, heading, blog.getDescription());
// }

// public List<Blog> getBlogs() {
// String sql = "SELECT * from blog";
// RowMapper<Blog> rowMapper = (resultSet, rowNum) -> new Blog(
// resultSet.getInt("id"),
// resultSet.getString("heading"),
// resultSet.getString("description"));
// return jdbcTemplate.query(sql, rowMapper);
// // return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Blog>());
// }

// public Blog getBlog(int id) {
// String sql = "SELECT id,heading,description FROM blog WHERE id=?";
// RowMapper<Blog> rowMapper = (resultSet, rowNum) -> new Blog(
// resultSet.getInt("id"),
// resultSet.getString("heading"),
// resultSet.getString("description"));

// System.out.println(result);
// return jdbcTemplate.queryForObject(sql, rowMapper, id);
// // return jdbcTemplate.queryForObject(sql, Blog.class, id);
// }

// public void deleteBlog(int id) {
// String sql = "DELETE FROM blog WHERE ID=?";
// jdbcTemplate.update(sql, id);
// }
// }