package com.jspiders.musicplayer.dao;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.jspiders.musicplayer.dto.SongOperationDTO;

public class MusicPlayerDAO {

	static boolean loop = true;
	static int choose, choose1, choose2, choose3;

	public static void main(String[] args) {
		MusicPlayerDAO m = new MusicPlayerDAO();
		// main method
		while (loop) {
			m.selectOptions();
		}
	}

	// displaying option
	public void selectOptions() {

		Scanner inputScanner = new Scanner(System.in);

		// try {
		System.out.println("\n Select Options from Menu \n");
		System.out.println(
				"|===================== \n ***** Menu ***** \n|1.Play Song \n|2.Add/Remove Song \n|3.Update Song \n|4.Exit \n =====================| ");
		choose = inputScanner.nextInt();

		// } catch (InputMismatchException e) {
		System.out.println("Please Choose The Option From Above List ");
		// }

		// case 1 song options
		switch (choose) {
		case 1: {
			boolean stop = true;
			while (stop) {
				try {
					System.out.println("choose option");
					System.out.println("Choose Song From Given List \n1.Play all songs  \n2.Go Back\n");
					choose1 = inputScanner.nextInt();
					stop = false;
				} catch (InputMismatchException e) {
					System.out.println("Please Enter Number\n");
					inputScanner.next();
				}
			}

			switch (choose1) {
			case 1:
				SongOperationDTO.playAllSong();
				break;

			case 2:
				System.out.println("Going Back.....\n\n");
				break;

			default:
				System.out.println("Invalid Choice.\n");
				break;
			}
		}
			break;

		// case 2 add/remove songs option
		case 2: {
			boolean stop = true;
			while (stop) {
				try {
					System.out.println("choose option");
					System.out.println("1.Add Song \n2.Remove songs \n3.Go Back\n");
					choose2 = inputScanner.nextInt();
					stop = false;
				} catch (InputMismatchException e) {
					System.out.println("Please Enter Number \n");
					inputScanner.next();
				}
			}

			switch (choose2) {
			case 1:
				SongOperationDTO.addSong();
				break;
			case 2:
				SongOperationDTO.removeSong();
				break;
			case 3:
				System.out.println("Going Back.....\n\n");
				break;

			default:
				System.out.println("Invalid Choice\n");
				break;
			}
		}
			break;

		// case 3 updating song
		case 3: {
			boolean stop = true;
			while (stop)
				try {

					System.out.println("choose options ");
					System.out.println("1.Update Song Name\\Singer Name\\Movie Name\\Song Duration\n2.Go Back\n");
					choose3 = inputScanner.nextInt();
					switch (choose3) {
					case 1:
						SongOperationDTO.updateSong();
						break;
					case 2:
						System.out.println("Going Back.....\n\n");
						break;

					default:
						System.out.println("Invalid Choice\n");
						stop = false;
						break;
					}
					stop = false;
				} catch (InputMismatchException e) {
					System.out.println("Please Enter Number\n");
					inputScanner.next();
				}

		}
			break;

		// case 4 exiting from menu
		case 4:
			System.out.println("Exting.....\n Thank You \n Made By - Prashant Gaikwad");
			loop = false;
			break;

		default:
			System.out.println("Invalid Choice\n");
			break;
		}

	}
}