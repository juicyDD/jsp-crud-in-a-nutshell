<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta charset="UTF-8">
    
    <%@tag description="Simple Wrapper Tag" pageEncoding="UTF-8"%>
    <style>
        .vertical-menu {

width: 200px;
height: 150px;
font-family:Arial;
display:inline-block;
}

.vertical-menu a {
background-color: white;
color: black;
display: block;
padding: 10px;
margin:0px;
text-decoration: none;
}
.vertical-menu nav {

font-weight: bold;
background-color: white;
color:#00008B;
display: block;
padding: 10px;
margin:10px;
text-decoration: none;
}

.vertical-menu a:hover {
background-color: #ccc;
}

.vertical-menu a.active {
background-color: grey;
color: white;
}

    </style>
</head>

<body>

    <header>
    	<nav style="width:100%; height:30px;display:inline-block;background-color: white; ">
    	<%if(request.getAttribute("authorized")==null) {%>
    	<table style="width:100%">
    		<tr style="height:10px"></tr>
    		<tr><td style="width:90%"><td><a href=<%=request.getContextPath()%>/login><pre class="tab">Login</pre></a></td></tr>
    	</table>
    	<%} else { %>
    	<table style="width:100%">
    		<tr><td style="width:75%"><td>Hello @ <%=request.getAttribute("username").toString() %></td></tr>
    	</table>
    	<%} %>
    	
    	</nav>
        <nav style="width:100%; height:170px;display:inline-block;background-color: white; ">
        <br></br>
        
        
           <h1 style="float:right;"><pre class="tab">Staffs Management         </pre> </h1>
           <br></br>
           <hr>
        </nav>
     </header>
 


    <nav style="width:15%; height: 70%; display: inline-block; float:left;background-color: white;" >
        <div></div>
        <div class="vertical-menu" style="width:100%; height: 100%; display: inline-block;color: #white; ">
            <nav></nav>
          <a style="color:black;font-weight:bold" href=<%=request.getContextPath()%>/ target=_self selected >Staffs</a>
          <a href=<%=request.getContextPath()%>/insert  target=_self>Insert</a>
          <a href=<%=request.getContextPath()%>/search target=_self>Search </a>
          <a href=<%=request.getContextPath()%>/updatelist target=_self>Update</a>
          <a href=<%=request.getContextPath()%>/deletelist target=_self>Delete</a>
          <a href=<%=request.getContextPath()%>/department/ target=_self>Departments</a>
          
        </div>
    </nav>
    <nav style="width: 65%; height:70%;display: inline-block; background-color: white" > 
        
        
        <div id="nhi"><jsp:doBody/></div>
        
    </nav>  
    <nav style="width:19%; height: 70%; display:inline-block;background-color: white; float:right ">
        
     
 
  </nav>
<nav style="width:100%; height:30%; display:inline-block;background-color: white; float:right ">
 

</nav>



</body>