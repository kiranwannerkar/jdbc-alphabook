package com.ty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.Scanner;

public class SocialMedia {

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void userLogin(User user) {

	}
	public void signUp(User user) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
		String query="INSERT INTO user VALUE(?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement=connection.prepareStatement(query);

		preparedStatement.setInt(1,user.getId());
		preparedStatement.setString(2,user.getFirstName());
		preparedStatement.setString(3,user.getLastName());
		preparedStatement.setString(4,user.getGender());
		preparedStatement.setLong(5,user.getContactNumber());
		preparedStatement.setString(6,user.getDateOfBirth());
		preparedStatement.setString(7,user.getEmailId());
		preparedStatement.setString(8,user.getPassword());
		preparedStatement.setString(9,user.getStatus());

		preparedStatement.execute();
		connection.close();
		System.out.println(" SignUp Successful");
	}
	public void LoginUser(String emailID, String password, User user) throws Exception
	{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
		String query="Select * from user where emailId = ? and password = ?";
		PreparedStatement ps=connection.prepareStatement(query);
		ps.setString(1, user.getEmailId());
		ps.setString(2, user.getPassword());
		ResultSet  rs= ps.executeQuery();

		String pwd="";
		String emaild="";

		while(rs.next())
		{
			emaild=rs.getString(7);
			pwd=rs.getString(8);
		}

		if((emaild.equals(user.getEmailId()) && pwd.equals(user.getPassword())))
		{
			System.out.println("Login is Successfull ");
			Scanner scanner= new Scanner(System.in); 
			System.out.println("Do you want to update Status------->>\n1:Yes\n2:No");
			int status=scanner.nextInt();
			if(status==1)
			{
				SocialMedia social= new SocialMedia();
				social.status(emaild);

			}
			else
			{
				System.out.println("****************Status not added *****************");
			}
		}
		else
		{
			System.out.println("******Invalid Id or Password*****");
		}
		connection.close();
	}
	public void status(String email) throws Exception
	{
		Scanner scanner=new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
		String query= "update user set status=? where emailId=?";
		PreparedStatement preparedStatement2= connection.prepareStatement(query);
		System.out.println("Enter the status");
		String status1=scanner.nextLine();
		User user1= new User();
		user1.setStatus(status1);
		

		preparedStatement2.setString(1,status1);
		preparedStatement2.setString(2,email);
		preparedStatement2.executeUpdate();
		connection.close();
		System.out.println("==========================Status added Sucessfully===========================");

	}
}


