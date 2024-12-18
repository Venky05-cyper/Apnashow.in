package com.example.ApnaShow.in.Entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Entity
@Data
public class ViewAllentity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Lob
	@Column(columnDefinition = "LONGTEXT")
	private String image;
	private String title;
	private String genre;
	private LocalDate date;
	private String location;
	private double price;
	private String about;
	private String city;

}
