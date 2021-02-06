package com.ems.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.dao.EMSDao;
import com.ems.model.Employee;

/**
 * Servlet implementation class DeleteEmployeeAction
 */
@WebServlet("/DeleteEmployeeAction")
public class DeleteEmployeeAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEmployeeAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eid=request.getParameter("empid");
		EMSDao e=new EMSDao();
		int x=e.deleteEmployee(eid);
		if(x!=0)
		{
			RequestDispatcher rd=request.getRequestDispatcher("viewemployee.jsp");
			List<Employee> employeeList = e.getEmployee();
			request.setAttribute("msg", "Employee Deleted for the ID:"+eid);
			request.setAttribute("LIST", employeeList);
			rd.forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
