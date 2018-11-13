package com.keduo.dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.keduo.annotation.FieldName;
import com.keduo.annotation.TableName;
import com.keduo.dao.BaseDao;
import com.keduo.util.DBUtil;

public class BaseDaoImpl<T> implements BaseDao<T> {
	Connection con = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	private Class<T> t;

	public BaseDaoImpl() {
		// 获取泛型真正的类
		t = (Class<T>) (((ParameterizedType) (this.getClass().getGenericSuperclass())).getActualTypeArguments())[0];
		// System.out.println(t);
	}

	@Override
	public T queryById(int id) {
		String sql = "select ";

//		String sql = "select * from " + t.getAnnotation(TableName.class).tName() + " where ";

		String idName = null;// id应对的表字段名
		// 通过反射获取所有的字段名
		Field[] f1 = t.getDeclaredFields();
		// 遍历数组获取id对应的表字段名
		for (Field field : f1) {
			sql = sql + "," + field.getAnnotation(FieldName.class).fName();
			if (field.getAnnotation(FieldName.class).isPrimaryKey()) {
				idName = field.getAnnotation(FieldName.class).fName();
			}
		}
		// 去除第一个","
		sql = sql.replaceFirst(",", "");
		// 获取类注解中的表名，并拼接到字符串
		sql = sql + " from " + t.getAnnotation(TableName.class).tName() + " where ";
		sql = sql + idName + "=" + id;
//		System.out.println(sql);
		try {
			T tt = t.newInstance();// 创建一个新对象
			con = DBUtil.getconnection();
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (rs.next()) {
				for (Field field : f1) {
					field.setAccessible(true);// 取消Java语言访问检查，以便设置私有属性的值
					field.set(tt, rs.getObject(field.getAnnotation(FieldName.class).fName()));
				}
			}
			return tt;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtil.closeResource(con, pstm, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public ArrayList<T> queryAll() {
//		String sql = "select * from " + t.getAnnotation(TableName.class).tName();
		Field[] f1 = t.getDeclaredFields();
		String sql = "select ";
		for (Field field : f1) {
			sql = sql + "," + field.getAnnotation(FieldName.class).fName();

		}
		// 去除第一个","
		sql = sql.replaceFirst(",", "");
		// 获取类注解中的表名，并拼接到字符串
		sql = sql + " from " + t.getAnnotation(TableName.class).tName();
//		System.out.println(sql);
		try {
			con = DBUtil.getconnection();
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			ArrayList<T> ttList = new ArrayList<T>();// 新建对象集合
			while (rs.next()) {
				T tt = t.newInstance();
				for (Field field : f1) {
					field.setAccessible(true);
					field.set(tt, rs.getObject(field.getAnnotation(FieldName.class).fName()));
				}
				ttList.add(tt);
			}
			return ttList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtil.closeResource(con, pstm, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;
	}

	@Override
	public int deleteById(int id) {
		String sql = "delete from " + t.getAnnotation(TableName.class).tName() + " where ";
		Field[] f1 = t.getDeclaredFields();
		String idName = null;
		for (Field field : f1) {
			if (field.getAnnotation(FieldName.class).isPrimaryKey()) {
				idName = field.getAnnotation(FieldName.class).fName();
			}

		}
		sql = sql + idName + "=" + id;
		try {
			con = DBUtil.getconnection();
			pstm = con.prepareStatement(sql);
			return pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtil.closeResource(con, pstm, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;

	}

	/**
	 * 根据ID修改表，此方法只能实现全部修改
	 */
	@Override
	public int updateById(T tl) {
		//update 表名 set 列名=值,列名=值,... where 列名=值
		
		String sql = "update " + t.getAnnotation(TableName.class).tName() + " set ";
		String idName = null;// id应对的表字段名
		int id = 0;
		// 通过反射获取所有的字段名
		Field[] f1 = t.getDeclaredFields();
		// 存放修改数据的集合
		List list = new ArrayList();
		// 遍历f1获取id对应的表字段名,并添加需要修改到数据到集合list,同时拼接sql语句
		for (Field field : f1) {

			if (field.getAnnotation(FieldName.class).isPrimaryKey()) {
				idName = field.getAnnotation(FieldName.class).fName();
				try {
					field.setAccessible(true);
					id = field.getInt(tl);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				continue;
			}
			try {
				field.setAccessible(true);
				sql = sql + "," + field.getAnnotation(FieldName.class).fName() + "=?";
				list.add(field.get(tl));
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 去掉第一个","
		sql = sql.replaceFirst(",", "");
		
		sql = sql + " where " + idName + "=?";

		System.out.println(sql);
		try {
			con = DBUtil.getconnection();
			pstm = con.prepareStatement(sql);
//			通过遍历list给?赋值
			for (int i = 0; i < list.size(); i++) {
				pstm.setObject(i + 1, list.get(i));
			}
			pstm.setInt(list.size() + 1, id);

			return pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtil.closeResource(con, pstm, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int add(T tl) {
		//insert into 表名 (列名1，列名2，...) values(值1，值2，...)
		String sql1 = "insert into "+t.getAnnotation(TableName.class).tName() + "(";
		String sql2 = ") values (";
		Field[] f1 = t.getDeclaredFields();
		//存放添加值的集合
		List list = new ArrayList();
		//遍历f1添加所有字段名
		for (Field field : f1) {
			field.setAccessible(true);
			//主键由表自动生成，不能直接指定
			if(field.getAnnotation(FieldName.class).isPrimaryKey()) {
				continue;
			}
			try {
				list.add(field.get(tl));
				sql1 = sql1 +"," + field.getAnnotation(FieldName.class).fName();
				sql2 = sql2 + ",?";
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//去掉第一个","
		sql1 = sql1.replaceFirst(",", "");
		sql2 = sql2.replaceFirst(",", "");
		String sql = sql1 + sql2 + ")";
		//System.out.println(sql);
		try {
			con = DBUtil.getconnection();
			pstm = con.prepareStatement(sql);
			for(int i = 0;i<list.size();i++) {
				pstm.setObject(i+1, list.get(i));
			}
			return pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtil.closeResource(con, pstm, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return 0;
	}

	// 根据任意条件查询
//	public ArrayList<T> query(Object... objects) {
//		String sql = "select ";
//		Field[] f1 = t.getDeclaredFields();
//		for (Field field : f1) {
//			sql = sql + "," + field.getAnnotation(FieldName.class).fName();
//
//		}
//		// 去除第一个","
//		sql = sql.replaceFirst(",", "");
//		sql = sql + " from " + t.getAnnotation(TableName.class).tName() + " where ";
//		for (int i = 0; i < f1.length; i++) {
//			
//		}
//		return null;
//
//	}

}
