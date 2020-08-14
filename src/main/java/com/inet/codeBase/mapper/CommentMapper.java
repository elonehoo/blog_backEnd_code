package com.inet.codeBase.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.inet.codeBase.beans.Comment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
}
