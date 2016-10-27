<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="style.css" rel="stylesheet" type="text/css" />
<title>Login</title>
</head>
<body>


<form method="POST" action="myservlet">
    <table>
        <tr>
            <td>نام کاربری</td>
            <td><input type="text" name="user"></td>
        </tr>
        <tr>
            <td>گذرواژه</td>
            <td><input type="password" name="pass"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Login" >
                <input type="button" value="Register" onclick="location.href='Register.jsp'">
            </td>
        </tr>
    </table>
time is : 
<%= new Date() %>
</form>


</body>
</html>