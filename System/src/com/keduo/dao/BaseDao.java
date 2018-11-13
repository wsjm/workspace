package com.keduo.dao;

import java.util.ArrayList;

public interface BaseDao<T> {
	public T queryById(int id);
	public ArrayList<T> queryAll();
	public int deleteById(int id);
	public boolean updateById(T t);
	public boolean add(T t);
	
}
