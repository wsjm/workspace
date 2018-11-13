package com.keduo.daoImpl;



import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.keduo.dao.BaseDao;

import java.sql.*;


import annotation.Table;



public class BaseDaoImpl<T> implements BaseDao<T> {
	//实际的T类型
	private Class<T> ct;
	public BaseDaoImpl(){
		Type  t1=getClass().getGenericSuperclass();
		ParameterizedType pt=(ParameterizedType)t1;
		Type t2=pt.getActualTypeArguments()[0];
        ct=(Class<T>)t2;
		System.out.println(ct);
	}
	@Override
	public T queryById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	


}
