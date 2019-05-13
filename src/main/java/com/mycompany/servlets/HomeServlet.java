package com.mycompany.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/jsp/home.jsp").forward(req, resp);
        System.out.println("HomeServlet doGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
        String clor = req.getParameter("color");
        Cookie colorCookie = new Cookie("color",clor);
        resp.addCookie(colorCookie);
        resp.sendRedirect( req.getContextPath()+"/home" );
        System.out.println("HomeServlet doPost");
        //req.getServletContext().getRequestDispatcher("/jsp/home.jsp").forward(req, resp);
       //
        
    }
    
}
