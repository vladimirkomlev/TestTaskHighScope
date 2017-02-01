<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h3>Enter your login and password, please.</h3>
    <br>
    <s:form action="LoginAction" method="POST">
        <s:textfield name="login" lable="Login"/>
        <s:password name="password" label="Password"/>
        <s:submit value="LogIn"/>
    </s:form>
    <br>
</body>
</html>
