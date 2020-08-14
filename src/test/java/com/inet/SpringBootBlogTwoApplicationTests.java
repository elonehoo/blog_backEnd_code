package com.inet;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.inet.codeBase.beans.*;
import com.inet.codeBase.mapper.MessageMapper;
import com.inet.codeBase.service.BlogService;
import com.inet.codeBase.service.MessageService;
import com.inet.codeBase.service.TypeService;
import com.inet.codeBase.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class SpringBootBlogTwoApplicationTests {

    @Resource
    private UserService userService;
    @Resource
    private TypeService typeService;
    @Resource
    private BlogService blogService;
    @Resource
    private MessageService messageService;
    @Test
    void contextLoads() {
        IPage<Message> pageing = messageService.pageing(1, 10);
        System.out.println(pageing.getRecords());
    }

}
