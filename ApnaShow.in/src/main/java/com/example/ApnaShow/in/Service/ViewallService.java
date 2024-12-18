package com.example.ApnaShow.in.Service;

import java.util.List;
import java.util.Optional;

import com.example.ApnaShow.in.Bean.viewallBean;
import com.example.ApnaShow.in.Entity.ViewAllentity;

public interface ViewallService {

	String postData(viewallBean request);

	List<ViewAllentity> getData();

	Optional<ViewAllentity> getById(int id);

	String update(ViewAllentity request, int id);

	String delete(int id);
}
