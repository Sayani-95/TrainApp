package com.sp.midTerm.controller;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.midTerm.MainServelet;
import com.sp.midTerm.Dao.BookingDao;
import com.sp.midTerm.model.Booking;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookingsServlet", value = "/BookingsServlet")
public class BookingsServlet extends HttpServlet {
    BookingDao bookingDao;

    @Override
    public void destroy() {
        bookingDao.close();
    }

    @Override
    public void init() throws ServletException {
        bookingDao = new BookingDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Booking> booking = bookingDao.list();
        MainServelet.redirectWithData(request, response, "booking", booking, "bookingShow.jsp");
    }
}
