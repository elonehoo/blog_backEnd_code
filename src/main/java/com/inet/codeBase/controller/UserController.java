package com.inet.codeBase.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.inet.codeBase.beans.ShowUser;
import com.inet.codeBase.beans.User;
import com.inet.codeBase.service.UserService;
import com.inet.codeBase.utils.Result;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 用户的Service
     */
    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate redisTemplate;



    /**
     * 登录功能
     * @param map
     * @return
     */
    @PostMapping("/register")
    @CrossOrigin
    public Result getRegister(@RequestBody HashMap<String,Object> map){
        //获取前端传来得账号和密码数据
        String account = (String) map.get("account");
        String password = (String) map.get("password");
        //将两个数据封装到User对象中
        User admin = new User();
        admin.setUserEmail(account);
        admin.setUserPassword(password);
        //使用查询selectOne方法
        User user = userService.getOne(admin);
        //判断查询出来得user是否为空
        if (user == null){
            //是空
            // 则返回查询失败得结果
            return new Result("没有找到该用户","登录失败",104);
        }else {
            //不是空
            String token = UUID.randomUUID()+"";
            redisTemplate.opsForValue().set(token,user);
            return new Result(token,"登录成功",100);
        }
    }
    /**
     * 查询登录的用户的属性
     */
    @PostMapping("/logIn")
    @CrossOrigin
    public Result getLogIn(@RequestBody HashMap<String,Object> map){
        //获取前端的数据
        String token = (String) map.get("token");
        //判断token令牌是否为空
        token = token == null ? "" : token;
        //从NoSQL中取出数据
        User user = (User) redisTemplate.opsForValue().get(token);
        //判断数据是否为空
        if (user == null){
            return new Result(null,"获取登录用户信息失败",104);
        }
        //将数据的登录时间设置成为30分钟
        redisTemplate.expire(token,30L, TimeUnit.MINUTES);
        //返回登录的用户信息
        return new Result(user,"获取登录用户信息成功",100);

    }
    /**
     * 修改登录的用户的信息
     */
    @PostMapping("/alter")
    @CrossOrigin
    public Result getAlter(@RequestBody HashMap<String,Object> map){
        //获取前端的数据
        String token = (String) map.get("token");
        String uuid = (String) map.get("uuid");
        String nickname = (String) map.get("nickname");
        String name = (String) map.get("name");
        String email = (String) map.get("email");
        String password = (String) map.get("password");
        //创建时间，确定成为修改的时间
        Date date = new Date();
        //转换成为字符串类型
        String turnoverTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);
        //通过id查找修改的用户
        User user = userService.getById(uuid);
        user.setUserNickname(nickname);
        user.setUserName(name);
        user.setUserEmail(email);
        user.setUserPassword(password);
        user.setUserTurnoverTime(turnoverTime);
        //修改用户信息
        int byId = userService.getUpdateById(user);
        if (byId != 1){
            return new Result("修改失败","修改请求失败",104);
        }else {
            redisTemplate.opsForValue().set(token,user);
            redisTemplate.expire(token,30L, TimeUnit.MINUTES);
            return new Result(user, "修改请求成功", 100);
        }
    }

    /**
     * 查看博客主人得信息
     * @param map
     * @return
     */
    @PostMapping("/session")
    @CrossOrigin
    public Result getSession(@RequestBody HashMap<String,Object> map){
        String uuid = "A1D5D2F3D79B4F7AABFDF86EA92BD588";
        User user = userService.getById(uuid);
        ShowUser showUser = new ShowUser();
        showUser.setNickname(user.getUserNickname());
        showUser.setHeadPortrait(user.getUserHeadPortrait());
        return new Result(showUser,"前端请求",100);
    }

    /**
     * 退出
     */
    @PostMapping("/quit")
    @CrossOrigin
    public Result getQuit(@RequestBody HashMap<String,Object> map) {
        String token = (String) map.get("token");
        redisTemplate.delete(token);
        return new Result(null, "退出请求", 100);
    }
}
