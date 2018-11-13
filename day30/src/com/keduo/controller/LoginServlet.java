package com.keduo.controller;

import com.keduo.service.UserService;
import com.keduo.user.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取网页信息
        List<User> userList=new ArrayList<User>();
        String name=req.getParameter("name");
        //req.getParameter("password");
        UserService userService=new UserService();
        userService.findUserAll(name);
        System.out.println(name);
        if (name==null){
            resp.sendRedirect("login.jsp");
        }else {
            for (User user: userList){
                System.out.println(user);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req,resp);
    }
}
