package com.sp.midTerm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.midTerm.MainServelet;
import com.sp.midTerm.Dao.PassengerDao;
import com.sp.midTerm.model.Passenger;

/**
 * Servlet implementation class PassengerView
 */
@WebServlet("/PassengerView")
public class PassengerView extends HttpServlet {
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
        List<Passenger> passenger = passengerDao.list();
        MainServelet.redirectWithData(request, response, "passenger", passenger, "PassengerRecord.jsp");
    }
}


