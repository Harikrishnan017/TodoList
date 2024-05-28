package dto;

public class userDto {
	private int userId;
	private String userName;
	private String userEmail;
	private long userContact;
	private String userPassword;
	private byte[] userimage;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public long getUserContact() {
		return userContact;
	}
	public void setUserContact(long userContact) {
		this.userContact = userContact;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public byte[] getUserimage() {
		return userimage;
	}
	public void setUserimage(byte[] userimage) {
		this.userimage = userimage;
	}

}
