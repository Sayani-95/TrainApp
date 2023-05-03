package com.sp.midTerm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.midTerm.Dao.PassengerDao;
import com.sp.midTerm.model.Passenger;


/**
 * Servlet implementation class PassengerServlet
 */
@WebServlet("/PassengerAddServlet")
public class PassengerServlet extends HttpServlet {
	PassengerDao passengerDao;

    @Override
    public void destroy() {
    	passengerDao.close();
    }

    @Override
    public void init() throws ServletException {
    	passengerDao = new PassengerDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("AddPassenger.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        passengerDao.create(new Passenger(request.getParameter("name"), request.getParameter("gender"),request.getParameter("age"),request.getParameter("email")));
        response.sendRedirect("PassengerServlet");
    }

}
