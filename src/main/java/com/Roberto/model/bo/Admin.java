package com.Roberto.model.bo;

/**
 * @Classname Admin
 * @Description
 * @auther by jano
 * @created 2020-07-06 18:22
 **/
public class Admin {
    // 数据库表
    private Integer id;

    private String email;

    private String pwd;

    private String nickname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
