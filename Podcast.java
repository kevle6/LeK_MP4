/*
Full name: Kevin Le
Student ID: 2406054
Chapman email: kevle@chapman.edu
Course number and section: CPSC 231-04
Assignment or exercise number: Programming Mastery Project 4: Inheritance, Polymorphism, and Files
*/

/*
The Podcast class will inherit from the Media class, except with an epsiode number attached to it.
The play is slightly modified to display the episode number.
*/

public class Podcast extends Media {

  // Member variables
  private int m_epNum; // episode number

  // Overloade Constructor
  public Podcast(String title, Artist artist, String genre1, String genre2, String genre3, int epNum) {
    super(title, artist, genre1, genre2, genre3);
    m_epNum = epNum;
  }

  // Slightly modified play method
  public void play() {
    super.play();
    System.out.println("Episode "+m_epNum);
  }

  // toString method
  public String toString() {
    String s = "Episode "+m_epNum+"\n";
    s += super.toString();
    return s;
  }
}
