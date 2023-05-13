package com.jspiders.musicplayer.songs;

public class Songs {
	private int Sr_No;
	private String Song_Name;
	private String Singer_Name;
	private String Movie_Name;
	private double Song_Duration;

	// Parameterize constructor

	public Songs(int sr_No, String song_Name, String singer_Name, String movie_Name, double song_Duration) {
		
		Sr_No = sr_No;
		Song_Name = song_Name;
		Singer_Name = singer_Name;
		Movie_Name = movie_Name;
		Song_Duration = song_Duration;
	}

	// getter helper method
	public int getter() {
		return this.Sr_No;
	}

	public String getSongName() {
		return Song_Name;
	}

	public String getSingerName() {
		return Singer_Name;
	}

	public String getMovieName() {
		return Movie_Name;
	}

	public double getSongDuration() {
		return Song_Duration;
	}

	// setter helper method
	public void setter(String Song_Name, String Singer_Name, String Movie_Name, double Song_Duration) {
		this.Song_Name = Song_Name;
		this.Singer_Name = Singer_Name;
		this.Movie_Name = Movie_Name;
		this.Song_Duration = Song_Duration;
	}

	@Override
	public String toString() {
		return "Sr_No : "+this.Sr_No+"Song Name: " + this.Song_Name + "\n Song Duration: " + this.Song_Duration + "\nSinger Name: "
				+ this.Singer_Name + "\nMovie Name: " + this.Movie_Name;
	}

}