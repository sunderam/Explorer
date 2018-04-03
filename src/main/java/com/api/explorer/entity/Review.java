package com.api.explorer.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "Review")
@Table(name = "review")
public class Review implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long review_id;
	private String userName;

	@Lob
	@Type(type = "org.hibernate.type.StringType")
	@Column(length = Integer.MAX_VALUE)
	private String messege;

	private Date dateOfReview;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "biz_id")
    private Bussiness bussiness;
	
	@JsonManagedReference
	@OneToMany(
	        mappedBy = "review", 
	        cascade = CascadeType.ALL, 
	        orphanRemoval = true
	        )
	private List<Comments> comments;

	Review() {

	}

	
	public Review(long review_id, String userName, String messege, Date dateOfReview, Bussiness bussiness,
			List<Comments> comments) {
		super();
		this.review_id = review_id;
		this.userName = userName;
		this.messege = messege;
		this.dateOfReview = dateOfReview;
		this.bussiness = bussiness;
		this.comments = comments;
	}


	public long getReview_id() {
		return review_id;
	}

	public void setReview_id(long review_id) {
		this.review_id = review_id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMessege() {
		return messege;
	}

	public void setMessege(String messege) {
		this.messege = messege;
	}

	public Date getDateOfReview() {
		return dateOfReview;
	}

	public void setDateOfReview(Date dateOfReview) {
		this.dateOfReview = dateOfReview;
	}

	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}

	public Bussiness getBussiness() {
		return bussiness;
	}

	public void setBussiness(Bussiness bussiness) {
		this.bussiness = bussiness;
	}
	
	

}
