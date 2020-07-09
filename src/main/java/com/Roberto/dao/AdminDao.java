package com.Roberto.dao;

import com.Roberto.model.bo.Admin;

import java.util.List;

public interface AdminDao {
    Admin login(Admin admin);

    List<Admin> allAdmins();

    List<Admin> getSearchAdmins(Admin admin);
}
