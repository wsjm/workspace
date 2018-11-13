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




public class Selecthomes {
	static int i;
	public  ArrayList<Homes> selecthomes() throws SQLException{
		 Connection con=DBUtil.getConnection();
		 ArrayList<Homes> homesList=new ArrayList<Homes>();
		 
	
		PreparedStatement ps= con.prepareStatement("select * from homes");
		
		//ps.setString(1, name);
		
		ResultSet rs= ps.executeQuery();
		while (rs.next()) {
			Homes homes=new Homes();
			homes.setHomesId(rs.getInt("homesId"));
			homes.setHomes_address(rs.getString("homes_address"));
			homes.setHomes_type(rs.getString("homes_type"));
			homes.setHomes_area(rs.getInt("homes_area"));
			homes.setHomes_ownerId(rs.getInt("homes_ownerId"));
			homesList.add(homes);	
			
			
				
			}
		for (Homes homes : homesList) {
			
			System.out.println(homes);
		}
		
		
			
			
		
		
		
		DBUtil.closeResource(con, ps, rs);
		
		return homesList;
		
	}

}
