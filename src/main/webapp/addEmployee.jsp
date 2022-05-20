<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee Page</title>

<style type="text/css">
	.content{
		height: 610px;
		padding: 20px;
		text-align: center;
	}
	table tr td{
		padding-bottom: 10px;
	}
	label, input, select {
		float: left;
	}
	select {
		padding: 2px;
	}
	.invalidId{
		color: red;
		position: fixed;
		top: 9%;
		left: 45.5%;
	}
</style>
</head>
<body>
	<div class="content">
		<!--<div class="invalidId">Please enter another ID!</div>-->
		<h2 style="margin-bottom: 40px;">Add Employee</h2>
		<form action="AddEmployeeServlet" method="post" style="margin: 0">
			<table style="margin: auto;">
				<tr>
					<td><label for="employee_id">Employee ID:</label></td>
					<td><input type="text" id="employee_id" name="employee_id" placeholder="Enter employee ID..." required="required"></td>
				</tr>
				<tr>
					<td><label for="fname">First name:</label></td>
					<td><input type="text" id="fname" name="fname" placeholder="Enter first name..." required="required"></td>
				</tr>
				<tr>
					<td><label for="lname">Last name:</label></td>
					<td><input type="text" id="lname" name="lname" placeholder="Enter last name..." required="required"></td>
				</tr>
				<tr>
					<td><label for="phone">Phone:</label></td>
					<td><input type="text" id="phone" name="phone" placeholder="Enter phone number..." required="required"></td>
				</tr>
				<tr>
					<td><label for="email">Email:</label></td>
					<td><input type="email" id="email" name="email" placeholder="Enter email..." required="required"></td>
				</tr>
				<tr>
					<td><label for="dob">Date of Birth:</label></td>
					<td><input type="date" id="dob" name="dob" required="required"></td>
				</tr>
				<tr>
					<td><label for="position">Position:</label></td>
					<td>
						<select name="position" id="position">
							<option value="Manager">Manager</option>
							<option value="Engineer">Engineer</option>
							<option value="Guard">Guard</option>
						</select>
					</td>
				</tr>
			</table>
			<br>
			<button style="font-size: 20px;" type="submit">Add</button>
			<button style="font-size: 20px;" type="reset">Reset</button>
		</form>
	</div>
</body>
</html>