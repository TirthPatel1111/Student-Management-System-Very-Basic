<%@include file="component/header.jsp"%>
<%@include file="component/navbar.jsp"%>
<%@include file="component/sessionMgt2.jsp"%>
<div class="row">
	<div class="col-md-4"></div>
	<div class="col-md-4">
		<div class="card">
			<div class="card-header">Student Login</div>
			<div class="card-body">
				<form action="autenticate" method="post">
					<table class="table table-borderless">
						<tr>
							<td><input type="text" placeholder="Enter Username"
								name="username" class="form-control" /></td>
						</tr>
						<tr>
							<td><input type="text" placeholder="Enter Password"
								name="password" class="form-control" /></td>
						</tr>
						<tr>
							<td><input type="submit" value="Login"
								class="btn btn-primary fullwidth" /></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	<div class="col-md-4"></div>
</div>
<%@include file="component/footer.jsp"%>