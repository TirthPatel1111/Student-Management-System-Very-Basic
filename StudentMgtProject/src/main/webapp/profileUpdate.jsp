<%@include file="component/header.jsp"%>
<%@include file="component/navbaraflogin.jsp"%>
<%@include file="component/sessionMgt.jsp" %>
<div class="container">
<h1>Welcome <%= authuser%></h1>
<form action="profileedit" method="post">
<table class="table table-bordered">
	<tr>
		<td>Username </td>	
		<td> <input type="text" name="usernameU" value="${student.username}"readonly> <font style="color: red;">You can't Edit Username</font> </td>	
	</tr>
	<tr>
		<td>Email </td>
		<td><input type="text" value=${student.email} name="emailU" class="form-control" /></td>
	</tr>
	<tr>
		<td>Mobile </td>
		<td><input type="text" value=${student.mobile} name="mobileU" class="form-control" /></td>
	</tr>
	<tr>
		<td>First Name </td>
		<td><input type="text" value=${student.firstname} name="firstnameU" class="form-control" /></td>
	</tr>
	<tr>
		<td>Last Name </td>
		<td><input type="text" value=${student.lastname} name="lastnameU" class="form-control" /></td>	
	</tr>
</table>
	<input type="submit" name="editprofile" value="Edit Profile"/>
</form>
</div>
<%@include file="component/footer.jsp"%>