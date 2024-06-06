package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.dao;
import dto.taskDto;
import dto.userDto;

@WebServlet("/update")
public class updateTask extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("taskid"));
		String tasktitle=req.getParameter("tasktitle");
		String taskdesc=req.getParameter("taskdesc");
		String priority=req.getParameter("taskpriority");
		String taskdate=req.getParameter("duedate");
		
		userDto u= (userDto) req.getSession().getAttribute("user");
		
		taskDto task=new taskDto(id, tasktitle, taskdesc, priority, taskdate, u.getUserId());
		
		dao d=new dao();
		
		try {
			d.updateTask(task);
			resp.sendRedirect("home.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
