/*
Full name: Kevin Le
Student ID: 2406054
Chapman email: kevle@chapman.edu
Course number and section: CPSC 231-04
Assignment or exercise number: Programming Mastery Project 4: Inheritance, Polymorphism, and Files
*/

/*
The Driver class simulates a music app with five options: create a listening account,
                                                        list playlists and media to shuffle through,
                                                        add songs to other playlists,
                                                        and export the list of songs to a seperate file in ascending order by number of streams
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.util.Collections;
public class Driver {
  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    int num = 0;
    Listener testListener = null;

    Artist testArtist1 = new Artist("weezer@gmail.com", "Weezer", "haha234"); // has a podcast
    Playlist Podcast_series = new Playlist("Late Night with Weezer");
    Podcast Podcast1 = new Podcast("Why You Should Invest in NFTs", testArtist1, "Investment", "Cyber", "Internet", 1);
    Podcast Podcast2 = new Podcast("Tesla Space Phone?", testArtist1, "Tesla", "Space", "Satellites", 2);
    Podcast Podcast3 = new Podcast("A Year in Review", testArtist1, "COVID", "Memes", "Ukraine", 3);


    Artist testArtist2 = new Artist("bach@yahoo.com", "bach_Music", "baroque"); // has music
    Album Album1 = new Album("Bach's Epic Album");
    Song Song1 = new Song("Bach's 1st Song", testArtist2, "Classic", "Orchestra", "18th Century");
    Song Song2 = new Song("Bach's 2nd Song", testArtist2, "Rock", "Heavy Metal", "17th Century");
    Song Song3 = new Song("Bach's 3rd Song", testArtist2, "Jazz", "180 bpm", "25th Century");

    Album1.addMedia(Song1); // adds Bach's songs to his album
    Album1.addMedia(Song2);
    Album1.addMedia(Song3);

    Podcast_series.addMedia(Podcast1); // Adds podcasts to Weezer's podcast
    Podcast_series.addMedia(Podcast2);
    Podcast_series.addMedia(Podcast3);

    String email;
    String userName;
    String password;

    while (true) {
      // Menu display
      System.out.println("\n\n1. Create a listener account\n");
      System.out.println("2. List all Playlists and Albums available to shuffle\n");
      System.out.println("3. Add songs to an existing playlist\n");
      System.out.println("4. Export all songs on the platform out to a file in ascending order by times streamed\n");
      System.out.println("5. Exit\n\n");

      System.out.print("Enter a number: ");

      // while the user does not enter a number
      while (!scnr.hasNextInt()) {
        System.out.print("Enter a valid number: ");
        scnr.next();
      }
      num = scnr.nextInt();
      switch (num) {


        case 1: // Create an account
          // if there is not listener account yet
          if (testListener == null) {
            System.out.print("Enter an email: ");
            email = scnr.next();
            System.out.print("Enter a username: ");
            userName = scnr.next();
            System.out.print("Enter your password: ");
            password = scnr.next();
            testListener = new Listener(email, userName, password);
            System.out.println("Account created!");
          }
          // Stops from creating another account
          else {
            System.out.println("User account already created!");
          }
          break;


        case 2: // Display playlists and shuffle through one
          System.out.println(Playlist.displayAllPlaylists());
          System.out.println(testListener.getFavorites());

          // asks user for playlist
          System.out.print("Choose the Playlist number to shuffle through: ");
          int choosenPlaylist = scnr.nextInt();
          scnr.nextLine();
          ArrayList<Playlist> selectedList = Playlist.m_allPlaylist;
          Playlist selectedPlaylist = selectedList.get(choosenPlaylist);

          // plays the selected playlist
          selectedPlaylist.shuffle();

          // ask if there are any favorites to add
          System.out.println("Any favorites? Type 'y' or 'n'. ");
          char answer = scnr.next().charAt(0);

          // if yes, then add the song to favorites
          if (answer == 'y') {
            System.out.println("Which song? Type 0, 1, or 2.");
            int favoriteNum = scnr.nextInt();
            testListener.favorite(selectedPlaylist.m_playlist.get(favoriteNum));
          }
          break;


        case 3: // Add songs to exisiting playlist

          // prompt
          System.out.println(Playlist.displayAllPlaylists());
          System.out.print("Choose the Playlist number: ");
          int choosenPlaylistAdd = scnr.nextInt();
          scnr.nextLine();
          ArrayList<Playlist> selectedListAdd = Playlist.m_allPlaylist;
          Playlist selectedPlaylistAdd = selectedListAdd.get(choosenPlaylistAdd);
          selectedPlaylistAdd.shuffle(); // listen to the songs again

          // prompt for songs to add
          System.out.println("Which song do you want to add to the other playlist? Type 0, 1, or 2.");
          int selectedNumAdd = scnr.nextInt();

          // adds song to other playlist
          if (!selectedPlaylistAdd.equals(Podcast_series)) {
            Podcast_series.addMedia(selectedPlaylistAdd.m_playlist.get(selectedNumAdd));
          }
          else {
            Album1.addMedia(selectedPlaylistAdd.m_playlist.get(selectedNumAdd));
          }
          break;

        case 4: // Export songs to external file
          Playlist currPlaylist;
          ArrayList<Media> tempArrList = new ArrayList<Media>();
          // fills up temporary arrayList of all the media to then put onto file
          for (int i = 0; i < Playlist.m_allPlaylist.size(); ++i) {
            currPlaylist = Playlist.m_allPlaylist.get(i);
            for (int j = 0; j < currPlaylist.size(); ++j) {
              tempArrList.add(currPlaylist.m_playlist.get(j));
            }
          }
          // sorts the songs based on number of streams
          Collections.sort(tempArrList);

          // Prompt user for file name
          System.out.println("Enter a filename to export all the songs to. The order of the songs are listed in ascending order of times streamed.");
          String fileName = scnr.next();
          System.out.println("Exporting to a file called "+fileName);

          // try putting all songs into specified file name
          try{
            PrintWriter pw = new PrintWriter(new FileWriter(fileName));
            for (int i = 0; i < tempArrList.size(); ++i) {
              pw.println(tempArrList.get(i));
            }
            pw.close();
          }
          // in case filename invalid
          catch (IOException io) {
            System.err.println("Couldn't output to file! ");
            io.printStackTrace();
          }
          // any other case of exceptions
          catch (Exception e) {
            System.err.println("An error occurred while processing the file! ");
            e.printStackTrace();
          }
          finally {
            // prompts for another file name to export to, or quit
            System.out.print("Enter a different filename or 'q' to quit: ");
            fileName = scnr.next();
            if (fileName.charAt(0) == 'q') {
              break;
            }
          }
          break;

        case 5: // User is finished using the music app
          return;

        default:
          break;
      }
    }
  }
}
