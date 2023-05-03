package com.sp.midTerm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.midTerm.MainServelet;
import com.sp.midTerm.Dao.PassengerDao;
import com.sp.midTerm.model.Passenger;


/**
 * Servlet implementation class PassengerEditServlet
 */
@WebServlet("/PassengerEditServlet")
public class PassengerEditServlet extends HttpServlet {
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
	        if (request.getParameter("id") != null) {
	            try {
	                MainServelet.redirectWithData(request, response, "passenger", passengerDao.read(Long.valueOf((request.getParameter("id")))), "EditPassenger.jsp");
	            } catch (Exception exception) {
	                response.sendRedirect("PassengerView");
	            }
	        } else {
	            response.sendRedirect("PassengerView");
	        }
	    }

	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        if (request.getParameter("id") != null) {
	            passengerDao.update(new Passenger(Long.valueOf(request.getParameter("id")),request.getParameter("name"), request.getParameter("gender"),request.getParameter("age"),request.getParameter("email")));
	        }
	        response.sendRedirect("PassengerView");
	    }

}
