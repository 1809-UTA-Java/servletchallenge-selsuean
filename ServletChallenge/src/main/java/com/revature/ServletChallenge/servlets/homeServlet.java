package com.revature.ServletChallenge.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/home")
public class homeServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = "limsuean";
		String password = "password";

		PrintWriter pw = resp.getWriter();
		String arg1 = req.getParameter("name");
		String arg2 = req.getParameter("password");
		
		
		if (arg1.equals(username) && arg2.equals(password)) {
			HttpSession session = req.getSession();
			session.setAttribute(username, "developer");
			pw.println("Hello " + arg1 + "!");
			pw.close();
		} else {
			resp.sendRedirect("login");
		}
	}
}
