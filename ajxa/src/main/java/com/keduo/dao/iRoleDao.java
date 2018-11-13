package com.keduo.dao;

import java.util.List;

import com.keduo.entity.Role;




public interface iRoleDao extends iPageBaseDao<Role>{

	/**
	 * 新增角色
	 * @param role
	 * @return 受影响行数
	 */
	public int insertRole(Role role);
	
	/**
	 * 通过ID删除角色
	 * @param id
	 * @return 受影响行数
	 */
	public int deleteRoleById(int id);
	
	/**
	 * 通过ID查询角色
	 * @param id
	 * @return 角色对象，如果不存在返回 null
	 */
	public Role selectRoleById(int id);
	
	/**
	 * 查询所有角色
	 * @return List 集合对象，如果没有内容，返回长度为0 的集合对象
	 */
	public List<Role> selectAllRoles();
	
	/**
	 * 通过id修改角色
	 * @param id
	 * @return 受影响行数
	 */
	public int updateRoleById(Role role);

}

