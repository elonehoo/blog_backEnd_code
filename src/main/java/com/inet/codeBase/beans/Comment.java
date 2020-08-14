package com.inet.codeBase.beans;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@TableName(value = "tbl_comment")
public class Comment implements Serializable {
    /**
     * 评论序号
     */
    @TableId(value = "comment_id")
    private String commentId;
    /**
     * 评论昵称
     */
    @TableField(value = "comment_nickname")
    private String commentNickname;
    /**
     * 评论邮箱
     */
    @TableField(value = "comment_email")
    private String commentEmail;
    /**
     * 评论头像
     */
    @TableField(value = "comment_headPortrait")
    private String commentHeadPortrait;
    /**
     * 评论内容
     */
    @TableField(value = "comment_content")
    private String commentContent;
    /**
     * 评论时间
     */
    @TableField(value = "comment_creationTime")
    private Date commentCreationTime;
    /**
     * 博客序号
     */
    @TableField(value = "blog_id")
    private String blogId;
    /**
     * 父评论序号
     */
    @TableField(value = "parent_comment_id")
    private String parentCommentId;
    /**
     * 评论集合
     */
    @TableField(exist = false)
    private List<Comment> comments = new ArrayList<>();

    public Comment() {
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getCommentNickname() {
        return commentNickname;
    }

    public void setCommentNickname(String commentNickname) {
        this.commentNickname = commentNickname;
    }

    public String getCommentEmail() {
        return commentEmail;
    }

    public void setCommentEmail(String commentEmail) {
        this.commentEmail = commentEmail;
    }

    public String getCommentHeadPortrait() {
        return commentHeadPortrait;
    }

    public void setCommentHeadPortrait(String commentHeadPortrait) {
        this.commentHeadPortrait = commentHeadPortrait;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getCommentCreationTime() {
        return commentCreationTime;
    }

    public void setCommentCreationTime(Date commentCreationTime) {
        this.commentCreationTime = commentCreationTime;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public String getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(String parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId='" + commentId + '\'' +
                ", commentNickname='" + commentNickname + '\'' +
                ", commentEmail='" + commentEmail + '\'' +
                ", commentHeadPortrait='" + commentHeadPortrait + '\'' +
                ", commentContent='" + commentContent + '\'' +
                ", commentCreationTime=" + commentCreationTime +
                ", blogId='" + blogId + '\'' +
                ", parentCommentId='" + parentCommentId + '\'' +
                ", comments=" + comments +
                '}';
    }
}
