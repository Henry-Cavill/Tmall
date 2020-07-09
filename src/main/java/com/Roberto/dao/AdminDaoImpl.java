package com.Roberto.dao;

import com.Roberto.model.bo.Admin;
import com.Roberto.utils.DruidUtils;
import com.alibaba.druid.util.StringUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Classname AdminDaoImpl
 * @Description
 * @auther by jano
 * @created 2020-07-06 15:52
 **/
public class AdminDaoImpl implements AdminDao {

    @Override
    public Admin login(Admin admin) {
        // 查询数据库
        QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
        Admin query = null;
        try {
            query = runner.query("select * from admin where email = ? and pwd = ?",
                    new BeanHandler<>(Admin.class),
                        admin.getEmail(),
                        admin.getPwd());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    @Override
    public List<Admin> allAdmins() {
        QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
        List<Admin> admins = null;
        try {
            admins = runner.query("select * from admin",new BeanListHandler<Admin>(Admin.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return admins;
    }

    /**
     * 写sql语句
     * 动态sql思想
     * @param admin
     * @return
     */
    @Override
    public List<Admin> getSearchAdmins(Admin admin) {
        Map<String, Object> params = getDynamicSql(admin);
        return null;
    }

    // 组合使用sql查询
    private Map<String,Object> getDynamicSql(Admin admin) {
        String base = "select * from admin where 1 = 1";
        List<String> params = new ArrayList<>();
        if(!StringUtils.isEmpty(admin.getEmail())){

        }
        return null;
    }
}
