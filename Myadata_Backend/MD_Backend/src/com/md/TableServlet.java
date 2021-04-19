package com.md;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.google.gson.Gson;

@WebServlet("/fetchservlet")
public class TableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String DB_URL = "jdbc:mysql://localhost/meetings";
	static final String USER = "root";
	static final String PASS = "Bablu@123";   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TableServlet() {
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
	        Statement stmt = con.createStatement();
	        String sql;
	        //sql="SELECT * FROM invoice_details";
	        sql="SELECT * FROM meeting_list ";
	      //System.out.println(request.getParameter("pages"));
	        ResultSet rs = stmt.executeQuery(sql);
	        
	        List<Pojo> invoices = new ArrayList<>();
	        
	        while(rs.next()) {
	        	Pojo obj=new Pojo();
				
	        	obj.setSerial(rs.getInt("Serial"));
		        obj.setName(rs.getString("Name"));
		        obj.setAttendee(rs.getInt("Attendee"));
		        obj.setStart(rs.getTime("Start"));
		        obj.setEnd(rs.getTime("end"));
		        obj.setDate(rs.getString("Date"));
					
				invoices.add(obj);
	        }
	        
	        Gson gson = new Gson();
	        String data = gson.toJson(invoices);
	        
	        out.print(data);
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