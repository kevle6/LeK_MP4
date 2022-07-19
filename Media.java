/*
Full name: Kevin Le
Student ID: 2406054
Chapman email: kevle@chapman.edu
Course number and section: CPSC 231-04
Assignment or exercise number: Programming Mastery Project 4: Inheritance, Polymorphism, and Files
*/

/*
The Media class will be an abstract class meant to provide basic attributes to Songs and Podcasts.
Each Media will have an title, artist, three genres, and number of streams.
They can be played using the play method.
Media is compared based on the number of streams.
*/

public abstract class Media implements Comparable<Media> {

  // Member variables
  protected String m_title; // title of media
  protected Artist m_artist; // artist name
  protected String[] m_genres = null; // genres the media falls under
  protected int m_numStreams = 0; // number of times it was streamed

  // Overloaded Constructor
  public Media(String title, Artist artist, String genre1, String genre2, String genre3) {
    m_title = title;
    m_artist = artist;
    m_genres = new String[3];
    m_genres[0] = genre1;
    m_genres[1] = genre2;
    m_genres[2] = genre3;
  }

  // play method
  public void play() {
    System.out.println("Now playing: "+m_title+" by "+m_artist);
    ++m_numStreams;
  }

  // Comparing two media based on amount of streams
  public int compareTo(Media m) {
    if (this.m_numStreams < m.m_numStreams) {
      return -1;
    }
    else if (this.m_numStreams == m.m_numStreams) {
      return 0;
    }
    else {
      return 1;
    }
  }

  // toString method
  public String toString() {
    String s = "";
    s += "Title: "+m_title+"\n";
    s += m_artist;
    s += "Number of streams: "+m_numStreams+"\n";
    s += "Genres: "+m_genres[0]+", "+m_genres[1]+", "+m_genres[2]+"\n\n";
    return s;
  }

}
