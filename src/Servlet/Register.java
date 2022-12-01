package Servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

import DAO.*;

@WebServlet(name = "Register", value = "/Register")
public class Register extends HttpServlet {
    public Register(){super();}
    public static void outHtml(String url,String str,String str2,HttpServletResponse response){

        PrintWriter out;
        try {
            out=response.getWriter();
            out.println(
                    "<html>"+
                            "<head>"+
                            "<meta charset='GB2312'>"+
                            "<script type='text/javascript'>alert('"+str2+"');</script>"+
                            "<head>"+
                            "<body>"+
                            "<h1>"+
                            "<center>"+
                            "<a href='"+url+"'>"+str+"</a>"+
                            "</center>"+
                            "</h1>"+
                            "<body>"+
                            "</html>"
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("GB2312");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
        request.setCharacterEncoding("UTF-8");
        String username=request.getParameter("username");
        String password = request.getParameter("password");
        String url=new Register_connect().Register(username,password),str,str2;

        if(url.equals("inputNull")){
            url="register.jsp";
            str="用户名、密码不能为空！（也不能包含空格）";
            str2="用户名、密码不能为空！（也不能包含空格）\\n确定后0.5s自动跳转";
            outHtml(url,str,str2,response);
            response.setHeader("Refresh","0.5;url=http://localhost:8080/WEBWEB_war_exploded/register.jsp");
        }else {
            if(url.equals("register.jsp")){
                url="register.jsp";
                str="用户名已经存在！重新注册！";
                str2="用户名已经存在！重新注册！\\n确定后0.5s自动跳转";
                outHtml(url,str,str2,response);
                response.setHeader("Refresh","0.5;url=http://localhost:8080/WEBWEB_war_exploded/register.jsp");
            }else if (url.equals("login.jsp")){
                url="login.jsp";
                str="恭喜！注册成功！";
                str2="恭喜！注册成功！\\确定后2s自动跳转";
                outHtml(url,str,str2,response);
                response.setHeader("Refresh","2;url=http://localhost:8080/WEBWEB_war_exploded/login.jsp");
            }else {
                url = "register.jsp";
                str = "注册失败！请重新注册";
                str2 = "注册失败！请重新注册\\n确定后2s自动跳转";
                outHtml(url, str, str2, response);
                response.setHeader("Refresh", "2;url=http://localhost:8080/WEBWEB_war_exploded/login.jsp");
            }
        }
    }
}
