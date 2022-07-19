/*
Full name: Kevin Le
Student ID: 2406054
Chapman email: kevle@chapman.edu
Course number and section: CPSC 231-04
Assignment or exercise number: Programming Mastery Project 4: Inheritance, Polymorphism, and Files
*/

/*
The Album class will be a specific type of Playlist in which it can only hold songs. Playlists can hold songs and podcasts.
*/

public class Album extends Playlist {

  // Overlaoded Constructor
  public Album(String title) {
    super(title);
  }

  // addMedia from Playlist, but checking if it is a song or not
  public void addMedia(Media m) {
    // if the media is not a song
    if (! (m instanceof Song)) {
      System.out.println("You can only add songs to albums.");
      return;
    }
    else if (m instanceof Song){
      super.addMedia(m);
    }
  }
  
}
