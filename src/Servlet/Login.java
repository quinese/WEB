package Servlet;


import DAO.Login_connect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "Servlet.Login")
public class Login extends HttpServlet {
    public Login(){
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkbox = request.getParameter("Remember");
        PrintWriter out=response.getWriter();
        if (new Login_connect().login(username, password).equals("next/success.jsp")){
            //选择是否记住密码
            if (checkbox!=null){
                int initCookie=1;
                Cookie[] cookies=request.getCookies();
                if(cookies!=null){//检测cookie是否为空
                    for(int i=0;i<cookies.length;i++){
                        Cookie cookie=cookies[i];
                        if("loginName".equals(cookie.getName())||"LoginPwd".equals(cookie.getName())){
                            initCookie=0;
                        }
                    }
                }
                if(initCookie==1) {
                    HttpSession session=request.getSession();
                    session.setAttribute("user",username);
                    Cookie cookie = new Cookie("LoginName", username);
                    Cookie cookie1 = new Cookie("LoginPwd", password);
                    cookie.setMaxAge(30 * 24 * 60 * 60);//有效期为一个月
                    cookie1.setMaxAge(30 * 24 * 60 * 60);
                    response.addCookie(cookie);//放置cookie于客户端
                    response.addCookie(cookie1);
                }
            }
            else {
                //删除cookie
                HttpSession session=request.getSession();
                session.setAttribute("user",username);
                Cookie cookie=new Cookie("LoginName",username);
                Cookie cookie1= new Cookie("LoginPwd",password);
                cookie.setMaxAge(0);//删除cookie
                cookie1.setMaxAge(0);
                response.addCookie(cookie);//放置cookie于客户端
                response.addCookie(cookie1);
            }
            out.println(
                    "<html>"+
                    "<head>"+
                    "<meta charset='GB2312'>"+
                    "<script type='text/javascript'>alert('用户名密码正确，登录成功!\\n确定后2秒跳转');</script>"+
                    "</head>"+
                    "<body>"+
                    "<h1>"+
                    "<center>"+
                    "<h2>恭喜你登录成功！</h2>"+
                    "</center>"+
                    "</h1>"+
                    "</body>"+
                    "</html>");

            response.setHeader("Refresh","2;url=http://localhost:8080/WEBWEB_war_exploded/next/success.jsp");
        }
        else {
            out.println(
                    "<html>"+
                    "<head>"+
                    "<meta charset='GB2312'>"+
                    "<script type='text/javascript'>alert('用户名或密码错误!\\n确定后2秒重新登录');</script>"+
                    "</head>"+
                    "<body>"+
                    "<h1>"+
                    "<center>"+
                    "<h2>用户名或密码错误!</h2>"+
                    "</center>"+
                    "</h1>"+
                    "</body>"+
                    "</html>");

            response.setHeader("Refresh","2;url=http://localhost:8080/WEBWEB_war_exploded/login.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("GB2312");
    }
}
