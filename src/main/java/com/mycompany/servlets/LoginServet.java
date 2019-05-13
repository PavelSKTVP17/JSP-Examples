package com.mycompany.servlets;

import com.mycompany.repositories.UsersRepository;
import com.mycompany.repositories.UsersRepositoryInMemoryImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServet extends HttpServlet
{
    private UsersRepository usrsRepry;
    @Override
    public void init() throws ServletException
    {
        this.usrsRepry=new UsersRepositoryInMemoryImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        if( usrsRepry.isExist(name, password))
        {
            HttpSession sess = req.getSession();
            sess.setAttribute("user", name);
            req.getServletContext().getRequestDispatcher("/home").forward(req, resp);
        }
        else
        {
            resp.sendRedirect( req.getContextPath() + "/login");
        }
    }
    
}
