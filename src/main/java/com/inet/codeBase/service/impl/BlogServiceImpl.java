package com.inet.codeBase.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.inet.codeBase.beans.Blog;
import com.inet.codeBase.beans.ShowBlog;
import com.inet.codeBase.beans.Type;
import com.inet.codeBase.beans.User;
import com.inet.codeBase.mapper.BlogMapper;
import com.inet.codeBase.mapper.TypeMapper;
import com.inet.codeBase.service.BlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BlogServiceImpl implements BlogService {

    @Resource
    private BlogMapper blogMapper;

    @Resource
    private TypeMapper typeMapper;

    @Override
    public String insert(Blog blog) {
        int insert = blogMapper.insert(blog);
        if (insert != 1){
            return "插入失败";
        }else {
            return "插入成功";
        }
    }

    @Override
    public List<ShowBlog> pageByCondition(Boolean condition, int pageNum, int pageSize) {
        //创建判断条件
        Map<String,Object> map = new HashMap<>();
        map.put("blog_publish",condition);
        QueryWrapper<Blog> queryWrapper = new QueryWrapper<>();
        queryWrapper.allEq(map);
        //进行分类分页查询
        Page<Blog> page = blogMapper.selectPage(new Page<>(pageNum, pageSize), queryWrapper);
        List<Blog> records = page.getRecords();
        List<ShowBlog> lists = new ArrayList<>();
        for (int i =0 ; i < records.size() ; i++){
            ShowBlog showBlog = new ShowBlog();
            //设置序号
            showBlog.setId(records.get(i).getBlogId());
            //设置标题
            showBlog.setTitle(records.get(i).getBlogTitle());
            //设置描述
            showBlog.setDescribe(records.get(i).getBlogDescribe());
            //设置是否发布
            showBlog.setPublish(records.get(i).getBlogPublish());
            //设置type
            String typeId = records.get(i).getTypeId();
            Type type = typeMapper.selectById(typeId);
            showBlog.setTypeName(type.getTypeName());
            //设置total
            showBlog.setTotal((int)page.getTotal());
            lists.add(showBlog);
        }
        return lists;
    }

    @Override
    public List<ShowBlog> pageAll(int pageNum, int pageSize) {
        Page<Blog> page = blogMapper.selectPage(new Page<>(pageNum, pageSize), new QueryWrapper<Blog>());

        List<Blog> records = page.getRecords();
        List<ShowBlog> lists = new ArrayList<>();
        for (int i =0 ; i < records.size() ; i++){
            ShowBlog showBlog = new ShowBlog();
            //设置序号
            showBlog.setId(records.get(i).getBlogId());
            //设置标题
            showBlog.setTitle(records.get(i).getBlogTitle());
            //设置描述
            showBlog.setDescribe(records.get(i).getBlogDescribe());
            //设置是否发布
            showBlog.setPublish(records.get(i).getBlogPublish());
            //设置type
            String typeId = records.get(i).getTypeId();
            Type type = typeMapper.selectById(typeId);
            showBlog.setTypeName(type.getTypeName());
            //设置total
            showBlog.setTotal((int)page.getTotal());
            lists.add(showBlog);
        }
        return lists;
    }

    @Override
    public Blog selectById(String uuid) {
        Blog blog = blogMapper.selectById(uuid);
        return blog;
    }

    @Override
    public int updateUndercarriage(Blog blog) {
        int i = blogMapper.updateById(blog);
        return i;
    }

    @Override
    public int deleteById(String uuid) {
        int i = blogMapper.deleteById(uuid);
        return i;
    }

    @Override
    public int updateById(Blog blog) {
        int i = blogMapper.updateById(blog);
        return i;
    }

    @Override
    public IPage<Blog> selectByCondition(Page<Blog> blogPage, Map<String, Object> condition) {
        QueryWrapper<Blog> queryWrapper = new QueryWrapper<>();
        queryWrapper.allEq(condition);
        Page<Blog> page = blogMapper.selectPage(blogPage, queryWrapper);
        return page;
    }


}
