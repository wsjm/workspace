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
        //��������
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //�ṩ������Ϣ��ȡ���Ӷ���
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
        //��ȡ���Ӷ���
        public static Connection getConnection() throws SQLException {

            return  DriverManager.getConnection("jdbc:mysql://localhost:3306/keduo", "root", "root");
        }
        //�ر���Դ
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


