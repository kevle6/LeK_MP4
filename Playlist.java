/*
Full name: Kevin Le
Student ID: 2406054
Chapman email: kevle@chapman.edu
Course number and section: CPSC 231-04
Assignment or exercise number: Programming Mastery Project 4: Inheritance, Polymorphism, and Files
*/

/*
The Playlist class will be a class that holds all the media into an array for categorization.
Each Playlist will have an playlist title, an ArrayList keep track of all the media,
and a static ArrayList of Playlists used in the Driver class.
There is a shuffle method to play media in a random order in a playlist
Playlists are compared by size and can be modified.
*/

import java.util.Random;
import java.util.ArrayList;
public class Playlist implements Comparable<Playlist>{

  // Member variables
  protected static ArrayList<Playlist> m_allPlaylist = new ArrayList<Playlist>(); // all Playlists
  protected String m_title; // title of playlist
  protected ArrayList<Media> m_playlist = null; // "this" playlist
  protected static Random random = new Random();

  // Overloaded Constructor
  public Playlist(String title) {
    m_title = title;
    m_playlist = new ArrayList<Media>();
    m_allPlaylist.add(this);
  }

  // Shuffle method to shuffle through a playlist and play the media
  public void shuffle() {
    int numPlayed = 0;
    int nextMedia;
    Media currMedia;
    while (numPlayed < m_playlist.size()) {
      nextMedia = random.nextInt(m_playlist.size());
      currMedia = m_playlist.get(nextMedia);
      currMedia.play();
      ++numPlayed;
    }
  }

  // Mutators

  // adding to media
  public void addMedia(Media m) {
    System.out.println("Adding...");
    m_playlist.add(m);
  }

  // removing media
  public void removeMedia(Media m) {
    System.out.println("Removing...");
    m_playlist.remove(m);
  }

  // toString method
  public String toString() {
    String s = "Playlist Title: "+m_title+"\n\n";
    for (int i = 0; i < m_playlist.size(); ++i) {
      s += m_playlist.get(i);
    }
    return s;
  }
  // Accessor: to Display all Playlists
  public static String displayAllPlaylists() {
    String s = "";
    Playlist currPlaylist;
    for (int i = 0; i < m_allPlaylist.size(); ++i) {
      currPlaylist = m_allPlaylist.get(i);
      s += i+". "+currPlaylist+"\n";
    }
    return s;
  }

  // Accessors

  // get title
  public String getTitle(){
    return m_title;
  }

  //get playlist as string
  public String getPlaylist() {
    String s = "";
    for (int i = 0; i < m_playlist.size(); ++i) {
      s += m_playlist.get(i);
    }
    return s;
  }

  // Compares Playlists based on size
  public int compareTo(Playlist p) {
    if (this.size() < p.size()) {
      return -1;
    }
    else if (this.size() == p.size()) {
      return 0;
    }
    else {
      return 1;
    }
  }

  // size method for Playlists
  public int size() {
    return m_playlist.size();
  }

}
