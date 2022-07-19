/*
Full name: Kevin Le
Student ID: 2406054
Chapman email: kevle@chapman.edu
Course number and section: CPSC 231-04
Assignment or exercise number: Programming Mastery Project 4: Inheritance, Polymorphism, and Files
*/

/*
The Account class will be an abstract class meant to provide basic attributes to accounts for Artists and Listeners
Each account will have an email, username, password, and ID number, and users can change their password
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public abstract class Account {

  // member variables for a basic account
  protected String m_email; // email
  protected String m_userName; // username
  protected String m_password; // password
  protected int m_IDnumber; // ID number
  private Scanner scnr = new Scanner(System.in);
  protected Random random = new Random(); // To generate random ID number

  //Overloaded constructor
  public Account(String email, String userName, String password) {
    m_email = email;
    m_userName = userName;
    m_password = password;
    m_IDnumber = random.nextInt(50001); // ID numbers ranging from 0 to 50000
  }

  // Accessors

  // get email
  public String getEmail() {
    return m_email;
  }

  // get username
  public String getUsername() {
    return m_userName;
  }

  // Mutators

  // set email
  public void setEmail(String email) {
    m_email = email;
  }

  // set username
  public void setUsername(String userName) {
    m_userName = userName;
  }

  // set password
  private void setPassword(String password) {
    m_password = password;
  }

  // Method to change the password

  public void changePassword(String password) {
    String newPassword;
    System.out.print("Enter your old password: "); // Prompt user

    String enteredPassword = scnr.next(); // takes in String input

    // while the enteredPassword is not equal to the old password
    while (!enteredPassword.equals(m_password)) {
      // If they quit, return
      if (enteredPassword.equals("q")) {
        return;
      }
      // wrong password
      System.out.println("That is not the old password. Type 'q' to quit.");
      System.out.print("Enter a different password: ");
      enteredPassword = scnr.next();
    }
    // prompts for new password
    System.out.print("Enter a new password: ");
    newPassword = scnr.next();
    this.setPassword(newPassword);
  }
  // seperate implementation in Artists and Listeners
  public abstract String toString();



}
