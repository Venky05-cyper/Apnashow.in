package com.example.ApnaShow.in.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ApnaShow.in.Entity.ViewAllentity;

@Repository
public interface ViewallRepo extends JpaRepository<ViewAllentity, Integer> {

}
