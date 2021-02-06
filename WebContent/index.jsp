<%@include file="header.jsp" %>

<div class="container text-center">

<%
String m=(String)request.getAttribute("msg");
if(m!=null)
{
%>
<div class="alert alert-danger alert-dismissible">
  <button type="button" class="close" data-dismiss="alert">&times;</button>
  <strong>
  <% out.println(m); %>
  </strong>
</div>
<%
}
%>


<h1>Login Form</h1>
<hr/>
<div class="row">
<div class="col-lg-4"></div>
<div class="col-lg-4 ">
<form action="./xyz" method="post">
  <div class="form-group">
    <label for="email">UserId:</label>
    <input type="text" class="form-control" placeholder="Enter email" name="userid" id="email">
  </div>
  <div class="form-group">
    <label for="pwd">Password:</label>
    <input type="password" class="form-control" placeholder="Enter password" name="password">
  </div>
  
  <button type="submit" class="btn btn-primary">Login</button>
</form>
</div>
</div>


</div>


<!-- <a href="./xyz">Call my servlet</a> -->



</body>
</html>