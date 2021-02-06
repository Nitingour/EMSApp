<%@include file="header.jsp" %>
<body>

<% 
String user=(String)session.getAttribute("user");
if(user==null)
	response.sendRedirect("index.jsp");
%>

<div class="container text-center"><h1>Create New employee Form</h1>

<%
String m=(String)request.getAttribute("msg");
if(m!=null)
{
%>
<div class="alert alert-success alert-dismissible">
  <button type="button" class="close" data-dismiss="alert">&times;</button>
  <strong>
  <% out.println(m); %>
  </strong>
</div>
<%
}
%>

<div class="row">
<div class="col-lg-4"></div>
<div class="col-lg-4 ">
<form action="./EmployeeAction" method="post">
  <div class="form-group">
    <label for="name">Name:</label>
    <input type="text" class="form-control" placeholder="Enter Name" name="ename" id="name">
  </div>
  <div class="form-group">
    <label for="salary">Salary:</label>
    <input type="number" id="salary" class="form-control" placeholder="Enter Salary" name="salary">
  </div>
<div class="form-group">
    <label for="email">Email:</label>
    <input type="email" id="email" class="form-control" placeholder="Enter Email" name="email">
  </div>
  <div class="form-group">
    <label for="address">Address:</label>
    <textarea id="address" name="address" class="form-control"></textarea>
  </div>

  
  <button type="submit" class="btn btn-primary">SAVE</button>
</form>
</div>
</div></div>



</body>
</html>