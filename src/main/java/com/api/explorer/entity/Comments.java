package com.api.explorer.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "Comments")
@Table(name = "comments")
public class Comments implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long comment_id;
	
	@Lob
	@Type(type = "org.hibernate.type.StringType")
	@Column(length = Integer.MAX_VALUE)
	private String comment;
	
	private String username;
	private Date dateOfComment;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    private Review review;
	
	public Comments(){}

	public Comments(long comment_id, String comment, String username, Date dateOfComment, Review review) {
		super();
		this.comment_id = comment_id;
		this.comment = comment;
		this.username = username;
		this.dateOfComment = dateOfComment;
		this.review = review;
	}

	public long getComment_id() {
		return comment_id;
	}


	public void setComment_id(long comment_id) {
		this.comment_id = comment_id;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public Date getDateOfComment() {
		return dateOfComment;
	}


	public void setDateOfComment(Date dateOfComment) {
		this.dateOfComment = dateOfComment;
	}


	public Review getReview() {
		return review;
	}


	public void setReview(Review review) {
		this.review = review;
	}
	
	

		
}
