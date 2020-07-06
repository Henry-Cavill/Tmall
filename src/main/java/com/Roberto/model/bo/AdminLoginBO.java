package com.Roberto.model.bo;

/**
 * @Classname AdminLoginBO
 * @Description
 * @auther by jano
 * @created 2020-07-05 12:30
 **/
public class AdminLoginBO {
    private String email;
    private String pwd;

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

    @Override
    public String toString() {
        return "AdminLoginBO{" +
                "email='" + email + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
