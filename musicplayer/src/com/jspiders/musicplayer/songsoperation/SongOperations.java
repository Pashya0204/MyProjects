package com.jspiders.musicplayer.songsoperation;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.jspiders.musicplayer.songs.Songs;

public class SongOperations {
	public static boolean start = false;
	static ArrayList<Songs> songsCollection = new ArrayList<Songs>();
	static int size;
	static Songs song[] = new Songs[size];
	Scanner inScanner = new Scanner(System.in);

// adding songs in array list collection
	public void addSong() {

		System.out.println("Adding Song In List....");
		start = true;
		boolean stop = true;
		double songDuration = 0.0;
		while (stop) {
			try {
				System.out.println("add song starting.........");
				System.out.print("Enter Numbers of songs you want to add (Enter '0' Zero to exit):- ");
				size = inScanner.nextInt();
				if (size == 0) {
					System.out.println("");
					break;
				}
				Songs song[] = new Songs[size];
				for (int i = 0; i < size; i++) {
					System.out.print("Enter Number " + (i + 1) + " Song..\n");

					System.out.print("Enter Song Name:- ");
					String songName = inScanner.nextLine();
					songName = inScanner.nextLine();

					System.out.print("Enter Singer Name:- ");
					String singerName = inScanner.nextLine();

					System.out.print("Enter Movie Name:-");
					String movieName = inScanner.nextLine();
					boolean innerStop = true;
					while (innerStop) {
						try {
							System.out.print("Enter Song Duration:- ");
							songDuration = inScanner.nextDouble();
							innerStop = false;

						} catch (InputMismatchException e) {
							System.out.println("Please ennter valid duration ..(e.g  3.2)");
							inScanner.next();
						}

					}

					System.out.println();
					song[i] = new Songs(i, songName, singerName, movieName, songDuration);

					songsCollection.add(song[i]);
					stop = false;
				}
			} catch (InputMismatchException e) {
				System.out.println("Please Enter Number\n");
				inScanner.next();
			}

		}

	}

// removing last song from array list collection
	public void removeSong() {
		System.out.println("Removing Song....");
		System.out.println("Loading Song List....");

		if (!start) {
			System.out.println("No song present in list \n Please add songs before removing..\n");
		} else {
			int i = 0;
			for (Object songs : songsCollection) {
				System.out.println("*Song Number:- " + (i + 1));
				System.out.println(songs + " ");
				System.out.println();
				i++;
				try {
					Thread.sleep(500);

				} catch (Exception e) {
					System.out.println("Loading.....");
				}
			}
			System.out.print("Which Song You Wnat to remove? Enter song Number (Enter '0' Zero to exit): -");
			int removeSong = inScanner.nextInt();
			if (removeSong == 0) {
				System.out.println("");
				return;
			} else {
				songsCollection.remove(removeSong - 1);
				System.out.println("Song was removed....\n");
			}
		}
	}

// playing song from array list by user choice
	public void chooseToPlaySong() {
		System.out.println("Playing songs....Please Wait");
		System.out.println("Loading Song List....");

		int i = 0;
		if (!start) {
			System.out.println("No song found in list... \nPlease add songs first..\n");
		} else {
			for (Object songs : songsCollection) {
				System.out.println("*Song Number:- " + (i + 1));
				System.out.println(songs);
				System.out.println(" ");
				i++;
				try {
					Thread.sleep(500);

				} catch (Exception e) {
					System.out.println("Loading.....");
				}
			}
		}
		if (start) {
			boolean stop = true;
			while (stop)
				try {
					System.out.print(
							"\nWhich song you want to play ?\nPlease enter Song Number (Enter '0' Zero to exit):- ");
					int songNameNumber = inScanner.nextInt();
					if (songNameNumber == 0) {
						System.out.println("");
						return;
					} else {
						Songs songNameSongs = songsCollection.get(songNameNumber - 1);
						System.out.println("\nPlaying Song Number " + songNameNumber);
						System.out.println(songNameSongs + "\n");
						stop = false;
					}
				} catch (InputMismatchException e) {
					System.out.println("\nplease enter valid Number\n");
					inScanner.next();
				} catch (IndexOutOfBoundsException e) {
					System.out.println("\nSong Number Not present in list\n");
					stop = false;
				}

		}
	}

// playing all songs from array list collection
	public void playAllSong() {
		System.out.println("Playing all songs....Please Wait");
		System.out.println("Loading Song List....\n");

		int i = 0;
		if (!start) {
			System.out.println("No song found in list... \nPlease add songs first..\n");
		} else {
			for (Object songs : songsCollection) {
				System.out.println("Playing Number " + (i + 1) + " Song....");
				System.out.println(songs);
				System.out.println();
				i++;
				if (i < songsCollection.size() - 1) {
					System.out.println("Next Song In Queue ....Please Wait\n");
				} else if (i < songsCollection.size()) {
					System.out.println("Last Song In Queue..Please Wait\n");
				}
				try {
					if (i < songsCollection.size()) {
						Thread.sleep(10000);
					}

				} catch (Exception e) {
					System.out.println("Loading.....");
				}
			}
		}
	}

// playing random song from array list collection
	public void playRandomSong() {

		System.out.println("Loading Song List....Please Wait");
		System.out.println("Playing Random Song.....\n");
		if (start) {
			double randomSongNumber = Math.random() * songsCollection.size() + 1;
			int randomSongNumber1 = (int) randomSongNumber;
			System.out.println("playing Number " + randomSongNumber1 + " Song.");
			System.out.println(songsCollection.get(randomSongNumber1 - 1));
			System.out.println("");
		} else {
			System.out.println("No song found in list... \nPlease add songs first..\n");
		}

	}

// update song using setter method
	public void updateSong() {
		int i = 0;

		System.out.println("Loading Song List....");

		for (Object songs : songsCollection) {
			System.out.println("*" + (i + 1) + ". song is....");
			System.out.println(songs);
			System.out.println();
			i++;
			try {
				Thread.sleep(300);

			} catch (Exception e) {
				System.out.println("Loading.....");
			}
		}
		int updateSong = 0;
		boolean update = true;
		while (update) {
			try {
				System.out.println("Which song you want to update ? provide its number..(Enter '0' Zero to exit)");
				updateSong = inScanner.nextInt();
				if (updateSong == 0) {
					System.out.println("");
					return;
				}
				update = false;
			} catch (InputMismatchException e) {
				System.out.println("Please Enter valid Number..");
				inScanner.next();
			}
		}

		if (songsCollection.size() > updateSong - 1) {
			System.out.print("Enter New Song Name:- ");
			String songName = inScanner.nextLine();
			songName = inScanner.nextLine();

			System.out.print("Enter New Singer Name:- ");
			String singerName = inScanner.nextLine();

			System.out.print("Enter New Movie Name:-");
			String movieName = inScanner.nextLine();

			boolean innerStop = true;
			while (innerStop) {
				try {
					System.out.print("Enter New Song Duration:- ");
					double songDuration = inScanner.nextDouble();
					songsCollection.get(updateSong - 1).setter(songName, singerName, movieName, songDuration);
					System.out.println("\nSong Updating....\n");
					innerStop = false;

				} catch (InputMismatchException e) {
					System.out.println("Please ennter valid duration ..(e.g  3.2)");
					inScanner.next();
				}

			}

		} else {
			System.out.println("This Song is not present in the list....\n");
		}
	}
}
