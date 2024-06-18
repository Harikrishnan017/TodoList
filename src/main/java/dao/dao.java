package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.text.DateFormat;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
	
	
	//save task
	
	public int saveTask(taskDto t) throws ClassNotFoundException, SQLException {
		Connection();
		PreparedStatement pst=c.prepareStatement("insert into task values(?,?,?,?,?,?)");
		pst.setInt(1, t.getTaskid());
		pst.setString(2, t.getTaskTitle());
		pst.setString(3, t.getTaskDescription());
		pst.setString(4, t.getTaskPriority());
		Date d=Date.valueOf(t.getTaskDueDate());
		pst.setDate(5, d);
		pst.setInt(6, t.getUserId());
		return pst.executeUpdate();
		
	}
	
	//delete task
	
	public int deleteTask(int taskid) throws ClassNotFoundException, SQLException {
		Connection();
		PreparedStatement pst=c.prepareStatement("delete from task where taskid=?");
		pst.setInt(1, taskid);
		return pst.executeUpdate();
		
	}
	
	//update task
	
	public int updateTask(taskDto t) throws ClassNotFoundException, SQLException {
		Connection();
		PreparedStatement pst=c.prepareStatement("update task set taskTitle=?, taskDescription=?, taskPriority=?,taskDuedate=?,userId=? where taskid=?");
		
		pst.setString(1, t.getTaskTitle());
		pst.setString(2, t.getTaskDescription());
		pst.setString(3, t.getTaskPriority());
		Date d=Date.valueOf(t.getTaskDueDate());
		pst.setDate(4, d);
		pst.setInt(5, t.getUserId());		
		pst.setInt(6, t.getTaskid());

		return pst.executeUpdate();
		
	}
	
	
	//find all task
	
	public List<taskDto> findTask(int userId) throws ClassNotFoundException, SQLException{
		List<taskDto> taskList=new ArrayList<taskDto>();
		Connection();
		PreparedStatement pst=c.prepareStatement("select * from task where userId=?");
		pst.setInt(1, userId);
		ResultSet rst=pst.executeQuery();
	
		while(rst.next()) {
			taskDto tasks=new taskDto(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getInt(6));
			taskList.add(tasks);
		}
		return taskList;
	} 
	
	//find task based on id
	
	public taskDto findbyid(int Id) throws ClassNotFoundException, SQLException{
		Connection();
		PreparedStatement pst=c.prepareStatement("select * from task where taskid=?");
		pst.setInt(1, Id);
		ResultSet rst=pst.executeQuery();
		taskDto tasks=new taskDto();
		while(rst.next()) {
			tasks=new taskDto(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getInt(6));
		}
		return tasks;
	} 
	
	// find user based on id
	
	public userDto findusingid(int Id) throws ClassNotFoundException, SQLException{
		Connection();
		PreparedStatement pst=c.prepareStatement("select * from userdetails where userId=?");
		pst.setInt(1, Id);
		ResultSet rst=pst.executeQuery();
		userDto users=new userDto();
		while(rst.next()) {
			users=new userDto(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getLong(4), rst.getString(5), rst.getBytes(6));
		}
		return users;
	} 
	
	
	// update user
	

	public int updateUser(userDto user) throws ClassNotFoundException, SQLException {
		Connection();
		PreparedStatement pst=c.prepareStatement("update userdetails set Username=?, UserEmail=?,UserContact=?,UserPassword=?,UserImage=? where UserId=? ");
		
		pst.setString(1, user.getUserName());
		pst.setString(2, user.getUserEmail());
		pst.setLong(3, user.getUserContact());
		pst.setString(4, user.getUserPassword());
		Blob image=new SerialBlob(user.getUserimage());
		pst.setBlob(5, image);
		pst.setInt(6, user.getUserId());
		return pst.executeUpdate();
		
	}
	
	
}
