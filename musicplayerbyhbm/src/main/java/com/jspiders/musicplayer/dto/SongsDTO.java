package com.jspiders.musicplayer.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Songs")
public class SongsDTO {
	@Id

	private int Sr_No;
	private String Song_Name;
	private String Singer_Name;
	private String Movie_Name;
	private double Song_Duration;

}
