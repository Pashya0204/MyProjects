package com.jspiders.musicplayer.dto;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Table;

@Table(name = "SongOperation")
public class SongOperationDTO {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;

	private static String selectSong;
	private static String selectSong1;

	static Scanner scanner = new Scanner(System.in);

	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("player");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}

	private static void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
		if (transaction.isActive()) {
			transaction.rollback();
		}
	}

	public static void playAllSong() {
		try {
			openConnection();
			transaction.begin();

			selectSong = "from SongsDTO";
			query = manager.createQuery(selectSong);
			List<SongsDTO> songs = query.getResultList();
			for (SongsDTO songsDTO : songs) {
				System.out.println(songs);
			}

			transaction.commit();
		} finally {
			closeConnection();
		}
	}

	public static void addSong() {
		playAllSong();
		try {
			Scanner scanner = new Scanner(System.in);
			openConnection();
			transaction.begin();

			SongsDTO Songs = new SongsDTO();
			System.out.println("Pls Set The Sr No Of Song");
			Songs.setSr_No(scanner.nextInt());
			System.out.println("Pls add the Name Of Song");
			Songs.setSong_Name(scanner.next());
			System.out.println("Pls Add The Movie Name Of Song");
			Songs.setMovie_Name(scanner.next());
			System.out.println("Pls Add The Singer Name Of Song");
			Songs.setSinger_Name(scanner.next());
			System.out.println("Pls Add The Duration Of Song");
			Songs.setSong_Duration(scanner.nextDouble());
			manager.persist(Songs);
			transaction.commit();
		} finally {
			closeConnection();
			playAllSong();
		}
	}

	public static void updateSong() {
		playAllSong();
		Scanner scanner = new Scanner(System.in);

		try {

			openConnection();
			transaction.begin();
			SongsDTO Song2 = manager.find(SongsDTO.class, 6);
			System.out.println("Pls choose the Same SrNO ");
			Song2.setSr_No(scanner.nextInt());
			System.out.println("Pls add the Name Of Song");
			Song2.setSong_Name(scanner.next());
			System.out.println("Pls Add The Movie Name Of Song");
			Song2.setMovie_Name(scanner.next());
			System.out.println("Pls Add The Singer Name Of Song");
			Song2.setSinger_Name(scanner.next());
			System.out.println("Pls Add The Duration Of Song");
			Song2.setSong_Duration(scanner.nextDouble());
			manager.persist(Song2);
			transaction.commit();
		} finally {
			closeConnection();
		}
	}

	public static void removeSong() {
		Scanner scanner = new Scanner(System.in);
		playAllSong();
		try {
			openConnection();
			transaction.begin();
			System.out.println("Pls choose the SrNO of song which is you want remove");
			SongsDTO Songs = manager.find(SongsDTO.class, scanner.nextInt());
			manager.remove(Songs);
			transaction.commit();

		} finally {
			closeConnection();
			playAllSong();
		}

	}

}
