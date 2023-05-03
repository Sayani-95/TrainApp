package com.sp.midTerm.controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.midTerm.MainServelet;
import com.sp.midTerm.Dao.TicketDetailsDao;
import com.sp.midTerm.model.TicketDetails;

import java.io.IOException;
import java.util.List;

@WebServlet("/TicketsServlet")
public class TicketsServlet extends HttpServlet {
    TicketDetailsDao ticketDao;

    @Override
    public void destroy() {
        ticketDao.close();
    }

    @Override
    public void init() throws ServletException {
        ticketDao = new TicketDetailsDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<TicketDetails> ticket = ticketDao.list();
        MainServelet.redirectWithData(request, response, "ticket", ticket, "TicketShow.jsp");
    }
}
