package com.keduo.dao;

import com.keduo.user.User;
import com.keduo.util.Dbutil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDao {
    public List<User> findUserAll(String name) throws SQLException {
        List<User> userList=new ArrayList<User>();

        Connection con= Dbutil.getConnection();


        //通过连接对象执行对象
        PreparedStatement ps= con.prepareStatement("select * from hero where name=?");
        //占位符的处理
        ps.setString(1,name);
        //获取结果集
       ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            User user=new User();

            user.setId(rs.getInt("id"));
            user.setAddress(rs.getString("name"));
            user.setAge(rs.getString("age"));
            user.setName(rs.getString("sex"));
            user.setSalary(rs.getString("salary"));
            userList.add(user);

        }
        Dbutil.close(con,ps,rs);

        return userList;
    }
}
