<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        * {
            box-sizing: border-box;
        }

        input[type=text], select, textarea {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            resize: vertical;
        }

        input[type=date], select, textarea {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            resize: vertical;
        }

        input[type=number], select, textarea {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            resize: vertical;
        }

        label {
            padding: 12px 12px 12px 0;
            display: inline-block;
        }

        input[type=submit] {
            background-color: #04AA6D;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            float: right;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }

        .container {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
        }

        .col-25 {
            float: left;
            width: 25%;
            margin-top: 6px;
        }

        .col-75 {
            float: left;
            width: 75%;
            margin-top: 6px;
        }

        /* Clear floats after the columns */
        .row:after {
            content: "";
            display: table;
            clear: both;
        }

        /* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
        @media screen and (max-width: 600px) {
            .col-25, .col-75, input[type=submit] {
                width: 100%;
                margin-top: 0;
            }
        }
    </style>
</head>
<body>

<h2>Update Employee by id</h2>

<div class="container">

    <form action="updateEmp" method="post">

        <div class="row">
            <div class="col-25">
                <label for="id">ID: ${empJSP.employeeId}</label>
            </div>
            <div class="col-75">
                <input id="id" type="hidden" name="employeeId" value="${empJSP.employeeId}">
        </div>
    </div>

        <div class="row">
                <div class="col-25">
                    <label for="fname">First Name: </label>
                </div>

                <div class="col-75">
                    <input type="text" id="fname" name="firstName" value="${empJSP.firstName}">
                </div>
            </div>

            <div class="row">
                <div class="col-25">
                    <label for="lname">Last Name: </label>
                </div>
                <div class="col-75">
                    <input type="text" id="lname" name="lastName" value="${empJSP.lastName}">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="gender">Gender</label>
                </div>
                <div class="col-75">
                    <select id="gender" name="gender">
                        <option value="MALE">Male</option>
                        <option value="FEMALE">Female</option>
                    </select>
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="dep">Department </label>
                </div>
                <div class="col-75">
                    <input type="number" id="dep" name="department" value="0">
                </div>
            </div>


            <div class="row">
                <div class="col-25">
                    <label for="job">Job Title: </label>
                </div>
                <div class="col-75">
                    <input type="text" id="job" name="jobTitle" value="${empJSP.jobTitle}">
                </div>
            </div>


            <div class="row">
                <div class="col-25">
                    <label for="date">Birthday: ${empJSP.dateOfBirth}</label>
                </div>
                <div class="col-75">
                    <input type="date" id="date" name="dateOfBirth" value="0001-01-01">

                </div>
            </div>
            <div class="row">
                <input type="submit" value="Submit">
            </div>
    </form>
</div>

</body>
</html>