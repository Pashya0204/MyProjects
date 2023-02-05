package com.jspiders.musicplayer.songs;

public class Songs {
	private int id;
	private String songName;
	private String singerName;
	private String movieName;
	private double songDuration;

	// Parameterize constructor
	public Songs(int id, String songName, String singerName, String movieName, double songDuration) {
		this.id = id;
		this.songName = songName;
		this.singerName = singerName;
		this.movieName = movieName;
		this.songDuration = songDuration;
	}

	// getter helper method
	public int getter() {
		return this.id;
	}

	// setter helper method
	public void setter(String newSongName, String newSingerName, String newMovieName, double NewSongDuration) {
		songName = newSongName;
		singerName = newSingerName;
		movieName = newMovieName;
		songDuration = NewSongDuration;
	}

	@Override
	public String toString() {
		return "Song Name: " + this.songName + "\nSong Duration: " + this.songDuration + "\nSinger Name: "
				+ this.singerName + "\nMovie Name: " + this.movieName;
	}

}
