<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="java.util.ArrayList" %>
<%@ page language="java" import="Model.Bean.*" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>List</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
   
<title>Departments</title>

	




</head>
<body>
<c:set var="bodyContent">
			<table class="table table-hover">
			<tr>
				<th>Department ID</th>
				<th>Department</th>
				<th>Description</th>
				<th>Staffs</th>
			</tr>
			<%
			ArrayList<phongban> pbArray=(ArrayList<phongban>)request.getAttribute("listPB");
			for(int i=0;i<pbArray.size();i++)
			{
			%>
			
					<tr><td><%=pbArray.get(i).getIDPB() %>
					</td><td><%=pbArray.get(i).getTenpb() %>
					</td><td><%=pbArray.get(i).getMota() %>
					</td><td>
					<a href=<%=request.getContextPath()%>/list?IDPB=<%=pbArray.get(i).getIDPB()%>>View</a>
					</td></tr>
					
			<%}%>
			</table>


</c:set>


<t:shared>




    <jsp:body>
        "${bodyContent}"
    </jsp:body>
</t:shared>

</body>

</html>