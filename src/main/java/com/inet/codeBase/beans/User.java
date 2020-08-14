package com.inet.codeBase.beans;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;

import java.io.Serializable;

@TableName(value = "tbl_User")
public class User implements Serializable {
    /**
     * 用户序号
     */
    @TableId(value = "user_id")
    private String userId;
    /**
     * 用户昵称
     */
    @TableField(value = "user_nickname")
    private String userNickname;
    /**
     * 用户名字
     */
    @TableField(value = "user_name")
    private String userName;
    /**
     * 用户密码
     */
    @TableField(value = "user_password")
    private String userPassword;
    /**
     * 用户邮箱
     */
    @TableField(value = "user_email")
    private String userEmail;
    /**
     * 用户类型
     */
    @TableField(value = "user_type")
    private String userType;
    /**
     * 用户头像
     */
    @TableField(value = "user_headPortrait")
    private String userHeadPortrait;
    /**
     * 用户创建时间
     */
    @TableField(value = "user_creationTime")
    private String userCreationTime;
    /**
     * 用户更新时间
     */
    @TableField(value = "user_turnoverTime")
    private String userTurnoverTime;

    public User() {
    }




    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserHeadPortrait() {
        return userHeadPortrait;
    }

    public void setUserHeadPortrait(String userHeadPortrait) {
        this.userHeadPortrait = userHeadPortrait;
    }

    public String getUserCreationTime() {
        return userCreationTime;
    }

    public void setUserCreationTime(String userCreationTime) {
        this.userCreationTime = userCreationTime;
    }

    public String getUserTurnoverTime() {
        return userTurnoverTime;
    }

    public void setUserTurnoverTime(String userTurnoverTime) {
        this.userTurnoverTime = userTurnoverTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userNickname='" + userNickname + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userType='" + userType + '\'' +
                ", userHeadPortrait='" + userHeadPortrait + '\'' +
                ", userCreationTime='" + userCreationTime + '\'' +
                ", userTurnoverTime='" + userTurnoverTime + '\'' +
                '}';
    }


}
