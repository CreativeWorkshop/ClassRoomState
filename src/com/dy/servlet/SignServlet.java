package com.dy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dy.util.DBUtil;

/**
 * Servlet implementation class SignServlet
 */
public class SignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String no = URLDecoder.decode(request.getParameter("no"),"UTF-8");
		String sql = "update room set room.number=room.number+1 where no='"+no+"'";
		String sql2 = "select number from room where no='"+no+"'";
		DBUtil util = new DBUtil();
		Connection conn = util.openConnection();
		int data1 = 0;
		int data2 = 0;
		int result = 0;
		try {					
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			
			PreparedStatement pstmt = conn.prepareStatement(sql2);
			ResultSet rs = pstmt.executeQuery();
			data1 = rs.getInt("number");	
			while(rs.next()) {
				data2=rs.getInt("number");
			}
			if(data2>data1){
				result = 1;
			}else{
				result = 0;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}	
		PrintWriter out = response.getWriter();
		out.print(result);
	}

}
