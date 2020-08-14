package com.inet.codeBase.beans;

public class ShowUser {
    private String Nickname;
    private String HeadPortrait;

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String nickname) {
        Nickname = nickname;
    }

    public String getHeadPortrait() {
        return HeadPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        HeadPortrait = headPortrait;
    }

    @Override
    public String toString() {
        return "ShowUser{" +
                "Nickname='" + Nickname + '\'' +
                ", HeadPortrait='" + HeadPortrait + '\'' +
                '}';
    }
}
