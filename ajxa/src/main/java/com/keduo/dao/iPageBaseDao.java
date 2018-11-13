package com.keduo.dao;

import java.util.List;



public interface iPageBaseDao<T> {
	/**
	 * 分页查询所有内容
	 * @return List<T > 集合，如果没有内容，返回集合对象长度为 0 
	 */
	public List<T> selectAllLimit(int index , int num);
	
	/**
	 * 查询所有页数
	 * @param num  记录条数
	 * @return 返回页数，如果没有返回 0
	 */
	public int allpage(int num);
	//获得总条数
	public int total();
}
