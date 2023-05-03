package com.sp.midTerm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class MainServelet
 */
public class MainServelet{
	public static void redirectWithData(HttpServletRequest request, HttpServletResponse response, String name, Object object, String path) throws ServletException, IOException {
        request.setAttribute(name, object);
        request.getRequestDispatcher(path).forward(request, response);
    }
}

