<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login and Register</title>
</head>
<body>
	<h1>Lyrics Lab</h1>
	
	<div>
	
		<div>
			<h2>Registration</h2>
			<div>
					<c:out value="${RegisterErrorMessage}"></c:out>
			</div>

			<div>
					<form method="POST" action="/registration">
				<p>
					<label for="name">Name:</label>

					<input type="text" id="name" name="name"/>
				</p>
				<p>
					<label for="lastName">Last Name:</label>

					<input type="text" id="lastName" name="lastName"/>
				</p>
				<p>
					<label for="email">Email:</label>

					<input type="text" id="email" name="email"/>
				</p>
				<p>
					<label for="password">Password:</label>

					<input type="password" id="password" name="password" />
				</p>
				<p>
					<label for="passwordConfirmation">Password Confirmation:</label>
					<input type="password" id="passwordConfirmation" name="passwordConfirmation"/>
				</p>
				<input type="submit" value="Register!"/>
				</form>
			</div>
			
		</div>
		<div>
			<h2>
				Log in
			</h2>
			<div>
				<p><c:out value="${error}" /></p>
			</div>
			<div>
				 <form method="post" action="/login">
			<p>
				<label for="email">Email</label>
				<input type="text" id="email" name="email"/>
			</p>
			<p>
				<label for="password">Password</label>
				<input type="password" id="password" name="password"/>
			</p>
			<input type="submit" value="Login!"/>
			</form>    
				
			</div>
			
		</div>
		
	</div>
	

</body>
</html>