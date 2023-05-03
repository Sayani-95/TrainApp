package com.sp.midTerm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.midTerm.Dao.BookingDao;
import com.sp.midTerm.Dao.PassengerDao;
import com.sp.midTerm.Dao.TicketDetailsDao;
import com.sp.midTerm.model.Booking;
import com.sp.midTerm.model.Passenger;
import com.sp.midTerm.model.TicketDetails;


/**
 * Servlet implementation class BookingAddServlet
 */
@WebServlet("/BookingAddServlet")
public class BookingAddServlet extends HttpServlet {
	BookingDao bookingDao;
    PassengerDao passengerDao;
    TicketDetailsDao ticketDao;

    @Override
    public void destroy() {
        bookingDao.close();
    }

    @Override
    public void init() throws ServletException {
        bookingDao = new BookingDao();
        passengerDao = new PassengerDao();
        ticketDao = new TicketDetailsDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Passenger> passenger = passengerDao.list();
        List<TicketDetails> ticket = ticketDao.list();
        if (passenger.isEmpty()) {
            response.sendRedirect("PassengerServlet");
        } else if (ticket.isEmpty()) {
            response.sendRedirect("TicketAddServlet");
        } else {
            request.setAttribute("passenger", passenger);
            request.setAttribute("ticket", ticket);
            request.getRequestDispatcher("booking-create.jsp").forward(request, response);
        }
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        bookingDao.create(new Booking(( new Passenger(Long.valueOf(request.getParameter("passenger")), null, null, null, null), new TicketDetails(Long.valueOf(request.getParameter("ticket")), request.getParameter("seatType")))));
//        response.sendRedirect("BookingsServlet");
//    }

}
