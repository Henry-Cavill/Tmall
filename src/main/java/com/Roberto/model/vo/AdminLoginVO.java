package com.Roberto.model.vo;

/**
 * @Classname LoginAdminVo
 * @Description
 * @auther by jano
 * @created 2020-07-06 18:53
 **/
public class AdminLoginVO {
    /**
     * 表示管理员登录成功，返回vo
     */
    private String token;

    private String name;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
