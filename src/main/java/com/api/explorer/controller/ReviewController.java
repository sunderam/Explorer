package com.api.explorer.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.explorer.entity.Review;
import com.api.explorer.services.BussinessService;
import com.api.explorer.services.ReviewService;

@RestController
@RequestMapping("/biz/{biz_Id}")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private BussinessService bussinessService;

	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/allReviews")
	public ResponseEntity<List<Review>> getAllReviews(){
		return new ResponseEntity<List<Review>>(reviewService.getAllReviews(),HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping("/addReview")
	public ResponseEntity<Review> addReview(@PathVariable long biz_Id , @RequestBody Review review){
		review.setDateOfReview(new Date());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedUsername = auth.getName();
		review.setUserName(loggedUsername);
		review.setBussiness(bussinessService.getBuzById(biz_Id));
		return new ResponseEntity<>(reviewService.addReview(review),HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/{reviewId}")
	public ResponseEntity<Void> deleteReview(@PathVariable long reviewId){
		reviewService.deleteReview(reviewId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
