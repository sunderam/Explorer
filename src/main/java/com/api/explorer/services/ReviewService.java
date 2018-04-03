package com.api.explorer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.explorer.entity.Review;
import com.api.explorer.respository.ReviewRepositoty;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepositoty reviewRepository;
	
	public Review addReview(Review review) {
		return reviewRepository.save(review);
	}
	
	public Review getReviewById(long id) {
		return reviewRepository.getOne(id);
	}

	public List<Review> getAllReviews() {
		// TODO Auto-generated method stub
		return reviewRepository.findAll();
	}
	
	public void deleteReview(long id) {
		reviewRepository.deleteById(id);
	}
}
