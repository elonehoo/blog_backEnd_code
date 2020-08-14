package com.inet.codeBase.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.inet.codeBase.beans.Message;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessageMapper extends BaseMapper<Message> {
}
