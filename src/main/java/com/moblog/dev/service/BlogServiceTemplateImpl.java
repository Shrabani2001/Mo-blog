package com.moblog.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.moblog.dev.model.Blog;

import lombok.RequiredArgsConstructor;

@Service
@Primary
@RequiredArgsConstructor
public class BlogServiceTemplateImpl implements BlogService {

    private final JdbcTemplate jdbcTemplate;

    @Value("${prefix}") // SpEL :Spring Expression Language
    private String prefix;

    @Override
    public void addBlog(Blog blog) {
        var heading = prefix + " " + blog.getHeading();
        String sql = "INSERT INTO blog (heading,description) VALUES (?,?)";
        jdbcTemplate.update(sql, heading, blog.getDescription());

    }

    @Override
    public List<Blog> getBlogs() {
        String sql = "SELECT * FROM blog";
        RowMapper<Blog> rowMapper = (resultSet, rowNum) -> new Blog(
                resultSet.getInt("id"),
                resultSet.getString("heading"),
                resultSet.getString("description"));

        return jdbcTemplate.query(sql, rowMapper);
        // return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Blog>());

    }

    @Override
    public Blog getBlog(int id) {
        String sql = "SELECT id,heading,description FROM blog WHERE id = ?";
        RowMapper<Blog> rowMapper = (resultSet, rowNum) -> new Blog(
                resultSet.getInt("id"),
                resultSet.getString("heading"),
                resultSet.getString("description"));

        return jdbcTemplate.queryForObject(sql, rowMapper, id);

    }

    @Override
    public void deleteBlog(int id) {
        String sql = "DELETE FROM blog WHERE id= ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void updateBlog(Blog blog) {
        var id = blog.getId();
        var heading = blog.getHeading();
        var description = blog.getDescription();

        var sql = "UPDATE blog SET heading = ? , description =?  WHERE id = ?";
        jdbcTemplate.update(sql, heading, description, id);

    }

}
