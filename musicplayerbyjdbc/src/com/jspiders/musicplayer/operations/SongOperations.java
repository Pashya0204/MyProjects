package com.jspiders.musicplayer.operations;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class SongOperations {

	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static FileReader fileReader;
	private static Properties properties;
	private static ResultSet resultSet;
	private static int result;
	private static String selectSong;
	private static String selectSong1;
	private static String insertSong;
	private static String updateSong;
	private static String deleteSong;
	private static String filePath = "D:\\WEJA1\\musicplayerbyjdbc\\resources\\db_info.properties";
	static Scanner scanner = new Scanner(System.in);

	public static void setConnection() {

		try {

			fileReader = new FileReader(filePath);
			properties = new Properties();
			properties.load(fileReader);
			Class.forName(properties.getProperty("driverPath"));

			connection = DriverManager.getConnection(properties.getProperty("dburl"), properties);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private static void closeConnection() {
		
			try {
				if(connection != null) {
				connection.close();}
				
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if (fileReader != null) {
					fileReader.close();
				}
				if(resultSet != null ) {
					resultSet.close();
				}
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
			
	}

	public static void playAllSong() {
		try {
			setConnection();
			selectSong = "select * from Songs";
			preparedStatement = connection.prepareStatement(selectSong);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				for (int i = 1; i <= 5; i++) {
					System.out.print(resultSet.getString(i) + " || ");
				}
				System.out.println("");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//closeConnection();

	}

	public static void chooseSongPlay() {

		
		try {
			setConnection();

			playAllSong();
			selectSong1 = "select * from songs where Song_Name =?";
			preparedStatement = connection.prepareStatement(selectSong1);
			System.out.println("Pls Write The Song Name Which Is Mentioned In The Above List To Play That Song");
			preparedStatement.setString(1, scanner.nextLine());
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				for (int i = 1; i <= 5; i++) {
					System.out.print(resultSet.getString(i) + " || ");
				}
				System.out.println("");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void addSong() {

		setConnection();
		playAllSong();
		
		try {
			insertSong = "insert into songs values(?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(insertSong);
			System.out.println("pls check the Sr_No from Above List \n Enter Sr_No of Song");
			preparedStatement.setString(1, scanner.nextLine());
			System.out.println("Pls Enter The Song_Name");
		    preparedStatement.setString(2, scanner.nextLine());
			System.out.println("Pls Enter The Singer Name");
			preparedStatement.setString(3, scanner.nextLine());
			System.out.println("Pls Enter Movie Name ");
			preparedStatement.setString(4, scanner.nextLine());
			System.out.println("Pls Enter The Song_Duration");
			preparedStatement.setDouble(5, scanner.nextDouble());

			result = preparedStatement.executeUpdate();
			System.out.println("Query Ok " + result
					+ "Ros(s) Affected...\n Song Added Successfully.... \n pls Check In Bellow List Song Is Added or Not");
			playAllSong();

		} catch (SQLException e) {

			e.printStackTrace();
		} 
		//closeConnection();

	}

	public static void updateSong() {
		setConnection();
		playAllSong();
		updateSong = "UPDATE Songs SET Song_Name =?,Singer_Name =?,Movie_Name =?,Song_Duration =? where Sr_No =?;";

		try {
			preparedStatement = connection.prepareStatement(updateSong);
			System.out.println(
					"Pls Check The Sr_No  of Song From Above List Which Is Need To Update \n Pls Enter The Song Name");
			preparedStatement.setString(1, scanner.nextLine());
			System.out.println("Pls Enter The Singer Name");
			preparedStatement.setString(2, scanner.nextLine());
			System.out.println("Pls Enter The Movie Name");
			preparedStatement.setString(3, scanner.nextLine());
			System.out.println("Pls Enter Song Duration");
			preparedStatement.setDouble(4, scanner.nextDouble());
			System.out.println("Pls Enter The Sr No Of Song Which You Want To Update");
			preparedStatement.setInt(5, scanner.nextInt());

			result = preparedStatement.executeUpdate();
			System.out.println("Query Ok " + result
					+ "Ros(s) Affected...\n Song Updated Successfully.... \n pls Check In Bellow List Song Is Added or Not");
			playAllSong();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		//closeConnection();
	}

	public static void removeSong() {
		setConnection();
		playAllSong();

		deleteSong = "delete from Songs where Sr_No =?";

		try {

			preparedStatement = connection.prepareStatement(deleteSong);
			System.out.println(
					"Pls See The Sr_No of the Song Which is you want to remove it  \n Enter The Sr_No Of Song Which Is Need to Remove It");
			preparedStatement.setInt(1, scanner.nextInt());
			result = preparedStatement.executeUpdate();
			System.out.println("Query Ok " + result
					+ "Ros(s) Affected...\n Song Removed Successfully.... \n Pls Check In Bellow List Song Is Removed or Not");
			playAllSong();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		//closeConnection();
	}

}
