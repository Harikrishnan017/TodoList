package dto;

public class taskDto {
	private int taskid;
	private String taskTitle;
	private String taskDescription;
	private String taskPriority;
	private String taskDueDate;
	private int userId;
	
	public taskDto(int taskid, String taskTitle, String taskDescription, String taskPriority, String taskDueDate,
			int userId) {
		super();
		this.taskid = taskid;
		this.taskTitle = taskTitle;
		this.taskDescription = taskDescription;
		this.taskPriority = taskPriority;
		this.taskDueDate = taskDueDate;
		this.userId = userId;
	}
	
	public taskDto() {

	}

	public int getTaskid() {
		return taskid;
	}
	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	public String getTaskPriority() {
		return taskPriority;
	}
	public void setTaskPriority(String taskPriority) {
		this.taskPriority = taskPriority;
	}
	public String getTaskDueDate() {
		return taskDueDate;
	}
	public void setTaskDueDate(String taskDueDate) {
		this.taskDueDate = taskDueDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTaskTitle() {
		return taskTitle;
	}
	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}
	
	
	

}
