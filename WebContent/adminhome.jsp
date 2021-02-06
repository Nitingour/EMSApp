<%@include file="header.jsp" %>
  
<div class="container">
  <h3>Welcome,
  <%
  String user=(String)session.getAttribute("user");
  if(user==null)
	  response.sendRedirect("index.jsp");
  out.println(user);
  %>
  </h3>
 </div>
</body>
</html>
