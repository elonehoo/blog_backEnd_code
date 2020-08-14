package com.inet.codeBase.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.inet.codeBase.beans.Message;

public interface MessageService {
    /**
     * 发布留言
     * @param message
     * @return
     */
    int getInsert(Message message);

    /**
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    IPage<Message> pageing(int pageNum, int pageSize);

    /**
     * 通过序号删除留言
     * @param messageId
     * @return
     */
    int deletById(String messageId);
}
