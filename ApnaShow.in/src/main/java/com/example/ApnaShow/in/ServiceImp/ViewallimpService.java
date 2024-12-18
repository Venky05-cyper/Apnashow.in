package com.example.ApnaShow.in.ServiceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ApnaShow.in.Bean.viewallBean;
import com.example.ApnaShow.in.Entity.ViewAllentity;
import com.example.ApnaShow.in.Repository.ViewallRepo;
import com.example.ApnaShow.in.Service.ViewallService;

@Service
public class ViewallimpService implements ViewallService {

	@Autowired
	ViewallRepo repo;

	@Override
	public String postData(viewallBean request) {
		ViewAllentity view = new ViewAllentity();
		System.out.println("Image Data Length: " + request.getImage().length());
		view.setTitle(request.getTitle());
		view.setAbout(request.getAbout());
		view.setGenre(request.getGenre());
		view.setImage(request.getImage());
		view.setLocation(request.getLocation());
		view.setPrice(request.getPrice());
		view.setDate(request.getDate());
		view.setCity(request.getCity());
		repo.save(view);
		return "viewall data saved!";
	}

	@Override
	public List<ViewAllentity> getData() {
		return repo.findAll();
	}

	public Optional<ViewAllentity> getById(int id) {
		return repo.findById(id);
	}

	public String update(ViewAllentity request, int id) {
		Optional<ViewAllentity> ops = repo.findById(id);

		if (ops.isPresent()) {
			ViewAllentity ent = ops.get();
			ent.setAbout(request.getAbout());
			ent.setDate(request.getDate());
			ent.setGenre(request.getGenre());
			ent.setImage(request.getImage());
			ent.setLocation(request.getLocation());
			ent.setPrice(request.getPrice());
			ent.setTitle(request.getTitle());
			ent.setCity(request.getCity());
			repo.save(ent);
			return "data Updated!";
		} else {
			return "data not found";
		}

	}

	public String delete(int id) {
		Optional<ViewAllentity> user = repo.findById(id);
		if (user.isPresent()) {
			repo.delete(user.get());
			return "User deleted successfully!";
		} else {
			return "User not found with ID: " + id;
		}
	}

}
