package com.inet.codeBase.beans;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@TableName(value = "tbl_blog")
public class Blog implements Serializable {
    /**
     * 序号
     */
    @TableId(value = "blog_id")
    private String blogId;
    /**
     * 标题
     */
    @TableField(value = "blog_title")
    private String blogTitle;
    /**
     * 内容
     */
    @TableField(value = "blog_content")
    private String blogContent;
    /**
     * 首图地址
     */
    @TableField(value = "blog_firstFigure")
    private String blogFirstFigure;
    /**
     * 标记
     */
    @TableField(value = "blog_sign")
    private String blogSign;
    /**
     * 浏览次数
     */
    @TableField(value = "blog_views")
    private Integer blogViews;
    /**
     * 赞赏是否开启
     */
    @TableField(value = "blog_admire")
    private Boolean blogAdmire;
    /**
     * 版权是否开启
     */
    @TableField(value = "blog_copyright")
    private Boolean blogCopyright;
    /**
     * 评论是否开启
     */
    @TableField(value = "blog_discuss")
    private Boolean blogDiscuss;
    /**
     * 是否发布
     */
    @TableField(value = "blog_publish")
    private Boolean blogPublish;
    /**
     * 发布时间
     */
    @TableField(value = "blog_creationTime")
    private Date blogCreationTime;
    /**
     * 修改时间
     */
    @TableField(value = "blog_modificationTime")
    private Date blogModificationTime;
    /**
     * 描述
     */
    @TableField(value = "blog_describe")
    private String blogDescribe;
    /**
     * 类型序号
     */
    @TableField(value = "type_id")
    private String typeId;
    /**
     * 类型
     */
    @TableField(exist = false)
    private Type type;
    /**
     * 用户序号
     */
    @TableField(value = "user_id")
    private String userId;
    /**
     * 用户
     */
    @TableField(exist = false)
    private User user;
    /**
     * 评论数量
     */
    @TableField(value = "comment_count")
    private Integer commentCount;
    /**
     * 评论
     */
    @TableField(exist = false)
    private List<Comment> comments = new ArrayList<>();

    public Blog() {
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public String getBlogFirstFigure() {
        return blogFirstFigure;
    }

    public void setBlogFirstFigure(String blogFirstFigure) {
        this.blogFirstFigure = blogFirstFigure;
    }

    public String getBlogSign() {
        return blogSign;
    }

    public void setBlogSign(String blogSign) {
        this.blogSign = blogSign;
    }

    public Integer getBlogViews() {
        return blogViews;
    }

    public void setBlogViews(Integer blogViews) {
        this.blogViews = blogViews;
    }

    public Boolean getBlogAdmire() {
        return blogAdmire;
    }

    public void setBlogAdmire(Boolean blogAdmire) {
        this.blogAdmire = blogAdmire;
    }

    public Boolean getBlogCopyright() {
        return blogCopyright;
    }

    public void setBlogCopyright(Boolean blogCopyright) {
        this.blogCopyright = blogCopyright;
    }

    public Boolean getBlogDiscuss() {
        return blogDiscuss;
    }

    public void setBlogDiscuss(Boolean blogDiscuss) {
        this.blogDiscuss = blogDiscuss;
    }

    public Boolean getBlogPublish() {
        return blogPublish;
    }

    public void setBlogPublish(Boolean blogPublish) {
        this.blogPublish = blogPublish;
    }

    public Date getBlogCreationTime() {
        return blogCreationTime;
    }

    public void setBlogCreationTime(Date blogCreationTime) {
        this.blogCreationTime = blogCreationTime;
    }

    public Date getBlogModificationTime() {
        return blogModificationTime;
    }

    public void setBlogModificationTime(Date blogModificationTime) {
        this.blogModificationTime = blogModificationTime;
    }

    public String getBlogDescribe() {
        return blogDescribe;
    }

    public void setBlogDescribe(String blogDescribe) {
        this.blogDescribe = blogDescribe;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "blogId='" + blogId + '\'' +
                ", blogTitle='" + blogTitle + '\'' +
                ", blogContent='" + blogContent + '\'' +
                ", blogFirstFigure='" + blogFirstFigure + '\'' +
                ", blogSign='" + blogSign + '\'' +
                ", blogViews=" + blogViews +
                ", blogAdmire=" + blogAdmire +
                ", blogCopyright=" + blogCopyright +
                ", blogDiscuss=" + blogDiscuss +
                ", blogPublish=" + blogPublish +
                ", blogCreationTime=" + blogCreationTime +
                ", blogModificationTime=" + blogModificationTime +
                ", blogDescribe='" + blogDescribe + '\'' +
                ", typeId='" + typeId + '\'' +
                ", type=" + type +
                ", userId='" + userId + '\'' +
                ", user=" + user +
                ", commentCount=" + commentCount +
                ", comments=" + comments +
                '}';
    }
}
