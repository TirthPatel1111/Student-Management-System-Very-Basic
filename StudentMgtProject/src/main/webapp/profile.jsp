<%@include file="component/header.jsp"%>
<%@include file="component/navbaraflogin.jsp"%>
<%@include file="component/sessionMgt.jsp" %>
<div class="container">
<h1>Welcome <%= authuser%></h1>
<table class="table table-bordered">
	<tr>
		<td>Username </td>
		<td>${student.username}</td>		
	</tr>
	<tr>
		<td>Email </td>
		<td>${student.email}</td>		
	</tr>
	<tr>
		<td>Mobile </td>
		<td>${student.mobile}</td>		
	</tr>
	<tr>
		<td>First Name </td>
		<td>${student.firstname}</td>		
	</tr>
	<tr>
		<td>Last Name </td>
		<td>${student.lastname}</td>		
	</tr>
	
</table>
</div>
<%@include file="component/footer.jsp"%>