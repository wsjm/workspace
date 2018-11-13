package com.keduo.util;

import com.sun.javafx.binding.StringFormatter;

import java.sql.*;

public class Dbutil {
   /* static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;*/
    static String user= "root";
    static String password = "root";
    static String url= "jdbc:mysql://localhost:3306/keduo";
    static {
        //加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //提供连接信息获取连接对象
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
        //获取连接对象
        public static Connection getConnection() throws SQLException {

            return  DriverManager.getConnection("jdbc:mysql://localhost:3306/keduo", "root", "root");
        }
        //关闭资源
    public static void close(Connection con,PreparedStatement ps,ResultSet rs){
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    }


