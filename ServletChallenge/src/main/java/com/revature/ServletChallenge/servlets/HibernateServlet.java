package com.revature.ServletChallenge.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.revature.ServletChallenge.models.Users;
import com.revature.ServletChallenge.repository.HibernateDAO;
import com.revature.ServletChallenge.util.HibernateUtil;


public class HibernateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public HibernateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    List<Users> users;
    HibernateDAO dao = new HibernateDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//users = dao.getUsers();
		
		response.setContentType("text/xml");

		ObjectMapper om = new XmlMapper();
		//String obj = om.writeValueAsString(users);
		String obj = om.writeValueAsString(dao.getUserByName("suean"));
		PrintWriter pw = response.getWriter();
		pw.print(obj);
		pw.close();
		
	}
	
	
	
	//so when server stops, so will also destroy session 
	public void destroy() {
		HibernateUtil.shutdown();
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper om = new XmlMapper();
		Users postUser = (Users) om.readValue(request.getInputStream(), Users.class);
		PrintWriter pw = response.getWriter();
		pw.print(dao.saveAnimal(postUser));
		pw.close();
	}

}
