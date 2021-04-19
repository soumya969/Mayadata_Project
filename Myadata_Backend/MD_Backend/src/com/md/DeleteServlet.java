package com.md;


import java.io.IOException;
import java.io.PrintWriter;
//import java.util.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;



@WebServlet("/deleteservlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String DB_URL = "jdbc:mysql://localhost/meetings";
	static final String USER = "root";
	static final String PASS = "Bablu@123";   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		//response.addHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver"); 
	        Connection con = DriverManager.getConnection(DB_URL, USER,PASS); 
	        
	        String sql = "DELETE FROM meeting_list WHERE Serial =" + Integer.parseInt(request.getParameter("serial"));
	        
	        PreparedStatement pstmt = con.prepareStatement(sql);
	        
	        
	     
	        
	        pstmt.executeUpdate();
			
	        System.out.println("Deleted");
	        
	        con.close();
	        response.setStatus(200);
			
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(400);
			
		} finally {
	        out.flush();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}