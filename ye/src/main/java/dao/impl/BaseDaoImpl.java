package dao.impl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.mysql.jdbc.Connection;

import com.mysql.jdbc.Statement;

import DButil.DButil;
import annotation.FieldAnnotation;
import annotation.TableName;
import dao.BaseDao;
import entity.User;

public class BaseDaoImpl<T> implements BaseDao<T>{
	static PreparedStatement ps;
	static Connection con;
	static ResultSet rs;
private Class<T> t;
	
	public BaseDaoImpl() {
		// 获取泛型真正的类
		t = (Class<T>) (((ParameterizedType) (this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]);
		// System.out.println(t);
		/*Type class1= this.getClass().getGenericSuperclass();
		ParameterizedType parameterizedType= (ParameterizedType)class1;
		Type type= parameterizedType.getActualTypeArguments()[0];
		t= (Class<T>)type;*/
		System.out.println(t);
	}
	@Override
	
	public List<T> selectAllLimit(int index, int num) {
		//拼接sql语句
		StringBuffer stringBuffer=new StringBuffer();
		stringBuffer.append("select");
		//String sql1="select * from ";
		//获取数据库的表名字
		User user=new User();
		Class uClass= user.getClass();
		//获取user类的属性
		Field[] annotations= uClass.getDeclaredFields();
		for (Field field : annotations) {
			stringBuffer.append(","+field.getName());
		}
		//去掉第一个','和最后一个 ','
		stringBuffer.replace(6,7," ");
		//获取类的注解
		stringBuffer.append(" from ");
		Annotation uAnnotation= uClass.getAnnotation(TableName.class);
		TableName tableName= (TableName)uAnnotation;
		//获取注解的值
		String tString= tableName.TName();
		stringBuffer.append(" "+tString);
		//创建连接对象
		DButil dButil=new DButil();
		ArrayList arrayList=new ArrayList();
		try {
			
			con =dButil.getConnection();
			System.out.println(stringBuffer.toString());
			//预编译sql语句
			
			ps= con.prepareStatement(stringBuffer.toString());
			rs = ps.executeQuery();
			 //获取结果集
			  while (rs.next()) {
				  T t1= t.newInstance();
				for (Field field : annotations) {
					field.setAccessible(true);
					field.set(t1, rs.getObject(field.getAnnotation(FieldAnnotation.class).Fname()));
				}
				arrayList.add(t1);
				
			}
			  System.out.println(arrayList);
			  return  arrayList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	@Override
	public int allpage(int num) {
		int page = 0;
		DButil dButil=new DButil();
		// 申明连接 工具 并初始化为 null
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 申明 sql 语句
		String sql = "SELECT CEIL(COUNT(*)/?) num FROM user where status = 1 ;";
		try {
			// 获取连接
			conn = dButil.getConnection();
			ps = conn.prepareStatement(sql);
			dButil.psValus(ps, num);
			rs = ps.executeQuery();
			rs.next();
			page = rs.getInt("num");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dButil.close(conn, ps, rs);
		}

		// 返回变量
		return page;
	}
	@Override
	public int total() {
		DButil dButil=new DButil();
		int total = 0;

		// 申明连接 工具 并初始化为 null
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 申明 sql 语句
		String sql = "SELECT COUNT(*) num FROM user where status = 1 ;";

		try {
			// 获取连接
			
			conn = dButil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			total = rs.getInt("num");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dButil.close(conn, ps, rs);
		}

		// 返回变量
		return total;
	}

	
}
