package com.sp.midTerm.controller;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;

import com.sp.midTerm.MainServelet;
import com.sp.midTerm.Dao.UserDao;
import com.sp.midTerm.model.*;


import java.io.IOException;


@WebServlet(name = "SignInServlet", value = "/SignInServlet")
public class SignInServlet extends HttpServlet {
    UserDao userDao;


    @Override
    public void init() throws ServletException {
        userDao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            User user = (User) userDao.read(username);
            if (!((com.sp.midTerm.model.User) user).getPassword().equals(password)) {
                MainServelet.redirectWithData(request, response, "error", "Wrong password", "index.jsp");
    
            }
            response.sendRedirect("home.jsp");
        } catch (Exception exception) {
        	MainServelet.redirectWithData(request, response, "error", "User not found", "index.jsp");
        }
    }

  

    @Override
    public void destroy() {
        userDao.close();
    }

}
