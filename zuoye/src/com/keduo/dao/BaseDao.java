package com.keduo.dao;

public interface BaseDao<T> {
	public T queryById(int id);
}
