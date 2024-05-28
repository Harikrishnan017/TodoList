package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Blob;
import javax.sql.rowset.serial.SerialBlob;

import dto.taskDto;
import dto.userDto;

public class dao {
	Connection c;
	public void Connection()throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		c=DriverManager.getConnection("jdbc:mysql://localhost:3306/user?user=root&password=root");
	}
	
	//saving the user
	
	public int saveUser(userDto user) throws ClassNotFoundException, SQLException {
		Connection();
		PreparedStatement pst=c.prepareStatement("insert into userdetails values(?,?,?,?,?,?)");
		pst.setInt(1, user.getUserId());
		pst.setString(2, user.getUserName());
		pst.setString(3, user.getUserEmail());
		pst.setLong(4, user.getUserContact());
		pst.setString(5, user.getUserPassword());
		Blob image=new SerialBlob(user.getUserimage());
		pst.setBlob(6, image);
		return pst.executeUpdate();
		
	}
	
	//find by email
	
	public userDto findByEmail(String email) throws ClassNotFoundException, SQLException {
		Connection();
		PreparedStatement pst=c.prepareStatement("select * from userdetails where userEmail=?");
		pst.setString(1, email);
		
		ResultSet rst=pst.executeQuery();
		userDto u=new userDto();
		
		if(rst.next()) {
			u.setUserId(rst.getInt(1));
			u.setUserName(rst.getString(2));
			u.setUserEmail(rst.getString(3));
			u.setUserContact(rst.getLong(4));
			u.setUserPassword(rst.getString(5));
			Blob b=rst.getBlob(6);
			byte[] image=b.getBytes(1, (int)b.length());
			u.setUserimage(image);
			return u;
		}
		return null;
		
	}
	
	
	//savetask
	
	public int saveTask(taskDto t) throws ClassNotFoundException, SQLException {
		Connection();
		PreparedStatement pst=c.prepareStatement("insert into task values(?,?,?,?,?)");
		pst.setInt(1, t.getTaskid());
		pst.setString(2, t.getTaskDescription());
		pst.setString(3, t.getTaskPriority());
		Date d=Date.valueOf(t.getTaskDueDate());
		pst.setDate(4, d);
		pst.setInt(5, t.getUserId());
		return pst.executeUpdate();
		
	}
	
	//deletetask
	
	public int deleteTask(int taskid) throws ClassNotFoundException, SQLException {
		Connection();
		PreparedStatement pst=c.prepareStatement("delete from task where taskid=?");
		pst.setInt(1, taskid);
		return pst.executeUpdate();
		
	}
	
	
	//find all task
	
	public List<taskDto>findTask(taskDto t) throws ClassNotFoundException, SQLException{
		List<taskDto> taskList=new ArrayList<taskDto>();
		Connection();
		PreparedStatement pst=c.prepareStatement("select * from task");
		ResultSet rst=pst.executeQuery();
		
		taskDto task=new taskDto();
		while(rst.next()) {
			task.setTaskid(rst.getInt(1));
			task.setTaskDescription(rst.getString(2));
			task.setTaskPriority(rst.getString(3));
//			Date d=rst.getDate(4);
//			String date=d.get
			task.setUserId(rst.getInt(5));
			return taskList;
		}
		
		return null;
		
	}
	
	//update 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
