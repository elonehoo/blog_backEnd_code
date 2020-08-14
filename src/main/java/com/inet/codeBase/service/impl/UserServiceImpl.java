package com.inet.codeBase.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.inet.codeBase.beans.User;
import com.inet.codeBase.mapper.UserMapper;
import com.inet.codeBase.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getOne(User user) {
        Map<String,Object> map = new HashMap<>();
        map.put("user_email",user.getUserEmail());
        map.put("user_password",user.getUserPassword());
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.allEq(map);
        User one = userMapper.selectOne(queryWrapper);
        return one;
    }

    @Override
    public User getById(String uuid) {
        User user = userMapper.selectById(uuid);
        return user;
    }

    @Override
    public int getUpdateById(User user) {
        int i = userMapper.updateById(user);
        return i;
    }
}
