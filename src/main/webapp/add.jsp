<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="errpage.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<h1>New Flight Details</h1>
	<h3>${message}</h3>
	<c:url var="myAction" value="checkFlight.do" />

	<form:form method="post" modelAttribute="flight" action="${myAction}">
		<table border="2">
			<tr>
				<td>Carrier</td>
				<td><form:select path="carrier">
						<form:option value="" label="Please Select" />
						<form:options items="${carriers}" />
					</form:select></td>
			</tr>
			<tr>
				<td>Source</td>
				<td><form:select path="source">
						<form:option value="" label="Please Select" />
						<form:options items="${cities}" />
					</form:select></td>
			</tr>
			<tr>
				<td>Destination</td>
				<td><form:select path="destination">
						<form:option value="" label="Please Select" />
						<form:options items="${cities}" />
					</form:select></td>
			</tr>
			<tr>
				<td>Distance</td>
				<td><form:input path="distance" /> 
					<form:errors path="distance" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<th colspan="2"><input type="submit" value="Add Flight"></th>
			</tr>
		</table>
	</form:form>
</body>
</html>
