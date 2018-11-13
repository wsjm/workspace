package com.keduo.service;


public interface iBaseService<T> {
	/**
	 * 	通过id删除数据
	 * @param id
	 * @return 删除成功  true  失败  false
	 */
	public boolean removeById(int id);
	
	/**
	 * 通过id查询数据
	 * @param id
	 * @return 对象  如果不存在，返回  null
	 */
	public T findById(int id);
	
	/**
	 * 修改数据
	 * @param obj
	 * @return true 修改成功  false 修改失败
	 */
	public boolean modifyByid(Object obj);
}
