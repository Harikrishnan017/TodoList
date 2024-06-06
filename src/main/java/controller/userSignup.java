package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.dao;
import dto.userDto;

@WebServlet("/signup")
@MultipartConfig(maxFileSize = 5*1024*1024)
public class userSignup extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		long contact=Long.parseLong(req.getParameter("contact"));
		String password=req.getParameter("password");
		Part image=req.getPart("image");
		byte[] imagebyte=image.getInputStream().readAllBytes();
		
		userDto u=new userDto(id, name, email, contact, password, imagebyte);
		dao d=new dao();
		
		try {
			d.saveUser(u);
			resp.sendRedirect("login.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
