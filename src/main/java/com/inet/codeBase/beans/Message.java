package com.inet.codeBase.beans;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@TableName(value = "tbl_message")
public class Message implements Serializable {
    /**
     * 留言序号
     */
    @TableId(value = "message_id")
    private String messageId;
    /**
     * 留言昵称
     */
    @TableField(value = "message_nickname")
    private String messageNickname;
    /**
     * 留言邮箱
     */
    @TableField(value = "message_email")
    private String messageEmail;
    /**
     * 留言内容
     */
    @TableField(value = "message_content")
    private String messageContent;
    /**
     * 留言头像
     */
    @TableField(value = "message_headPortrait")
    private String messageHeadPortrait;
    /**
     * 留言时间
     */
    @TableField(value = "message_createTime")
    private Date messageCreateTime;
    /**
     * 留言父序号
     */
    @TableField(value = "message_parentID")
    private Date messageParentID;
    /**
     * 留言集
     */
    @TableField(exist = false)
    private List<Message> messages = new ArrayList<>();

    public Message() {
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessageNickname() {
        return messageNickname;
    }

    public void setMessageNickname(String messageNickname) {
        this.messageNickname = messageNickname;
    }

    public String getMessageEmail() {
        return messageEmail;
    }

    public void setMessageEmail(String messageEmail) {
        this.messageEmail = messageEmail;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getMessageHeadPortrait() {
        return messageHeadPortrait;
    }

    public void setMessageHeadPortrait(String messageHeadPortrait) {
        this.messageHeadPortrait = messageHeadPortrait;
    }

    public Date getMessageCreateTime() {
        return messageCreateTime;
    }

    public void setMessageCreateTime(Date messageCreateTime) {
        this.messageCreateTime = messageCreateTime;
    }

    public Date getMessageParentID() {
        return messageParentID;
    }

    public void setMessageParentID(Date messageParentID) {
        this.messageParentID = messageParentID;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId='" + messageId + '\'' +
                ", messageNickname='" + messageNickname + '\'' +
                ", messageEmail='" + messageEmail + '\'' +
                ", messageContent='" + messageContent + '\'' +
                ", messageHeadPortrait='" + messageHeadPortrait + '\'' +
                ", messageCreateTime=" + messageCreateTime +
                ", messageParentID=" + messageParentID +
                ", messages=" + messages +
                '}';
    }
}
