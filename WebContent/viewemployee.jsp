<%@include file="header.jsp" %>

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.23/datatables.min.css"/>
 <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.23/datatables.min.js"></script>
<body>
<script>

$(document).ready( function () {
    $('#myTable').DataTable();
    
    $('#empdelete').click(function(){   

    	swal({
      	  title: "Are you sure?",
      	  text: "Once deleted, you will not be able to recover this  data!",
      	  icon: "warning",
      	  buttons: true,
      	  dangerMode: true,
      	})
      	.then((willDelete) => {
      	  if (willDelete) {
      	    swal("Poof! Your imaginary file has been deleted!", {
      	      icon: "success",
      	    });
      	  } else {
      	    swal("Your data is safe!");
      	  }
      	  
      	});
    	
    	
    });
    
    
    
    
} );

</script>
<% 
String user=(String)session.getAttribute("user");
if(user==null)
	response.sendRedirect("index.jsp");
%>

<div class="container text-center"><h1>View Employee</h1>

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


 <table class="table table-bordered" id="myTable">
    <thead>
      <tr>
        <th>EmployeeID</th>
        <th>Name</th>
        <th>Salary</th>
         <th>Email</th>
         <th>Address</th>
          <th>Creation DateTime</th>
             <th></th>
      </tr>
    </thead>
    <tbody>
 <%@page import="java.util.List,com.ems.model.Employee" %>
 <% 
    List<Employee> list=(List<Employee>) request.getAttribute("LIST"); 
 for(Employee e:list)
 {
 %>
      <tr>
        <td><%=e.getId()%></td>
        <td><% out.println(e.getEname()); %></td>
        <td><%=e.getSalary()%></td>
        <td><%=e.getEmail()%></td>
        <td><%=e.getAddress()%></td>
        <td><%=e.getCreationDate()%></td>
        <td><a id="empdelete" href="./DeleteEmployeeAction?empid=<%=e.getId()%>" class="glyphicon glyphicon-remove-sign"></td>
        
      </tr>
  <%
  } 
  %>
     
    </tbody>
  </table>



</div>

</body>
</html>