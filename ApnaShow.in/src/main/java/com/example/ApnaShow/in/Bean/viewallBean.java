package com.example.ApnaShow.in.Bean;

import java.time.LocalDate;

import lombok.Data;

@Data
public class viewallBean {

	private String title;
	private String image;
	private String genre;
	private LocalDate date;
	private String location;
	private double price;
	private String about;
	private String city;

}
