package com.inet.codeBase.beans;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@TableName(value = "tbl_type")
public class Type implements Serializable {
    /**
     * 分类序号
     */
    @TableId(value = "type_id")
    private String typeId;
    /**
     * 分类姓名
     */
    @TableField(value = "type_name")
    private String typeName;
    /**
     * 分类得博客
     */
    @TableField(exist = false)
    private List<Blog> blogs = new ArrayList<>();

    public Type() {
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    @Override
    public String toString() {
        return "Type{" +
                "typeId='" + typeId + '\'' +
                ", typeName='" + typeName + '\'' +
                ", blogs=" + blogs +
                '}';
    }
}
