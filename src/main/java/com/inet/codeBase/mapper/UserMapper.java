package com.inet.codeBase.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.inet.codeBase.beans.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
