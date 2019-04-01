<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Course Management Service</title>
<style type="text/css">
.error {
	color: red;
}
</style>
<script type="text/javascript">
	function Validate(){
		if(document.getElementById("name").value == "" || 
				document.getElementById("name").trim().length==0){
			alert("Invalid Name...");
			return false;
		}
		var count = 0;
		var input = document.getElementById("gen").value;
		for(var i = 0; i < input.length;i++){
			if(input[i] == "radio"){
				if(input[i].checked){
					count++;
					}
				}
			}
		if(count==0){
			alert("Select gender");
			return false;
			}
	}
</script>
</head>
<body style="text-align: center">
	<h1>Course Enrollment</h1>
	<s:form action="Success.htm" method="post" modelAttribute="student">
	Student Name : 
	<s:input path="studentName" id="name"/>
		<s:errors path="studentName" cssClass="error"></s:errors>
		<br>
	Course Name :
		<s:select path="courseCode" id="cCode">
			<s:options items="${courseList}" />
		</s:select>
		<br>
	Gender :
	<s:radiobutton path="gender" value="male" id="gen"/>Male
	<s:radiobutton path="gender" value="female" id="gen"/>Female
	<s:errors path="gender" cssClass="error"></s:errors>
		<br>
	Course Type :
	<s:checkbox path="courseType" value="elearning" id="type" />Elearning
	<s:checkbox path="courseType" value="classroom" id="type" />Classroom
	<s:errors path="gender" cssClass="error"></s:errors>
		<br>
		<input type="submit" value="Enroll" onclick="return Validate()">
		<br>

	</s:form>
	<span style="color: red">${message}</span>
	<a href="student.htm">Back</a>
</body>
</html>