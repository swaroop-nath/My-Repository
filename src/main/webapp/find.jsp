<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="errpage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="navbar.jsp" />
<form action="find.do">
Enter Flight ID: <input name="id"> <input type="submit" value="Search">
</form>
<hr>
Carrier: ${flight.carrier}<br>
Source: ${flight.source}<br>
Destination: ${flight.destination}<br>
Distance: ${flight.distance}
</body>
</html>
