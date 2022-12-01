<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style type="text/css">
        .div1{border: solid 2px}
        .message{padding-top: 130px;}
    </style>
</head>
<body>
<div style="text-align: center;">
    <div class="div1" id="111">
        <div class="信息门户注册">
            <p style="font-weight: bold;font-size: 30px">信息门户注册</p>
        </div>
        <div class="message">
            <form action="http://localhost:8080/WEBWEB_war_exploded/Register" method="post">
                <label>用户名：</label><input type="text" name="username" placeholder="请输入姓名"><br><br>
                <label>密码：</label><input type="password" name="password" placeholder="请输入学号"><br><br>
                <input type="submit" value="注册">
                <input type="reset">
            </form>
        </div>
    </div>
</div>
</body>
</html>

