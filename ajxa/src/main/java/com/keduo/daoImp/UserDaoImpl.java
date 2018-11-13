package com.keduo.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.keduo.dao.iUserDao;
import com.keduo.entity.User;
import com.keduo.util.JDBCUtil;



public class UserDaoImpl implements iUserDao {
	private JDBCUtil jdbcUtil;

	public UserDaoImpl() {
		super();
		jdbcUtil = JDBCUtil.getInstance();
	}

	@Override
	public User selectPasswordByLoginname(String loginname) {
		// 申明 User 对象，并初始化为 null
		User user = null;
		// 申明工具类
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 申明 sql
		String sql = "SELECT uid , loginname , `password` FROM user WHERE loginname = ? and status =1;";

		try {
			// 获取连接
			conn = jdbcUtil.getConn();
			// 获取ps工具
			ps = conn.prepareStatement(sql);
			// 设置参数
			ps.setString(1, loginname);
			// 执行sql 语句 获取 rs
			rs = ps.executeQuery();
			// 判断是否有结果
			if (rs.next()) {
				// 创建对象
				user = new User();
				// 给属性赋值
				user.setUid(rs.getInt("uid"));
				user.setLoginname(rs.getString("loginname"));
				user.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭释放资源
			jdbcUtil.close(conn, ps, rs);
		}

		return user;
	}

	@Override
	public int updateLastLogintimeByUid(int uid) {
		int row = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "UPDATE user SET lastlogintime = NOW() WHERE uid = ?;";

		try {
			conn = jdbcUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(conn, ps);
		}

		return row;
	}

	@Override
	public int insert(User user) {
		int row = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		// 新增用户时，uid 自增 最后登录时间为空 状态默认为 1 启用 角色组默认为4 新用户
		String sql = "INSERT user VALUES(NULL,?,?,?,?,NULL,1,4);";

		try {
			conn = jdbcUtil.getConn();
			ps = conn.prepareStatement(sql);
			jdbcUtil.psValus(ps, user.getRealname(), user.getLoginname(), user.getPassword(), user.getSex());
			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(conn, ps);
		}

		return row;
	}

	@Override
	public int selectIdByLoginname(String loginname) {
		int uid = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT uid FROM user WHERE loginname = ? ;";

		try {
			conn = jdbcUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, loginname);
			rs = ps.executeQuery();
			// 如果存在，则返回 uid 的值，给 uid 变量重新赋值
			if (rs.next()) {
				uid = rs.getInt("uid");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(conn, ps);
		}

		return uid;
	}

	@Override
	public int deleteByUid(int uid) {
		int row = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		// 新增用户时，uid 自增 最后登录时间为空 状态默认为 1 启用 角色组默认为4 新用户
		String sql = "UPDATE user SET status = 0 WHERE uid = ? and status <> 0;";

		try {
			conn = jdbcUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(conn, ps);
		}

		return row;
	}

	@Override
	public User selectUserByUid(int uid) {
		// 申明 User 对象，并初始化为 null
		User user = null;
		// 申明工具类
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 申明 sql
		String sql = "SELECT uid , `realname` , loginname , `password` , sex, d.`value` sex_str ,lastlogintime ,u.rid, r.`name`  FROM user u LEFT JOIN t_dict d ON u.`sex` = d.`dictid` LEFT JOIN t_role r ON u.`rid` = r.`rid` WHERE uid = ? AND STATUS = 1;";

		try {
			// 获取连接
			conn = jdbcUtil.getConn();
			// 获取ps工具
			ps = conn.prepareStatement(sql);
			// 设置参数
			ps.setInt(1, uid);
			// 执行sql 语句 获取 rs
			rs = ps.executeQuery();
			// 判断是否有结果
			if (rs.next()) {
				// 创建对象
				user = new User();
				// 给属性赋值
				user.setUid(rs.getInt("uid"));
				user.setRealname(rs.getString("realname"));
				user.setLoginname(rs.getString("loginname"));
				user.setPassword(rs.getString("password"));
				user.setSex(rs.getInt("sex"));
				user.setSex_str(rs.getString("sex_str"));
				user.setLastlogintime(rs.getDate("lastlogintime"));
				user.setRole_str(rs.getString("name"));
				user.setRid(rs.getInt("rid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭释放资源
			jdbcUtil.close(conn, ps, rs);
		}

		return user;
	}

	@Override
	public int updateUserByUid(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	/**
	 * 查询所有用户
	 * 
	 * @return List<User > 集合，如果没有内容，返回集合对象长度为 0 User ： uid loginname password
	 *         (只有基本信息，其他的需要点击详情查看)
	 */
	public List<User> selectAllLimit(int index, int num) {
		List<User> users = new ArrayList<>();
		// 申明工具类
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 申明 sql
		String sql = "SELECT uid ,  loginname , `password`   FROM user u  WHERE STATUS = 1 LIMIT ?, ?;";

		try {
			// 获取连接
			conn = jdbcUtil.getConn();
			// 获取ps工具
			ps = conn.prepareStatement(sql);
			jdbcUtil.psValus(ps, index, num);
			// 执行sql 语句 获取 rs
			rs = ps.executeQuery();
			// 判断是否有结果
			while (rs.next()) {
				// 创建对象
				User user = new User();
				// 给属性赋值
				user.setUid(rs.getInt("uid"));
				user.setLoginname(rs.getString("loginname"));
				user.setPassword(rs.getString("password"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭释放资源
			jdbcUtil.close(conn, ps, rs);
		}

		return users;
	}

	@Override
	public int allpage(int num) {
		int page = 0;

		// 申明连接 工具 并初始化为 null
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 申明 sql 语句
		String sql = "SELECT CEIL(COUNT(*)/?) num FROM user where status = 1 ;";

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
		String sql = "SELECT COUNT(*) num FROM user where status = 1 ;";

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
