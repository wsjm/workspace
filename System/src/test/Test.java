package test;

import java.sql.SQLException;

import com.keduo.DButil.DButil;
import com.keduo.daoImpl.UserDaoImpl;
import com.keduo.entity.User;

public class Test {
	public static void main(String[] args) throws SQLException {
		
		UserDaoImpl userDaoImpl=new UserDaoImpl();
		//userDaoImpl.queryById(1);
		//userDaoImpl.queryAll();
		//userDaoImpl.deleteById(1);
		//userDaoImpl.queryAll();
		User user=new User("1","3","3",3,"3",3);
		//userDaoImpl.updateById(user);
		userDaoImpl.add(user);
		userDaoImpl.queryAll();
	}
}
