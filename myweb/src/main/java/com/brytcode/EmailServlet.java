package com.brytcode;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class EmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public EmailServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String email = request.getParameter("email");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String username = session.getAttribute("uname").toString();
		out.println("Hello "+ username + " your email is "+email);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
