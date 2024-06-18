package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.dao;
import dto.userDto;

@WebServlet("/updateuser")
public class updateUser extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		long contact=Long.parseLong(req.getParameter("number"));
		String password=req.getParameter("password");
		Part image=req.getPart("image");
		byte[] imagebyte=image.getInputStream().readAllBytes();
		
		
		userDto u=(userDto) req.getSession().getAttribute("task");
		
		userDto user=new userDto(u.getUserId(), name, email, contact, password, imagebyte);
		
		dao d=new dao();
		
		try {
			d.updateUser(user);
			resp.sendRedirect("profile.jsp");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
