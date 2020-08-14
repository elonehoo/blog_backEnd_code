package com.inet.codeBase.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.inet.codeBase.beans.Blog;
import com.inet.codeBase.beans.ShowBlog;

import java.util.List;
import java.util.Map;

public interface BlogService {
    /**
     * 将博客插入到数据库
     * @param blog
     * @return
     */
    String insert(Blog blog);

    /**
     * 带条件的分页查询
     * @param condition
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<ShowBlog> pageByCondition(Boolean condition, int pageNum, int pageSize);

    /**
     * 查询所有的博客
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<ShowBlog> pageAll(int pageNum, int pageSize);

    /**
     * 通过序号查询博客
     * @param uuid
     * @return
     */
    Blog selectById(String uuid);

    /**
     * 修改博客是否上架还是下架
     * @param blog
     * @return
     */
    int updateUndercarriage(Blog blog);

    /**
     * 删除该序号的博客
     * @param uuid
     * @return
     */
    int deleteById(String uuid);

    /**
     * 修改博客
     * @param blog
     * @return
     */
    int updateById(Blog blog);

    /**
     * 通过条件查询并且分页
     * @param condition
     * @return
     */
    IPage<Blog> selectByCondition(Page<Blog> blogPage, Map<String, Object> condition);

}
