package com.Roberto.service;

import com.Roberto.dao.AdminDao;
import com.Roberto.dao.AdminDaoImpl;
import com.Roberto.model.bo.Admin;
import com.Roberto.model.bo.AdminLoginBO;

import java.util.List;

/**
 * @Classname AdminServicelmpl
 * @Description
 * @auther by jano
 * @created 2020-07-06 15:41
 **/
public class AdminServicelmpl implements AdminService {

    private AdminDao adminDao = new AdminDaoImpl();
    @Override
    public Admin login(AdminLoginBO loginBO) {
        Admin admin = new Admin();
        admin.setEmail(loginBO.getEmail());
        admin.setPwd(loginBO.getPwd());

        return adminDao.login(admin);
    }

    @Override
    public List<Admin> allAdmins() {
        return adminDao.allAdmins();
    }
}
