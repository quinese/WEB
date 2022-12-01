package Filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req =(HttpServletRequest)request;
        HttpServletResponse res=(HttpServletResponse)response;
        String uri=req.getRequestURI();
        if(uri.contains("login.jsp")){
            chain.doFilter(request,response);
        }
        else {
            Object user=req.getSession().getAttribute("user");
            if(user!=null){
                chain.doFilter(request,response);
            }
            else {
                res.sendRedirect("http://localhost:8080/WEBWEB_war_exploded/login.jsp");
            }
        }
    }
}
