<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Application</title>
<link rel="stylesheet" href="css/style.css" type="text/css" />
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css" type="text/css" />
<script src="js/bootstrap.min.js">
	
</script>
<script src="js/jquery-3.2.1.min.js">
	
</script>
<script><%@include file="/WEB-INF/js/validateDate.js" %></script>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="index.jsp">University Admission
				System</a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="index.jsp">Home</a></li>
			<li><a href="viewprgrms.htm">View Programmes</a></li>
			<li class="active"><a href="apply.htm?pId">Apply Here</a></li>
			<li><a href="viewstatus.htm">View Status</a></li>
		</ul>
	</div>
	</nav>
	<form:form action="add.htm" method="post" modelAttribute="Application">
		<table align="center" class="table table-condensed"
			style="width: 50%;">
			<caption style="background-color: black; text-align: center;">
				<font color="white"><b>Enter Your Details</b></font>
			</caption>
			<tr>
				<td>Full name:</td>
				<td><form:input path="fullName" pattern="[A-Za-z ]{2,}"
						required="required" title="Enter only alphabets" /> <form:errors
						path="fullName" /></td>
			</tr>
			<tr>
				<td>Date of Birth:</td>
				<td><form:input id="dateOfBirth" path="dateOfBirth"
						required="required" placeholder="yyyy-mm-dd"
						title="Enter valid Date of Birth" /> <form:errors
						path="dateOfBirth" /></td>
			</tr>
			<tr>
				<td>Highest Qualification</td>
				<td><form:select path="highestQualification"
						items="${domainlist}" required="required"></form:select></td>
			</tr>
			<tr>
				<td>Marks Obtained:</td>
				<td><form:input path="marksObtained" minValue="0"
						maxValue="100" required="required"
						title="Enter marks between 0 and 100" /> <form:errors
						path="marksObtained" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="email"
						pattern="[A-Za-z0-9_.]{1,}[@][A-Za-z]{1,}[.]{1}[A-Za-z]{3}"
						required="required" title="Enter valid Emailid" /> <form:errors
						path="email" /></td>
			</tr>
			<tr>
				<td>Goals:</td>
				<td><form:input path="goals" required="required" /> <form:errors
						path="goals" /></td>
				<form:hidden path="status" value="Pending" />
			</tr>
			<c:if test="${pId eq null}">
				<tr>
					<td>Scheduled Program ID:</td>
					<td><form:input path="scheduledProgramId" required="required" />
						<form:errors path="scheduledProgramId" /></td>
				</tr>
			</c:if>
			<tr>
				<td colspan="2"><input class="btn btn-default" type="submit"
					value="Submit Details" onclick="return isBefore()"></td>
			</tr>
		</table>
		<c:if test="${pId ne null}">
			<form:hidden path="scheduledProgramId" value="${pId}" />
		</c:if>
		<!-- msg = scheduledProgramId passed as ModelandView attribute -->
	</form:form>
</body>
</html>