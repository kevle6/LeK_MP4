/*
Full name: Kevin Le
Student ID: 2406054
Chapman email: kevle@chapman.edu
Course number and section: CPSC 231-04
Assignment or exercise number: Programming Mastery Project 4: Inheritance, Polymorphism, and Files
*/

/*
The Artist class will be an class inheriting from the Account class
It is the only class meant to be a creator of content
*/

import java.util.ArrayList;
public class Artist extends Account {

  // Overloaded Constructor
  public Artist(String email, String userName, String password) {
    super(email, userName, password);
  }
  
  // toString method
  public String toString() {
    String s = "Artist: "+m_userName+"\n";
    return s;
  }




}
