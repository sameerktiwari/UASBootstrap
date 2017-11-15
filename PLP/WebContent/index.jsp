<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Home</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/bootstrap.min.js">
</script>
    <script src="js/jquery-3.2.1.min.js">
</script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="index.jsp">University Admission System</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="index.jsp">Home</a></li>
      <li><a href="viewprgrms.htm">View Programmes</a></li>
      <li><a href="apply.htm?pId">Apply Here</a></li>
      <li><a href="viewstatus.htm">View Status</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="login.htm"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>
  
<div class="container" align="center">
  <h3>University Admission System</h3>
  <p>Web application for admissions into the university</p>            
  <img src="images/bckgrnd.jpg" class="img-rounded" alt="Cinque Terre" width="304" height="236"> 
</div>
</body>
</html>
