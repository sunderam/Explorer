package com.api.explorer.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.explorer.entity.Review;

public interface ReviewRepositoty extends JpaRepository<Review, Long> {

}
