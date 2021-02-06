package com.ems.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.dao.EMSDao;
import com.ems.model.Employee;

/**
 * Servlet implementation class EmployeeAction
 */
@WebServlet("/EmployeeAction")
public class EmployeeAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ename=request.getParameter("ename");
		String salary=request.getParameter("salary");
		String address=request.getParameter("address");
		String email=request.getParameter("email");
	
		Employee e=new Employee();
		e.setEname(ename);
		e.setAddress(address);
		e.setSalary(Integer.parseInt(salary));
		e.setEmail(email);
		EMSDao emsDao=new EMSDao();
		int x = emsDao.insertEmployee(e);
		if(x!=0)
		{
			RequestDispatcher rd=request.getRequestDispatcher("createnewemployee.jsp");
			request.setAttribute("msg", "Employee Account Created");
			rd.forward(request,response);
		}
		
		
		
		
	}

}
