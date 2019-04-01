<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Course Management Service </title>
</head>
<body style="text-align: center">
	<h1>All Course</h1>
	<table border="2" style="text-align: center">
		<tr>
			<th>Course Name</th>
			<th>Course Fees</th>
			<th>Course Type</th>
		</tr>
		<s:forEach items="${crs}" var="cr">
			<tr>
				<td><s:out value="${cr.courseName}"></s:out></td>
				<td><s:out value="${cr.courseType}"></s:out></td>
				<td><s:out value="${cr.courseFees}"></s:out></td>
			</tr>
		</s:forEach>
	</table>
	<a href="courseenrollment.htm">Enroll Course</a>
</body>
</html>