package emailapp;

import java.util.Scanner;

public class Email {
	private static final String Password = null;
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity=500;
	private int defultPasswordLeng=10;
	private String alternateEmail;
	private String companySuffix="aeycompany.com";
	
	
	// Constructor to receive the first and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;

		// Call a method asking for the department - return the department
		this.department = setDepartment();

		// Call method that returns a random Password
		this.password= randomPassword(defultPasswordLeng);
		System.out.println("Your Password is:" + this.password);
		
		//Combine elements to genarate email
		email=firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department+"."+companySuffix;
	}

	// Ask for the department
	private String setDepartment() {
		System.out.print(
				"New worker:"+firstName+".DEPARTMENT CODES:\n1 for Sales  \n2 for Devolepment \n3 for Accounting \n0 for none\nEnter department code: ");
		try (Scanner in = new Scanner(System.in)) {
			int depChoice = in.nextInt();
			if (depChoice == 1) {
				return "sales";
			} else if (depChoice == 2) {
				return "dev";
			} else if (depChoice == 3) {
				return "acct";
			} else {
				return "";
			}
		}

	}

	// Genarate a random Password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
			System.out.println(rand);
			System.out.println(passwordSet.charAt(rand));
		}
		return new String(password);
	}
	// set the maillBox Capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity=capacity;
	}
	// Set the alternate email
	public void setAlternateEmail(String altemail) {
		this.alternateEmail=altemail;
	}
	// Change the password
	public void changePassword(String password) {
		this.password=password;
	}
	
	public int getMailboxCpcity(){return mailboxCapacity;}
	public  String getAlternateEmail(){return alternateEmail;}
	public String getPassword() {return Password;}
	
	public String showInfo() {
		return "DISPLAY NAME:"+firstName+""+lastName+
				"\nCOMPANY EMAIL:"+email+
				"\nMAILBOX CAPACITY:"+ mailboxCapacity +"mb";
	}
}
