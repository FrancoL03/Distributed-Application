<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>WELCOME</title>
</head>
<body>

<br/>
<a href="hello-servlet">Hello Servlet</a>

<form action="${pageContext.request.contextPath }/login" method="post">
    Email: <input type="text" name="email"><br/>
    Pssword: <input type="password" name="password"><br/>
    ID: <input type="text" name="id"><br/>
    <input type="submit" value="Login">
</form>


<a href="${pageContext.request.contextPath }/logout">logout</a>


</body>
</html>