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
        <title>Login</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
   
<title>Insert</title>

	




</head>
<body>
<c:set var="bodyContent">
	<div class="container col-md-15">
		<div class="card">
			<div class="card-body">
			

			<form action=<%=request.getContextPath()%>/login method="post">
			<caption><h2>Login</h2></caption>
			
			
			
			
			
			<fieldset class="form-group">
                   <label>Username</label> 
                   <input type="text" value="" class="form-control" name="username" required="required">
            </fieldset>
            <fieldset class="form-group">
                   <label>Password</label> 
                   <input type="password" value="" class="form-control" name="password" required="required">
            </fieldset>
            <button type="submit" class="btn btn-success">Login</button>
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