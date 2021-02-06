package com.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ems.dao.EMSDao;

import java.sql.*;
/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/xyz")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		out.println("<h1>GET method called</h1>");
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
	
		String uid=request.getParameter("userid");
		String pass=request.getParameter("password");
		
		  EMSDao e=new EMSDao();
		    if(e.loginCheck(uid, pass))
		   {
		    	//start session
		    	HttpSession session=request.getSession();
		    	session.setAttribute("user",uid);
				response.sendRedirect("adminhome.jsp");
				
			}else
			{
			
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				request.setAttribute("msg", "Login Fail,Try again...");
				rd.forward(request,response);
			}
		
		
		
	}

}
