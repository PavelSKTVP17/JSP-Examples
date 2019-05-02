
package com.mycompany.filters;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/home")
public class AuthFilter implements Filter
{
    @Override
    public void init(FilterConfig fc) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest reqst=(HttpServletRequest)sr;
        HttpServletResponse respn=(HttpServletResponse)sr1;
        
        HttpSession sess = reqst.getSession(false);
        
        if(sess==null  || sess.getAttribute("user") == null )
        {
            sr.getServletContext().getRequestDispatcher("/login").forward(sr, sr1);
        }
        fc.doFilter(sr, sr1);
    }

    @Override
    public void destroy() {
        
    }
    
}
