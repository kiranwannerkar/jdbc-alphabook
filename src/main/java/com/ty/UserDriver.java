package com.ty;

import java.util.Scanner;
public class UserDriver {
	public static void main(String[] args) throws Exception{
		Scanner scanner=new Scanner(System.in);
		boolean data=true;
		do {
			System.out.println("**************************ALPHA BOOK****************************");
			System.out.println("1.LOGIN");
			System.out.println("2.SIGNUP");
			System.out.println("3.EXIT");

			System.out.println("ENTER YOUR CHOICE");
			System.out.println("****************************************************************");
			int choice=scanner.nextInt();

			switch (choice) {
			case 1:{
				System.out.println("enter the user email Id");
				String emailId=scanner.next();
				System.out.println("enter the user password");
				String password=scanner.next();
				User user=new User();
				user.setEmailId(emailId);
				user.setPassword(password);

				SocialMedia s=new SocialMedia();
				try {
					s.LoginUser(emailId, password, user);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			break;
			case 2:{
				System.out.println("enter the user id");
				int id=scanner.nextInt();
				System.out.println("enter the user first name");
				String firstName=scanner.next();
				System.out.println("enter the user last name");
				String lastName=scanner.next();
				System.out.println("enter the user gender");
				String gender=scanner.next();
				System.out.println("enter the user contact number");
				long contactNumber=scanner.nextLong();
				System.out.println("enter the user date of birth");
				String dateOfBirth=scanner.next();
				System.out.println("enter the user email Id");
				String emailId=scanner.next();
				System.out.println("enter the user password");
				String password=scanner.next();
				System.out.println("enter the status");
				String status=scanner.next();

				User user=new User();
				user.setId(id);
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setGender(gender);
				user.setContactNumber(contactNumber);
				user.setDateOfBirth(dateOfBirth);
				user.setEmailId(emailId);
				user.setPassword(password);
				user.setStatus(status);

				SocialMedia s=new SocialMedia();
				try {
					s.signUp(user);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			break;
			case 3:{
				data=false;
				System.out.println("EXIT");
			}
			break;

			default:
				System.out.println("please enter the valid data");
				break;
			}
		} while (data);

	}
}
