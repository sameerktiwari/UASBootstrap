<%--  
 ***************************************************************************************
 * Description  :   View Application which is submitted for a scheduled Program.
 * Functionality: It is a jsp page which will show the Application list for a 
 * 					scheduled program. This file should be accessible to MAC and 
 *					administrator only.
 * Models Used : UASController.java, Participant.java,Application.java
 * Restrictions: 
 * Creation date: (09/11/2017)
 * Modifications:
 * Author: Group5       Date: 14-Nov-2017         Change Description:
 ************************************************************************************** --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Applications</title>
<link rel="stylesheet" href="css/style.css" type="text/css" />
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css" type="text/css" />
<script src="js/bootstrap.min.js">
	
</script>
<script src="js/jquery-3.2.1.min.js">
	
</script>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="index.htm">University Admission
				System</a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="returnHome.htm">Home</a></li>
			<li class="active"><a href="viewprgrms.htm">View Programmes</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="login.htm"><span class="glyphicon glyphicon-log-in"></span>
					MAC(Logout)</a></li>
		</ul>
	</div>
	</nav>
	<table align="center" class="table table-condensed" style="width: 60%;">
		<caption style="background-color: black; text-align: center;">
			<font color="white"><b>Programmes Scheduled for the Winter
					Session</b></font>
		</caption>
		<tr>
			<th>Application ID</th>
			<th>Full Name</th>
			<th>Date of Birth</th>
			<th>Highest Qualification</th>
			<th>Marks Obtained</th>
			<th>Email</th>
			<th>Goals</th>
			<th>Scheduled Programme ID</th>
			<th>Status</th>
			<th>Date of Interview</th>
			<th></th>
		</tr>
		<c:forEach items="${appList}" var="appli">
			<form:form action="viewApplication.htm" method="post"
				modelAttribute="Application">
				<tr>
					<td><form:hidden path="applicationId"
							value="${appli.applicationId}" /> ${appli.applicationId}</td>
					<td><form:hidden path="fullName" value="${appli.fullName}" />${appli.fullName}</td>
					<td><form:hidden path="dateOfBirth"
							value="${appli.dateOfBirth}" />${appli.dateOfBirth}</td>
					<td><form:hidden path="highestQualification"
							value="${appli.highestQualification}" />${appli.highestQualification}</td>
					<td><form:hidden path="marksObtained"
							value="${appli.marksObtained}" />${appli.marksObtained}</td>
					<td><form:hidden path="email" value="${appli.email}" />${appli.email}</td>
					<td><form:hidden path="goals" value="${appli.goals}" />${appli.goals}</td>
					<td><form:hidden path="scheduledProgramId"
							value="${appli.scheduledProgramId}" />${appli.scheduledProgramId}</td>
					<td><form:hidden path="status" value="${appli.status}" />${appli.status}</td>
					<td><form:hidden path="dateOfInterview"
							value="${appli.dateOfInterview}" />${appli.dateOfInterview}</td>
					<td><input class="btn btn-default" type="submit"
						value="View Application"></td>
				</tr>
			</form:form>
		</c:forEach>
	</table>
</body>
</html>