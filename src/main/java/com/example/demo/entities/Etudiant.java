package com.example.demo.entities;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Etudiant {
	private Long id;
	private String name;
	private String email;
	private Date dateNaissance;
	private int score;
}
