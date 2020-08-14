package com.inet.codeBase.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.inet.codeBase.beans.Message;
import com.inet.codeBase.mapper.MessageMapper;
import com.inet.codeBase.service.MessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MessageServiceImpl implements MessageService {
    @Resource
    private MessageMapper messageMapper;

    @Override
    public int getInsert(Message message) {
        int insert = messageMapper.insert(message);
        return insert;
    }

    @Override
    public IPage<Message> pageing(int pageNum, int pageSize) {
        Page<Message> messagePage = messageMapper.selectPage(new Page<>(pageNum, pageSize), null);
        return messagePage;
    }

    @Override
    public int deletById(String messageId) {
        int i = messageMapper.deleteById(messageId);
        return i;
    }
}
