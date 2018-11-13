package com.keduo.service;

import java.util.Map;


public interface iPageBaseService {

	/**
	 * 分页查询所有数据
	 * @param page  第几页
	 * @param num  每页记录条数
	 * @return   page:当前页码  num:每页多少条  allpage：总页数    list:菜单的集合，如果没有 返回集合对象长度为 0
	 */
	public Map<String, Object> findAllPage(int page , int num);
}
