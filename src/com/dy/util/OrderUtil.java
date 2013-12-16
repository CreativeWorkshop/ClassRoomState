package com.dy.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderUtil {
	
	public static void order(){
		
		String sql = "select * from room ";
		DBUtil util = new DBUtil();
		Connection conn = util.openConnection();
		ResultSet rs = null;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				int a=(int)(Math.random()*10);
				
				Statement stmt = conn.createStatement();
				
				if(a%2==0){
						String sql2 = "update room set state = 'ø’œ–' where id="+id;
						stmt.executeUpdate(sql2);
					
				}else{
					String sql3 = "update room set state = '’º”√' where id="+id;
					stmt.executeUpdate(sql3);
				}
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
