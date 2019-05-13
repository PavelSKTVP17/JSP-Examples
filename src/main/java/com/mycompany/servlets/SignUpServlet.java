package com.mycompany.servlets;

import com.mycompany.models.User;
import com.mycompany.repositories.UsersRepository;
import com.mycompany.repositories.UsersRepositoryInMemoryImpl;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({"/signUp",""})
public class SignUpServlet extends HttpServlet
{
    private UsersRepository usrsRepry;
    @Override
    public void init() throws ServletException
    {
        this.usrsRepry=new UsersRepositoryInMemoryImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = usrsRepry.findAll();
        req.setAttribute("usersFromServer", users);
        RequestDispatcher disp = req.getServletContext().getRequestDispatcher("/jsp/signUp.jsp");
        disp.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        LocalDate brtDt=LocalDate.parse( req.getParameter("birthDate") );
        User usr= new User(name, password, brtDt);
        usrsRepry.save(usr);
        doGet(req,resp);
    }
}
