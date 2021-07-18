<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        .button {
            width: 400px;
            padding: 15px 25px;
            font-size: 24px;
            text-align: center;
            cursor: pointer;
            outline: none;
            color: #fff;
            background-color: #04AA6D;
            border: none;
            border-radius: 15px;
            box-shadow: 0 9px #999;
        }

        .button:hover {background-color: #47ba7b
        }

        .button:active {
            background-color: #0dc461;
            box-shadow: 0 5px #666;
            transform: translateY(4px);
        }

        .input{
            width: 400px;
            padding: 15px 25px;
            font-size: 24px;
            text-align: center;
            color: #fff;
            background-color: #01bf79;
            border: none;
            border-radius: 15px;
            box-shadow: 0 9px #999;
        }
    </style>
</head>
<body>

<h1 style="text-align: center; color: darkslategray;">MainApp</h1>

<button onclick="location.href='addEmployee'" class="button">Add Employee</button>
<br/><h1></h1>
<button onclick="location.href=''" class="button">update Employee</button>
<br/><h1></h1>
<spring:form method="get" modelAttribute="empJSP" action="check_all">
    <button class="button">Show all Employees</button>
</spring:form>

<spring:form method="post" modelAttribute="empJSP" action="check_id">
    <input class="input" type="number" name="employeeId" placeholder="Show Employee by Id..">
</spring:form>
<spring:form method="post" modelAttribute="empJSP" action="check_gender">
<input class="input" type="text" name="gender" placeholder="Show Employees by Gender..">
</spring:form>
<spring:form method="post" modelAttribute="empJSP" action="check_last_name">
<input class="input" type="text" name="lastName" placeholder="Show Employees by Last Name..">
</spring:form>
<spring:form method="post" modelAttribute="empJSP" action="check_job_title">
<input class="input" type="text" name="jobTitle" placeholder="Show Employees by Job Title..">
</spring:form>
<spring:form method="post" modelAttribute="empJSP" action="check_department">
    <input class="input" type="text" name="department" placeholder="Show Employees by Department..">
</spring:form>
<h1 style="text-align: left; color: darkslategray;">Delete by ID:</h1>
<spring:form method="post" modelAttribute="empJSP" action="delete_byID">
    <input style="position: fixed" class="input" type="text" name="employeeId" placeholder="Delete Employee..">
</spring:form>
</body>
</html>