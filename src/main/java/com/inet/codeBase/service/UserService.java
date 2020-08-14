package com.inet.codeBase.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.inet.codeBase.beans.User;

public interface UserService  {
    /**
     * 通过user对象中已经被填充得数据
     * 进行查询
     * @param user
     * @return
     */
    User getOne(User user);

    /**
     * 通过主键查询用户对象
     * @param uuid
     * @return
     */
    User getById(String uuid);

    /**
     * 通过用户主键进行用户的信息修改
     * @param user
     */
    int getUpdateById(User user);
}
