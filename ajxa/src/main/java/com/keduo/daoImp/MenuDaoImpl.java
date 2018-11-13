package com.keduo.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.keduo.dao.iMenuDao;
import com.keduo.entity.Menu;
import com.keduo.util.JDBCUtil;


public class MenuDaoImpl implements iMenuDao {
	private JDBCUtil jdbcUtil;

	public MenuDaoImpl() {
		super();
		jdbcUtil = JDBCUtil.getInstance();
	}

	@Override
	public int insertMenu(Menu menu) {
		// 申明受影响行数
		int row = 0;
		// 申明工具类
		Connection conn = null;
		PreparedStatement ps = null;
		// 申明 sql 语句
		String sql = "INSERT INTO menu VALUES(NULL , ?,?);";
		try {
			// 获取连接
			conn = jdbcUtil.getConn();
			// 获取 ps 工具
			ps = conn.prepareStatement(sql);
			// ps 设置参数
			jdbcUtil.psValus(ps, menu.getName(), menu.getUrl());
			// 执行sql
			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭释放连接
			jdbcUtil.close(conn, ps);
		}
		// 返回受影响行数
		return row;
	}

	@Override
	public int deleteMenuById(int id) {
		// 申明受影响行数
		int row = 0;
		// 申明工具类
		Connection conn = null;
		PreparedStatement ps = null;
		// 申明 sql 语句
		String sql = "DELETE FROM menu WHERE `mid` = ?;";
		try {
			// 获取连接
			conn = jdbcUtil.getConn();
			// 获取 ps 工具
			ps = conn.prepareStatement(sql);
			// ps 设置参数
			jdbcUtil.psValus(ps, id);
			// 执行sql
			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭释放连接
			jdbcUtil.close(conn, ps);
		}
		// 返回受影响行数
		return row;
	}

	@Override
	public Menu selectMenuById(int id) {
		// 申明Menu 对象，初始化为 null
		Menu menu = null;
		// 申明工具类
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 申明 sql 语句
		String sql = "SELECT `mid` , `name` , murl FROM menu WHERE `mid` = ?;";
		try {
			// 获取连接
			conn = jdbcUtil.getConn();
			// 获取 ps 工具
			ps = conn.prepareStatement(sql);
			// ps 设置参数
			jdbcUtil.psValus(ps, id);
			// 执行sql
			rs = ps.executeQuery();
			// 判断是否有唯一结果
			if (rs.next()) {
				// menu 创建对象
				menu = new Menu();
				// 读取数据，放入 menu属性
				menu.setMid(rs.getInt("mid"));
				menu.setName(rs.getString("name"));
				menu.setUrl(rs.getString("murl"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭释放连接
			jdbcUtil.close(conn, ps, rs);
		}
		return menu;
	}

	@Override
	public List<Menu> selectAllMenus() {
		// 申明List集合 对象，并实例化
		List<Menu> menus = new ArrayList<>();
		// 申明工具类
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 申明 sql 语句
		String sql = "SELECT `mid` , `name` , murl FROM menu ;";
		try {
			// 获取连接
			conn = jdbcUtil.getConn();
			// 获取 ps 工具
			ps = conn.prepareStatement(sql);
			// 执行sql
			rs = ps.executeQuery();
			// 循环遍历 rs 所有数据
			while (rs.next()) {
				// menu 创建对象
				Menu menu = new Menu();
				// 读取数据，放入 menu属性
				menu.setMid(rs.getInt("mid"));
				menu.setName(rs.getString("name"));
				menu.setUrl(rs.getString("murl"));
				// menu对象放入 list 集合中
				menus.add(menu);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭释放连接
			jdbcUtil.close(conn, ps, rs);
		}
		return menus;
	}

	@Override
	public int updateMenuById(Menu menu) {
		// 申明受影响行数
		int row = 0;
		// 申明工具类
		Connection conn = null;
		PreparedStatement ps = null;
		// 申明 sql 语句
		String sql = "UPDATE menu SET `name` = ? , murl =? WHERE `mid` = ?;";
		try {
			// 获取连接
			conn = jdbcUtil.getConn();
			// 获取 ps 工具
			ps = conn.prepareStatement(sql);
			// ps 设置参数
			jdbcUtil.psValus(ps, menu.getName(), menu.getUrl(), menu.getMid());
			// 执行sql
			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭释放连接
			jdbcUtil.close(conn, ps);
		}
		// 返回受影响行数
		return row;
	}

	@Override
	public List<Menu> selectAllLimit(int index, int num) {
		// 申明变量并初始化 集合对象
		List<Menu> list = new ArrayList<>();

		// 申明连接 工具 并初始化为 null
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 申明 sql 语句
		String sql = "SELECT * FROM menu LIMIT ? , ?;";

		try {
			// 获取连接
			conn = jdbcUtil.getConn();
			ps = conn.prepareStatement(sql);
			jdbcUtil.psValus(ps, index, num);
			rs = ps.executeQuery();
			// 循环遍历 rs 的值
			while (rs.next()) {
				Menu menu = new Menu();
				menu.setMid(rs.getInt("mid"));
				menu.setName(rs.getString("name"));
				menu.setUrl(rs.getString("murl"));
				// 对象添加入 集合中
				list.add(menu);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(conn, ps, rs);
		}

		// 返回变量
		return list;
	}

	@Override
	public int allpage(int num) {
		int page = 0;

		// 申明连接 工具 并初始化为 null
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 申明 sql 语句
		String sql = "SELECT CEIL(COUNT(*)/?) num FROM menu;";

		try {
			// 获取连接
			conn = jdbcUtil.getConn();
			ps = conn.prepareStatement(sql);
			jdbcUtil.psValus(ps, num);
			rs = ps.executeQuery();
			rs.next();
			page = rs.getInt("num");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(conn, ps, rs);
		}

		// 返回变量
		return page;
	}

	@Override
	public List<Menu> selectMenusByUid(int uid) {
		// 申明List集合 对象，并实例化
		List<Menu> menus = new ArrayList<>();
		// 申明工具类
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 申明 sql 语句
		String sql = "SELECT m.`name` , m.`murl` FROM menu m JOIN role_menu rm ON m.`mid` = rm.`mid` JOIN role r ON r.`rid` = rm.`rid` JOIN user u ON u.`rid` = r.`rid` WHERE u.`uid` = ? AND u.`status` = 1";
		try {
			// 获取连接
			conn = jdbcUtil.getConn();
			// 获取 ps 工具
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			// 执行sql
			rs = ps.executeQuery();
			// 循环遍历 rs 所有数据
			while (rs.next()) {
				// menu 创建对象
				Menu menu = new Menu();
				// 读取数据，放入 menu属性
				menu.setName(rs.getString("name"));
				menu.setUrl(rs.getString("murl"));
				// menu对象放入 list 集合中
				menus.add(menu);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭释放连接
			jdbcUtil.close(conn, ps, rs);
		}
		return menus;
	}

	@Override
	public int total() {
		int total = 0;

		// 申明连接 工具 并初始化为 null
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 申明 sql 语句
		String sql = "SELECT COUNT(*) num FROM menu;";

		try {
			// 获取连接
			conn = jdbcUtil.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
	        total=rs.getInt("num");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(conn, ps, rs);
		}

		// 返回变量
		return total;
	}

}
