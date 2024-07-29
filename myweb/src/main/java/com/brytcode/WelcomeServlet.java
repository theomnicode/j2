package com.brytcode;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public WelcomeServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setHeader("responder", "MyWebApp");
		String username = request.getParameter("username");
		response.addHeader("Content-Type", "text/html");
		
		HttpSession  session = request.getSession();
		session.setAttribute("uname", username);
		
		out.println("Hello "+username);		
		out.println("<html><body><form action='email'>What is your email:<input type='text' name='email'/> <br/> <input type='submit' value='submit email'/></form>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		doGet(request, response);
	}

}
