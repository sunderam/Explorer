package com.api.explorer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.explorer.entity.Comments;
import com.api.explorer.respository.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	public Comments addComment(Comments comment) {
		return commentRepository.save(comment);
	}
	
	public List<Comments> getAll(){
		return commentRepository.findAll();
	}

	public Comments getCommentById(long id) {
		return commentRepository.getOne(id);
	}
	
	public void deleteComment(long id) {
		commentRepository.deleteById(id);
	}
}