package com.dy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dy.util.DBUtil;

/**
 * Servlet implementation class ListServlet
 */
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
		String state = URLDecoder.decode(request.getParameter("state"),"UTF-8");
		String sql = "SELECT * from room where 1=1 ";
		if(no!=null&&!no.equals("")){
			sql+=" and no = '"+no+"'";
		} if(state!=null&&!state.equals("")&&!state.equals("«Î—°‘Ò")){
			sql+=" and state = '"+state+"'";
		} 
		DBUtil util = new DBUtil();
		Connection conn = util.openConnection();
		String result = "";
		System.out.println("sql ="+sql);
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			int i = 0;
			while(rs.next()) {
				String no1 =rs.getString("no");
				String state1=rs.getString("state");
 				if(i!=0){
					result+="@";
				}
				result+=no1;
				result+=",";
				result+=state1;
				i++;
			}
		}catch (SQLException e) {
			result = "0";
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}	
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(result);
		
	}

}
