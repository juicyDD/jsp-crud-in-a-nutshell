<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="java.util.ArrayList" %>
<%@ page language="java" import="Model.Bean.nhanvien" %>
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
   
<title>Delete</title>

	




</head>
<body>
<c:set var="bodyContent">
<form action=<%=request.getContextPath()%>/delete method="post">
			<table class="table table-hover">
			<tr>
				<th>Staff ID</th>
				<th>Name</th>
				<th>Address</th>
				<th>Department</th>
				<th>Delete</th>
			</tr>
			<%
			ArrayList<nhanvien> nvArray=(ArrayList<nhanvien>)request.getAttribute("listNV");
			for(int i=0;i<nvArray.size();i++)
			{
			%>
			
					<tr><td><%=nvArray.get(i).getIDNV() %>
					</td><td><%=nvArray.get(i).getHoten() %>
					</td><td><%=nvArray.get(i).getDiaChi() %>
					</td><td><%=nvArray.get(i).getIDPB() %>
					</td><td>
					<!--<a href=<%=request.getContextPath()%>/delete?IDNV=<%=nvArray.get(i).getIDNV()%>>Delete</a>  -->
					<input type="checkbox" name="selected" value=<%=nvArray.get(i).getIDNV()%>> 
					</td>
					</tr>
					
			<%}%>
			</table>
<button type="submit" class="btn btn-danger" value="DeleteBtn" name ="DeleteBtn">Delete</button>
<button type="submit" class="btn btn-danger" value="DeleteAllBtn" name ="DeleteAllBtn">Delete All</button>
</form>
</c:set>


<t:shared>




    <jsp:body>
        "${bodyContent}"
    </jsp:body>
</t:shared>

</body>

</html>