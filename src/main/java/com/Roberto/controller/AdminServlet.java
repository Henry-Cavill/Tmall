package com.Roberto.controller;

import com.Roberto.model.bo.Admin;
import com.Roberto.model.bo.AdminLoginBO;
import com.Roberto.model.bo.AdminSerachBO;
import com.Roberto.model.bo.Result;
import com.Roberto.model.vo.AdminLoginVO;
import com.Roberto.service.AdminService;
import com.Roberto.service.AdminServicelmpl;
import com.Roberto.utils.HttpUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/admin/admin/*")
public class AdminServlet extends HttpServlet {
    private AdminService adminService = new AdminServicelmpl();

    Gson gson = new Gson();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String replace = requestURI.replace("/api/admin/admin/", "");
        if("login".equals(replace)){
            login(request,response);
        } else if ("getSearchAdmins".equals(replace)) {  // 判断请求相应动作
            getSearchAdmins(request,response);
        }
    }

    /**
     * 条件查询admin管理员账户信息
     * 1.浏览器向8084发送一个请求，请求中携带了账户昵称参数
     * 2.查询数据库，返回满足条件的数据
     * 3.根据结果返回不同的响应
     * @param request
     * @param response
     */
    private void getSearchAdmins(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = HttpUtils.getRequestBody(request);
        // json转成可以处理的数据类型
        AdminSerachBO serachBO = gson.fromJson(requestBody, AdminSerachBO.class);
        List<Admin> admins = adminService.getSearchAdmins(serachBO);
        response.getWriter().println(gson.toJson(Result.ok(admins)));

    }

    /**
     * 管理员登录的具体业务逻辑
     * 1.浏览器向8084发送一个请求，该请求体中携带了用户名和密码
     * 2.查询数据库，校验当前用户名和密码是否正确
     * 3.根据结果返回不同的相应
     * @param request
     * @param response
     */
    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestBody = HttpUtils.getRequestBody(request);
        // json字符串------java对象

        AdminLoginBO loginBO = gson.fromJson(requestBody, AdminLoginBO.class);

        Admin login = adminService.login(loginBO);
        // 判断登录状态
        Result result = new Result();
        if(login != null){
            AdminLoginVO loginVO = new AdminLoginVO();
            loginVO.setToken(login.getNickname());
            loginVO.setName(login.getNickname());
            response.getWriter().println(gson.toJson(Result.ok(loginVO)));
            result.setData(loginVO);
        }else {
            response.getWriter().println(Result.error("用户名或者密码错误"));
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String replace = requestURI.replace("/api/admin/admin/", "");
        if("allAdmins".equals(replace)){
            allAdmins(request,response);
        }
    }

    /**
     * 显示所有的admin信息
     * 1.查询数据库，返回数据
     * 2.作出响应
     * @param request
     * @param response
     */
    private void allAdmins(HttpServletRequest request, HttpServletResponse response) throws IOException {
       List<Admin> adminList =  adminService.allAdmins();
        Result result = new Result();
        result.setCode(0);
        result.setData(adminList);
        response.getWriter().println(gson.toJson(result));
    }
}
