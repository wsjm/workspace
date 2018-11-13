package com.keduo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.keduo.dao.MenuDao;
import com.keduo.entity.MainMenu;
import com.keduo.entity.Menu;
import com.keduo.util.DBUtil;

public class MenuDaoImpl extends BaseDaoImpl<Menu>implements MenuDao{

	
	public List<Menu> getMenus(int rid) {
		Connection con =null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Menu> menuList = new ArrayList<Menu>();
		try {
			con = DBUtil.getconnection();	
			pstm=con.prepareStatement("SELECT m.* FROM t_menu m JOIN t_role_menu tm ON m.`mid`=tm.`mid` JOIN t_role r ON tm.`rid`=r.`rid` WHERE r.`rid`=?");
			pstm.setInt(1, rid);
			rs = pstm.executeQuery();
			while(rs.next()) {
				Menu menu = new Menu();
				menu.setMid(rs.getInt("mid"));
				menu.setMname(rs.getString("mname"));
				menu.setUrl(rs.getString("url"));
				menu.setMmid(rs.getInt("mmid"));
				menuList.add(menu);
			}
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
		return menuList;
	}

	@Override
	public List<MainMenu> getSuperMenus(int rid) {
		Connection con =null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<MainMenu> mainMenuList = new ArrayList<MainMenu>();
		try {
			con = DBUtil.getconnection();
			pstm = con.prepareStatement("SELECT d.`dictid`,d.`value` FROM t_dict d JOIN t_menu m ON d.`dictid`= m.`mmid` JOIN t_role_menu rm ON m.`mid`=rm.`mid` JOIN t_role r ON rm.`rid`=r.`rid` WHERE r.`rid`=? GROUP BY d.`dictid`");
			pstm.setInt(1, rid);
			rs=pstm.executeQuery();
			while(rs.next()) {
				MainMenu mainMenu = new MainMenu();
				mainMenu.setMainMenuId(rs.getInt("dictid"));
				mainMenu.setMainMenuName(rs.getString("value"));
				mainMenuList.add(mainMenu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mainMenuList;
	}

	@Override
	public List<Menu> getChildMenus(int rid, int superMenuId) {
		Connection con =null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Menu> menuList = new ArrayList<Menu>();
		//System.out.println(rid+":::"+superMenuId);
		try {
			con=DBUtil.getconnection();
			pstm=con.prepareStatement("SELECT m.* FROM t_menu m JOIN t_role_menu tm ON tm.mid=m.`mid` JOIN t_role r ON tm.rid=r.`rid` WHERE r.`rid`=? AND m.`mmid`=? GROUP BY m.`mid`");
			pstm.setInt(1, rid);
			pstm.setInt(2, superMenuId);
			rs=pstm.executeQuery();
			while(rs.next()) {
				Menu menu = new Menu();
				menu.setMid(rs.getInt("mid"));
				menu.setMmid(rs.getInt("mmid"));
				menu.setMname(rs.getString("mname"));
				menu.setUrl(rs.getString("url"));
				menuList.add(menu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menuList;
	}
	
}
