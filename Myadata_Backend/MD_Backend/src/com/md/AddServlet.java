package com.md;


//import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
//import java.util.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;



@WebServlet()
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String DB_URL = "jdbc:mysql://localhost/meetings";
	static final String USER = "root";
	static final String PASS = "Bablu@123";   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		//response.addHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver"); 
	        Connection con = DriverManager.getConnection(DB_URL, USER,PASS); 
	        
	        String sql="INSERT INTO `meeting_list`VALUES (? ,? ,? ,? ,? ,?);";
	        //sql="SELECT * FROM invoice_details";
	        //sql="SELECT * FROM invoice_details LIMIT " + request.getParameter("pages")+","+  request.getParameter("limit");
	      //System.out.println(request.getParameter("pages"));
	        PreparedStatement pstmt = con.prepareStatement(sql);
	        //ResultSet rs = stmt.executeQuery(sql);
	        
	        
	        Pojo obj= new Pojo();
	        DateFormat formatter = new SimpleDateFormat("HH:mm");
	        //java.sql.Time timeValue = 
	        obj.setSerial(Integer.parseInt(request.getParameter("serial")));
	        obj.setName(request.getParameter("name"));
	        obj.setAttendee(Integer.parseInt(request.getParameter("attendee")));
	        obj.setStart(new java.sql.Time(formatter.parse(request.getParameter("start")).getTime()));
	        obj.setEnd(new java.sql.Time(formatter.parse(request.getParameter("end")).getTime()));
	        obj.setDate(request.getParameter("date"));
	        
	        
	        
	        
	        pstmt.setInt(1, obj.getSerial());
	        pstmt.setString(2, obj.getName());
	        pstmt.setInt(3, obj.getAttendee());
	        pstmt.setDate(4, obj.getDate());
	        pstmt.setTime(5,obj.getStart());
	        pstmt.setTime(6,obj.getEnd());
	        
	        //pstmt.setDate(8, obj.getClearDate());
	        
	        pstmt.executeUpdate();
			
	       
	        
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
