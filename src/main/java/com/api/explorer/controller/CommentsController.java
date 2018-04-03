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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.explorer.entity.Comments;
import com.api.explorer.services.CommentService;
import com.api.explorer.services.ReviewService;

@RestController
@RequestMapping("/biz/{bizId}/{reviewId}")
public class CommentsController {

	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private CommentService commentService;
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/allComment")
	public ResponseEntity<List<Comments>> getAllComments(){
		return new ResponseEntity<>((List<Comments>)commentService.getAll(), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping("/addComment")
	@ResponseBody
	public ResponseEntity<Comments> addComment(@PathVariable long reviewId, @RequestBody Comments comment){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedUsername = auth.getName();
		comment.setUsername(loggedUsername);
		comment.setDateOfComment(new Date());
		comment.setReview(reviewService.getReviewById(reviewId));
		return new ResponseEntity<>(commentService.addComment(comment),HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/{commentId}")
	public ResponseEntity<Void> deleteCommentById(@RequestParam Long commentId){
		commentService.deleteComment(commentId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
