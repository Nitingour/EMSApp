package com.ems.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ems.model.Employee;

public class EMSDao {

	private Connection startConnection()
	{
		Connection con=null;
		 try {
				Class.forName("com.mysql.jdbc.Driver");
				 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb","root","");
		 }catch(ClassNotFoundException | SQLException e)
			 {
				 System.out.println(e);
			 }
		return con;
	}
	
	
	
	public boolean loginCheck(String uid,String pass)
	{
		boolean isMatched=false;
	
				try(Connection con=startConnection()){
				PreparedStatement ps=con.prepareStatement("select * from login where uid=? and password=?");
			   ps.setString(1, uid);
			   ps.setString(2, pass);
			   ResultSet rs=ps.executeQuery();
			   if(rs.next())
				   isMatched=true;
				}catch(SQLException e)
				{
					System.out.println(e);
				}
				
		return isMatched;
	}
	
	public int insertEmployee(Employee emp)
	{
		int x=0;
		 
		try(Connection con=startConnection())
		     {
			   PreparedStatement ps=con.prepareStatement("insert into Employee(ename,salary,address,password,email) values(?,?,?,?,?)");
			   ps.setString(1,emp.getEname());
			   ps.setInt(2, emp.getSalary());
			   ps.setString(3,emp.getAddress());
			 
			   String s=System.currentTimeMillis()+"";//483578347698347
			   String pwd=s.substring(8);
			   ps.setString(4,pwd);
			   ps.setString(5,emp.getEmail());
			    x=ps.executeUpdate();
				}catch(SQLException e)
				{
					System.out.println(e);
				}
				
		return x;
	}
	
	
	public List<Employee>   getEmployee()
			{
		List<Employee> list=new ArrayList<>();
		try(Connection con=startConnection())
	     {
		   PreparedStatement ps=con.prepareStatement("Select * from Employee");
		   ResultSet rs=ps.executeQuery();
		   while(rs.next())
		   {
			   Employee e=new Employee();
			   e.setId(rs.getInt("id"));
			   e.setEname(rs.getString("ename"));
			   e.setAddress(rs.getString("address"));
			   e.setCreationDate(rs.getString("creationdate"));
			   e.setEmail(rs.getString("email"));
			   e.setSalary(rs.getInt("salary"));
			   list.add(e);
		   }
			   
			}catch(SQLException e)
			{
				System.out.println(e);
			}
			
		return list;
			}
	
	public int deleteEmployee(String empid)
	{
		int x=0;
		 
		try(Connection con=startConnection())
		     {
			   PreparedStatement ps=con.prepareStatement("delete from employee where id=?");
			   ps.setInt(1,Integer.parseInt(empid));
			    x=ps.executeUpdate();
				}catch(SQLException e)
				{
					System.out.println(e);
				}
				
		return x;
	}
}
