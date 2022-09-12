<%@include file="component/header.jsp"%>
<%@include file="component/navbaraflogin.jsp"%>
<%@include file="component/sessionMgt.jsp"%>
<div class="container">
	<h1>
		Welcome
		<%=authuser%></h1>

	<table class="table table-bordered">
		<tr>
			<th>Username</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Edit</th>
			<th>Remove</th>
		</tr>

		<c:forEach var="student" items="${studentlist}">
			<tr>
				<td>${student.username}</td>
				<td>${student.firstname}</td>
				<td>${student.lastname}</td>
				<td>${student.email}</td>
				<td>${student.mobile}</tdz>
				<td><a href="profileUpdate?username=${student.username}" style="background-color:darkslateblue;" class="btn btn-primary fullwidth"   >Edit</a></td>
				<td><a href="profileDelete?username=${student.username}" style="background-color:darkslateblue;" class="btn btn-primary fullwidth"   >Remove</a></td>
			</tr>
		</c:forEach>

	</table>


</div>
<%@include file="component/footer.jsp"%>