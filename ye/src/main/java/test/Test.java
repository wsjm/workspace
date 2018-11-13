package test;

import java.sql.SQLException;

import DButil.DButil;
import dao.impl.BaseDaoImpl;
import dao.impl.UserDaoImpl;
import entity.User;

public class Test {
public static void main(String[] args) throws Exception {
	DButil dButil=new DButil();
	System.out.println(dButil.getConnection());
	UserDaoImpl baseDaoImpl=new UserDaoImpl();
	baseDaoImpl.QueryUserAll();
}
}
