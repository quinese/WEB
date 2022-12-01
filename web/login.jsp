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
  <!--从cookie取出用户名-->
  <%
      String Uname="";
      String Pwd="";
      Cookie cookie[]= request.getCookies();//获取cookie
      Cookie cookie1[]=request.getCookies();
      if (cookie!=null){
        for (int i=0;i<cookie.length;i++){
          if (cookie[i].getName().equals("LoginName")){
            Uname=cookie[i].getValue();
          }
        }
      }
      if (cookie1!=null){
        for (int i=0;i<cookie1.length;i++){
          if (cookie1[i].getName().equals("LoginPwd")){
            Pwd=cookie1[i].getValue();
          }
        }
      }
  %>
  <div style="text-align: center;">
    <div class="div1" id="111">
      <div class="信息门户登录">
        <p style="font-weight: bold;font-size: 30px">信息门户登录</p>
        <p style="font-weight: bold;font-size: 30px">目前在线人数：<%=(int)application.getAttribute("onlineCount")%></p>
        <p style="font-weight: bold;font-size: 30px">暂无账号？<a href="register.jsp" style="color:palegreen">立即注册</a>
      </div>
      <div class="message">
  <form action="http://localhost:8080/WEBWEB_war_exploded/login" method="post">
    <label>用户名：</label><input type="text" name="username" placeholder="请输入姓名" value=<%=Uname%>><br><br>
    <label>密码：</label><input type="password" name="password" placeholder="请输入学号" value=<%=Pwd%>><br><br>
    <input type="checkbox" name="Remember" value="Rem">记住密码
    <input type="checkbox" name="AutoLogin" value="Aut">自动登录<br><br>
    <input type="submit" value="登录">
  </form>
      </div>
    </div>
  </div>
  </body>
</html>

