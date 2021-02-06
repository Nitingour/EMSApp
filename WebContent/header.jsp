<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<%

response.addHeader("pragma","no-cache");
response.addHeader("cache-control","no-store");
response.addHeader("expire","0");
%>
</head>
<body>
<%!String user; %>
<%
user=(String)session.getAttribute("user");
%>
<nav class="navbar navbar-inverse"  style="background:blue;color:yellow">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">EMS</a>
    </div>
    <ul class="nav navbar-nav">
    <% if(user!=null) 
    {
    %>
      <li class="active"><a href="#">Home</a></li>
      <li><a href="createnewemployee.jsp">Create Employee</a></li>
      <li><a href="./ViewEmployeeAction">View All Employee</a></li>
    <%}%>
    
    </ul>
    <ul class="nav navbar-nav navbar-right">
   
       <% if(user!=null) 
      {
      %>   <li> 
    <a href="">  Welcome,  <%
    out.println(user);
  %></a>
      </li>
      
       <li><a href="logout.jsp"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    <%}else{%>
    <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    <%} %>
    </ul>
  </div>
</nav>
  

