package com.Roberto.service;

import com.Roberto.model.bo.Admin;
import com.Roberto.model.bo.AdminLoginBO;
import com.Roberto.model.bo.AdminSerachBO;

import java.util.List;

public interface AdminService {
    Admin login(AdminLoginBO loginBO);

    List<Admin> allAdmins();

    List<Admin> getSearchAdmins(AdminSerachBO serachBO);
}
