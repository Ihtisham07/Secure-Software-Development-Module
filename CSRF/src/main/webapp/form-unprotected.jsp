<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="uk.ac.napier.soc.ssd.csrf.token.CSRFTokenHandler" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>CSRF</title>
    <link rel="stylesheet" type="text/css" href="resources/css/styles.css" />
</head>
<body>
    <h1>CSRF: Unprotected Form</h1>

    <form action="UnprotectedChangePasswordServlet" name="changePasswordForm" method="POST">
        <table>
            <tr>
                <td colspan="2">Change your password:</td>
            </tr>
            <tr>
                <td>New Password</td>
                <td><input type="password" name="newPassword" class="text-input"></td>
            </tr>
            <tr>
                <td>Confirm Password</td>
                <td><input type="password" name="confirmPassword" class="text-input"></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><input type="submit" value="Submit"></td>
            </tr>
        </table>
    </form>
    
    <p><a href="requests-unprotected.html">Back</a></p>
</body>
</html>