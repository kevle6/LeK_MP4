/*
Full name: Kevin Le
Student ID: 2406054
Chapman email: kevle@chapman.edu
Course number and section: CPSC 231-04
Assignment or exercise number: Programming Mastery Project 4: Inheritance, Polymorphism, and Files
*/

/*
The Listener class will be a class meant to provide functionality to the music app. It is required to have an instance for this program to work.
It inherits from the Account class, has a favorites list and method to add to favorites list.
*/

import java.util.ArrayList;
public class Listener extends Account {

  // member variables
  private ArrayList<Media> m_favoriteContent = new ArrayList<Media>(); // all of the user's favorite content

  // Overloaded Constructor
  public Listener(String email, String userName, String password) {
    super(email, userName, password);
  }

  // adds user's favorite media
  public void favorite(Media m) {
    boolean isFavorite = false;
    // To check if media is already in favorite list
    for (int mediaIndex = 0; mediaIndex < m_favoriteContent.size(); ++mediaIndex) {
      // if the media is in the favorite list
      if (m_favoriteContent.get(mediaIndex).equals(m)) {
        isFavorite = true;
        break;
      }
    }
    // If already in favorite list
    if (isFavorite) {
      System.out.println("Removing "+m.m_title+" from your favorites list.");
      m_favoriteContent.remove(m);
    }
    else {
      System.out.println("Adding "+m.m_title+" to your favorites list.");
      m_favoriteContent.add(m);
    }
  }
  // Displays all of the user's favorites
  public String getFavorites() {
    String s = "Favorite Content:\n";
    for (int i = 0; i < m_favoriteContent.size(); ++i) {
      s += m_favoriteContent.get(i)+"\n";
    }
    return s;
  }


  // toString method
  public String toString() {
    String s = "Username: "+this.getUsername()+"\n";
    s += this.getFavorites();
    return s;
  }

}
