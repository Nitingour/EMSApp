<%
session.invalidate();//destroy session values
response.sendRedirect("index.jsp");
%>