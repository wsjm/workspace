package com.keduo.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.keduo.dao.iRoleDao;
import com.keduo.entity.Role;
import com.keduo.util.JDBCUtil;



public class RoleDaoImpl implements iRoleDao {
	private JDBCUtil jdbcUtil;

	public RoleDaoImpl() {
		jdbcUtil = JDBCUtil.getInstance();
	}

	@Override
	public int insertRole(Role role) {
		// 申明受影响行数
		int row = 0;
		// 申明工具类
		Connection conn = null;
		PreparedStatement ps = null;
		// 申明 sql 语句
		String sql = "INSERT INTO role VALUES(NULL , ?);";
		try {
			// 获取连接
			conn = jdbcUtil.getConn();
			// 获取 ps 工具
			ps = conn.prepareStatement(sql);
			// ps 设置参数
			jdbcUtil.psValus(ps, role.getName());
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
	public int deleteRoleById(int id) {
		// 申明受影响行数
		int row = 0;
		// 申明工具类
		Connection conn = null;
		PreparedStatement ps = null;
		// 申明 sql 语句
		String sql = "DELETE FROM role WHERE `rid` = ?;";
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
	public Role selectRoleById(int id) {
		// 申明Role 对象，初始化为 null
		Role role = null;
		// 申明工具类
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 申明 sql 语句
		String sql = "SELECT `rid` , `name` FROM role WHERE `rid` = ?;";
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
				// role 创建对象
				role = new Role();
				// 读取数据，放入 role属性
				role.setRid(rs.getInt("rid"));
				role.setName(rs.getString("name"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭释放连接
			jdbcUtil.close(conn, ps, rs);
		}
		return role;
	}

	@Override
	public List<Role> selectAllRoles() {
		// 申明List集合 对象，并实例化
		List<Role> roles = new ArrayList<>();
		// 申明工具类
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 申明 sql 语句
		String sql = "SELECT `rid` , `name` FROM role ;";
		try {
			// 获取连接
			conn = jdbcUtil.getConn();
			// 获取 ps 工具
			ps = conn.prepareStatement(sql);
			// 执行sql
			rs = ps.executeQuery();
			// 循环遍历
			while (rs.next()) {
				// role 创建对象
				Role role = new Role();
				// 读取数据，放入 role属性
				role.setRid(rs.getInt("rid"));
				role.setName(rs.getString("name"));
				// role 放入 集合list 中
				roles.add(role);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭释放连接
			jdbcUtil.close(conn, ps, rs);
		}
		return roles;
	}

	@Override
	public int updateRoleById(Role role) {
		// 申明受影响行数
		int row = 0;
		// 申明工具类
		Connection conn = null;
		PreparedStatement ps = null;
		// 申明 sql 语句
		String sql = "UPDATE role SET `name` = ? WHERE `rid` = ?;";
		try {
			// 获取连接
			conn = jdbcUtil.getConn();
			// 获取 ps 工具
			ps = conn.prepareStatement(sql);
			// ps 设置参数
			jdbcUtil.psValus(ps, role.getName(), role.getRid());
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
	public List<Role> selectAllLimit(int index, int num) {
		// 申明变量并初始化 集合对象
		List<Role> list = new ArrayList<>();

		// 申明连接 工具 并初始化为 null
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 申明 sql 语句
		String sql = "SELECT * FROM role LIMIT ? , ?;";

		try {
			// 获取连接
			conn = jdbcUtil.getConn();
			ps = conn.prepareStatement(sql);
			jdbcUtil.psValus(ps, index, num);
			rs = ps.executeQuery();
			// 循环遍历 rs 的值
			while (rs.next()) {
				Role role = new Role();
				role.setRid(rs.getInt("rid"));
				role.setName(rs.getString("name"));
				// 对象添加入 集合中
				list.add(role);
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
		String sql = "SELECT CEIL(COUNT(*)/?) num FROM role;";

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
	public int total() {
		int total = 0;

		// 申明连接 工具 并初始化为 null
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 申明 sql 语句
		String sql = "SELECT COUNT(*) num FROM role;";

		try {
			// 获取连接
			conn = jdbcUtil.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			total = rs.getInt("num");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(conn, ps, rs);
		}

		// 返回变量
		return total;
	}

}
