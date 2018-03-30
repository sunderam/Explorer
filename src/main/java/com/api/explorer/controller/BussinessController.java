package com.api.explorer.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.explorer.entity.Bussiness;
import com.api.explorer.entity.Review;
import com.api.explorer.services.BussinessService;
import com.api.explorer.services.ReviewService;

@RestController
@RequestMapping("/biz")
public class BussinessController {
	
	@Autowired
	private BussinessService bizService;
	
	@Autowired
	private ReviewService reviewService;

	@GetMapping("/all")
	public List<Bussiness> getBussiness(){
		return bizService.getBussiness();
	}
	@PostMapping("/add")
	public ResponseEntity<Bussiness> addBussiness(@RequestBody Bussiness biz){
		return new ResponseEntity<>(bizService.addBussiness(biz) , HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Bussiness> getBizById(@PathVariable Long id){
		return new ResponseEntity<>(bizService.getBuzById(id) , HttpStatus.FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBizById(@PathVariable Long id){
		bizService.deleteBizById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/{id}/addReview")
	public ResponseEntity<Review> addReview(@RequestBody Review review){
		review.setDateOfReview(new Date());
		review.setUserName("sundarbhalerao@gmail.com");
		return new ResponseEntity<>(reviewService.addReview(review),HttpStatus.CREATED);
	}
	@GetMapping("/{id}/getAllReviews")
	public ResponseEntity<List<Review>> getAllReviews(){
		return new ResponseEntity<List<Review>>(reviewService.getAllReviews(),HttpStatus.OK);
	}
}
