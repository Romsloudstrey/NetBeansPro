/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author prjro
 */
@WebFilter({"/admin/*"})
public class AdminFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest re=(HttpServletRequest) request;
    HttpServletResponse res=(HttpServletResponse) response;
    HttpSession session=re.getSession(false);
        if(re.getRequestURI().endsWith(".jsp")){
            res.sendError(404);
        }
        else{
           chain.doFilter(request,response); 
        }
//        if(session!=null&&session.getAttribute("username")!=null&&session.getAttribute("password")!=null){
//            chain.doFilter(request, response);
//        }
//        else{
//            res.sendRedirect(re.getContextPath()+"/admin-login");
//        }
    }

    @Override
    public void destroy() {
    
    }
    
}
