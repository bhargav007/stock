<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login</title>
<link href="css/style.css" type="text/css" rel="stylesheet" />
</head>

<body background="blue">
<form:form modelAttribute="Users" action="save.action">
  <div id="login_page">
    <div class="in_box">
      <form:label path="username">User Name</form:label>
      <form:input type="text" path="username" class="m_input" ></form:input>
    </div>
    <div class="in_box">
      <form:label path="password">Password</form:label>
      <form:input type="password" path="password"  class="m_input"/>
    </div>
    <center>
      <input id="login" type="submit" value="Log In" style="margin-top:15px;" />
    </center>
  </div>
</form:form>
</body>
</html>