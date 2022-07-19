/*
Full name: Kevin Le
Student ID: 2406054
Chapman email: kevle@chapman.edu
Course number and section: CPSC 231-04
Assignment or exercise number: Programming Mastery Project 4: Inheritance, Polymorphism, and Files
*/

/*
The Song class will be a class inheriting from the Media class.
It has all the basic functionalities of Media, except it can be instantiated.
*/

public class Song extends Media {

  // Overloaded Constructor
  public Song(String title, Artist artist, String genre1, String genre2, String genre3) {
    super(title, artist, genre1, genre2, genre3);
  }
}
