package com.api.explorer.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "Bussiness")
@Table(name = "bussiness")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Bussiness implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long biz_id;

	private String name;

	private String companyName;

	private String companyAddress;

	private String website;

	private String type;

	@JsonManagedReference
	@OneToMany(mappedBy = "bussiness", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Review> review;

	Bussiness() {

	}

	public Bussiness(Long biz_id, String name, String companyName, String companyAddress, String website, String type,
			List<Review> review) {
		super();
		this.biz_id = biz_id;
		this.name = name;
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.website = website;
		this.type = type;
		this.review = review;
	}

	

	public List<Review> getReview() {
		return review;
	}

	public void setReview(List<Review> review) {
		this.review = review;
	}

	public Long getBiz_id() {
		return biz_id;
	}

	public void setBiz_id(Long biz_id) {
		this.biz_id = biz_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
