package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.dao;
import dto.userDto;

@WebServlet("/login")
public class userLogin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		dao d=new dao();
		
		try {
			userDto u=d.findByEmail(email);
			
			if(u!=null) {
				if(u.getUserPassword().equals(password)) {
					HttpSession session=req.getSession();
					session.setAttribute("user", u);
					req.getRequestDispatcher("home.jsp").forward(req, resp);
				}
				else {
					req.setAttribute("message", "* Incorrect password");
					req.getRequestDispatcher("login.jsp").forward(req, resp);
				}
			}
				else{
					req.setAttribute("message", "* Incorrect email");
					req.getRequestDispatcher("login.jsp").forward(req, resp);
					
				}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
