package com.inet.codeBase.beans;

public class ShowBlog {
    private String id;
    private String title;
    private String describe;
    private Boolean publish;
    private String typeName;
    private Integer total;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Boolean getPublish() {
        return publish;
    }

    public void setPublish(Boolean publish) {
        this.publish = publish;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "ShowBlog{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", describe='" + describe + '\'' +
                ", publish=" + publish +
                ", typeName='" + typeName + '\'' +
                ", total=" + total +
                '}';
    }
}
