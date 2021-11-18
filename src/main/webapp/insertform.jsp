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
        <title>Insert</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
   
<title>Insert</title>

	




</head>
<body>
<c:set var="bodyContent">
	<div class="container col-md-15">
		<div class="card">
			<div class="card-body">
			
			
			<% if(request.getAttribute("user")==null) {%>
			<form action=<%=request.getContextPath()%>/insert method="post">
			<caption><h2>Insert</h2></caption>
			<fieldset class="form-group">
                   <label>Name</label> 
                   <input type="text" class="form-control" name="Hoten" required="required">
            </fieldset>
            <fieldset class="form-group">
                   <label>Department</label> 
                   <input type="text" class="form-control" name="IDPB" required="required">
            </fieldset>
            <fieldset class="form-group">
                   <label>Address</label> 
                   <input type="text" class="form-control" name="Diachi" required="required">
            </fieldset>
            
            
			<%} else {
				nhanvien nv=(nhanvien)request.getAttribute("user");
				%>
			<form action=<%=request.getContextPath()%>/update?IDNV=<%=nv.getIDNV()%> method="post">
			<caption><h2>Update</h2></caption>

			<fieldset class="form-group">
                   <label>Name</label> 
                   <input type="text" value="<%=nv.getHoten().toString() %>" class="form-control" name="Hoten" required="required">
            </fieldset>
            <fieldset class="form-group">
                   <label>Department</label> 
                   <input type="text" class="form-control" value="<%=nv.getIDPB().toString() %>" name="IDPB" required="required">
            </fieldset>
            <fieldset class="form-group">
                   <label>Address</label> 
                   <input type="text" class="form-control" value="<%=nv.getDiaChi().toString() %>"  name="Diachi" required="required">
            </fieldset>
			<% }
			
			%>
			
			
			
			

            <button type="submit" class="btn btn-success">Save</button>
            <button type="reset"  class="btn btn-danger">Reset</button>
			</form>
			</div>
		</div>
	</div>

</c:set>


<t:shared>




    <jsp:body>
        "${bodyContent}"
    </jsp:body>
</t:shared>

</body>

</html>