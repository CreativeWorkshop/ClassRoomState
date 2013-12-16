package com.dy.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dy.util.DBUtil;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class HaddGoodsServlet
 */
public class HaddGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static String path="goods";  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HaddGoodsServlet() {
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
		

		String name = request.getParameter("name");
		DBUtil util = new DBUtil();
		Connection conn = util.openConnection();

		try {
				String sql = "insert into room(no,state) values('"+name+"','ø’œ–')";
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(sql);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
		response.sendRedirect("admin/goods/goodsMana.jsp");
	}

}
