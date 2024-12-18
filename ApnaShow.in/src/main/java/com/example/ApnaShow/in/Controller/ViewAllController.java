package com.example.ApnaShow.in.Controller;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ApnaShow.in.Bean.viewallBean;
import com.example.ApnaShow.in.Entity.ViewAllentity;
import com.example.ApnaShow.in.ServiceImp.ViewallimpService;

@RestController
@RequestMapping("/viewall")
@CrossOrigin(origins = "http://localhost:3000")
public class ViewAllController {

	@Autowired
	ViewallimpService service;

	private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public ViewAllController(ViewallimpService service) {
		this.service = service;
	}

	@PostMapping("/event")
	public String postData(@RequestBody viewallBean request) {
		return service.postData(request);

	}

//	@GetMapping("/data")
//	public List<ViewAllentity> getData(@RequestParam(required = false) String city) {
//		List<ViewAllentity> data = service.getData();
//
//		if (city != null && !city.isEmpty()) {
//			data = data.stream().filter(entity -> entity.getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
//		}
//
//		return data;
//	}

	@GetMapping("/data")
	public List<ViewAllentity> getData(@RequestParam(required = false) String genre,
			@RequestParam(required = false) String city) {

		// Retrieve all data
		List<ViewAllentity> filteredData = service.getData();

		// Filter by genre if provided
		if (genre != null && !genre.isEmpty()) {
			filteredData = filteredData.stream().filter(entity -> genre.equalsIgnoreCase(entity.getGenre()))
					.collect(Collectors.toList());
		}

		// Filter by city if provided
		if (city != null && !city.isEmpty()) {
			filteredData = filteredData.stream().filter(entity -> city.equalsIgnoreCase(entity.getCity()))
					.collect(Collectors.toList());
		}

		return filteredData;
	}

	@GetMapping("/data/comedy")
	public List<ViewAllentity> getComedyData(@RequestParam(required = false) String city) {
		// Filter only comedy genre data
		List<ViewAllentity> comedyData = service.getData().stream()
				.filter(entity -> "comedy".equalsIgnoreCase(entity.getGenre())).collect(Collectors.toList());

		if (city != null && !city.isEmpty()) {
			comedyData = comedyData.stream().filter(entity -> entity.getCity().equalsIgnoreCase(city))
					.collect(Collectors.toList());
		}
		return comedyData;
	}

	@GetMapping("/data/music")
	public List<ViewAllentity> getMusicData(@RequestParam(required = false) String city) {
		List<ViewAllentity> data = service.getData().stream()
				.filter(entity -> "music".equalsIgnoreCase(entity.getGenre())).collect(Collectors.toList());

		if (city != null && !city.isEmpty()) {
			data = data.stream().filter(entity -> entity.getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
		}

		return data;
	}

	@GetMapping("/data/{id}")
	public Optional<ViewAllentity> getByID(@PathVariable int id) {
		return service.getById(id);
	}

	@PutMapping("/update/{id}")
	public String update(@RequestBody ViewAllentity request, @PathVariable int id) {
		return service.update(request, id);
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		return service.delete(id);
	}
}
