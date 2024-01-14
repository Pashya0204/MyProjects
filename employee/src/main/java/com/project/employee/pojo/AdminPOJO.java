package com.project.employee.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="admin")
public class AdminPOJO {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String user;
	private String password;
}
