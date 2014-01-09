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
<!-- Start Wrapper -->
<div id="wrapper">
  <div id="login">
    <div class="login_logo"> <img src="images/bhargav.jpg" width="431" height="75" alt="" /> </div>
    <div class="clear"></div>
    <div class="login_box">
    	<span>
    		<c:choose>
    			<c:when test="${not empty msg}">
    				<font size="2px"> ${msg} </font>
    			</c:when>
    			<c:otherwise>
    				<font color="Blue" size="2px"> 
    					Enter  Your Login Details..
    				</font> 		
    			</c:otherwise>
    		</c:choose>
    	</span>
    	 <%-- <span>
    	 	<form:errors path="username" element="span" cssStyle="height: auto;color: red;text-align: left;padding: 0px 0 0px;" /><br>
    	 	<form:errors path="password" element="span" cssStyle="height: auto;color: red;text-align: left;padding: 0px 0 0px;" />
		</span> --%>
		
      <div class="lgn_lft">
        <div class="t_box">
          <label >Username</label>
          <c:choose>
          	<c:when test="${not empty user_field}">
          		<form:input path="username" cssStyle="background-image:url(images/username_bg1.png);" />
          	</c:when>
          	<c:otherwise>
          		<form:input path="username" cssStyle="background-image:url(images/username_bg.png);" />
          	</c:otherwise>
          </c:choose>
          
        </div>
        <div class="t_box">
          <label>Password</label>
          <c:choose>
          	<c:when test="${not empty password_field}">
          		<form:password path="password" cssStyle="background-image:url(images/passwrod_bg1.png); " />
          	</c:when>
          	<c:otherwise>
				<form:password path="password" cssStyle="background-image:url(images/passwrod_bg.png); " />
          	</c:otherwise>
          </c:choose>
        </div>
      </div>
      <div class="lgn_rft">
        <!-- <input type="button" onclick="window.location = 'dashboard.html';" /> -->
        
		<input type="submit" value="login" class="mn_btn" />
      </div>
      <div class="clear"></div>
      <a href="#" class="fp">Forgot your password?</a> </div>
  </div>
</div>
<!-- End Wrapper -->
</form:form>
</body>
</html>




<%-- <html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
	</head>

	<body>
		<form:form modelAttribute="Users" action="save.action">
			<table align="center">
				<c:if test="${not empty msg}">
					<tr>
						<td colspan="2">${msg}</td>
					</tr>
				</c:if>
				<tr>
					<th>Username : </th>
					<td>
						<form:input path="username" />
						<form:errors path="username" element="span" cssStyle="height: auto;color: red;text-align: left;padding: 0px 0 0px;" />	
					</td>
				</tr>
				<tr>
					<th>Password : </th>
					<td>
						<form:password path="password" />
						<form:errors path="password" element="span" cssStyle="height: auto;color: red;text-align: left;padding: 0px 0 0px;" />
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="Login"/>
					</td>
				</tr>
			</table>	
		</form:form>
	</body>
</html> --%>