package com.lyq.mapper;

import com.lyq.model.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    void insertBlog(Blog blog);

    List<Blog> queryBlogIF(Map map);

    List<Blog> queryBlogChoose(Map map);

    void updateBlog(Map map);

    List<Blog> queryBlogForEach(Map map);
}
