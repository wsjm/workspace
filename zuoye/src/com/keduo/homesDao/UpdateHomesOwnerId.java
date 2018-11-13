
package com.keduo.homesDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.keduo.entity.Homes;
import com.keduo.util.DBUtil;




public  class UpdateHomesOwnerId {
	static int i;
	static ResultSet rs;
	public  Homes  updatehomes(int homes_ownerId, int homesId) throws SQLException{
		Connection con=DBUtil.getConnection();
		Homes homes=new Homes();
		
		PreparedStatement ps= con.prepareStatement("update homes set homes_ownerId=? where homesId=?");
		
		ps.setInt(1, homes_ownerId);
		ps.setInt(2, homesId);
		
		  ps.executeUpdate();
		
		
		  
		con.close();
		

		
return homes;
	}

}
