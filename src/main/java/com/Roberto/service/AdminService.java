package com.Roberto.service;

import com.Roberto.model.bo.Admin;
import com.Roberto.model.bo.AdminLoginBO;

import java.util.List;

public interface AdminService {
    Admin login(AdminLoginBO loginBO);

    List<Admin> allAdmins();
}
