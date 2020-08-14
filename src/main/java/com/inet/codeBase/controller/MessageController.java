package com.inet.codeBase.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.inet.codeBase.beans.Message;
import com.inet.codeBase.service.MessageService;
import com.inet.codeBase.utils.RegesUtils;
import com.inet.codeBase.utils.Result;
import com.inet.codeBase.utils.UUIDUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Resource
    private MessageService messageService;

    /**
     * 发布一个留言
     * @param map
     * @return
     */
    @PostMapping("/insert")
    @CrossOrigin
    public Result getInsert(@RequestBody HashMap<String,Object> map){
        //获取留言id
        String nickname = (String) map.get("nickname");
        //获取email
        String email = (String) map.get("email");
        //判断邮箱是否正确
        boolean judge = RegesUtils.isEmail(email);
        if (judge == false){
            return new Result("邮箱错误","留言信息",104);
        }
        //获取留言内容
        String content = (String) map.get("content");
        //设置留言序号
        String id = UUIDUtils.getId();
        //设置留言时间
        Date creationTime = new Date();
        //设置实体类
        Message message = new Message();
        message.setMessageId(id);
        message.setMessageNickname(nickname);
        message.setMessageEmail(email);
        message.setMessageContent(content);
        message.setMessageCreateTime(creationTime);
        int script = messageService.getInsert(message);
        if (script != 1){
            return new Result("留言失败","留言信息",104);
        }
        return new Result("留言成功","留言信息",100);
    }

    /**
     * 分页查询留言
     * @param map
     * @return
     */
    @PostMapping("/page")
    @CrossOrigin
    public Result getPage(@RequestBody HashMap<String,Object> map){
        int pageNum = (int) map.get("pageNum");
        int pageSize = 10;
        IPage<Message> messageIPage = messageService.pageing(pageNum,pageSize);
        return new Result(messageIPage,"分页请求",100);
    }

    /**
     * 删除留言
     * @param map
     * @return
     */
    @PostMapping("/delete")
    @CrossOrigin
    public Result getDelete(@RequestBody HashMap<String,Object> map){
        String messageId = (String) map.get("messageId");
        int script = messageService.deletById(messageId);
        if (script != 1){
            return new Result("删除失败","删除请求",104);
        }
        return new Result("删除成功","删除请求",100);
    }

}
