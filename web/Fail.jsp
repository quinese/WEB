<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="GB2312">
    <title>Title</title>
</head>
<body>
    登录失败！1秒后返回登录页面！
<%response.setHeader("refresh","1;http://localhost:8080/WEBWEB_war_exploded/login.jsp");%>
</body>
</html>