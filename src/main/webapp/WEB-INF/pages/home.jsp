<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Email Management Screen</title>
</head>
<body>
    <div align="center">
        <h1>Email List</h1>
        <h3>
            <a href="newEmail">New Email</a>
        </h3>
        <table border="1">

            <th>ToAddress</th>
            <th>EmailSubject</th>
            <th>EmailBody</th>
            <th>EmailSent<th>

            <c:forEach var="email" items="${listEmail}">
                <tr>
                    <td>${email.toAddress}</td>
                    <td>${email.subject}</td>
                    <td>${email.body}</td>
                    <td>${email.mailSent}</td>
                    <td><a href="editEmail?id=${email.id}">Edit</a>
                             <a href="deleteEmail?id=${email.id}">Delete</a>
                             </td>

                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>