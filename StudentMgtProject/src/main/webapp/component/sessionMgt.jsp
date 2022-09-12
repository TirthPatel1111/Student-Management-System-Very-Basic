<%
	String authuser =(String) request.getSession().getAttribute("AUTHUSER");
	if(authuser==null){
		response.sendRedirect("login.jsp");
	}
%>