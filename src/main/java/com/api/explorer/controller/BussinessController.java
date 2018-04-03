package com.api.explorer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.explorer.entity.Bussiness;
import com.api.explorer.services.BussinessService;

@RestController
@RequestMapping("/biz")
public class BussinessController {
	
	@Autowired
	private BussinessService bizService;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/all")
	public List<Bussiness> getBussiness(){
		return bizService.getBussiness();
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/add")
	public ResponseEntity<Bussiness> addBussiness(@RequestBody Bussiness biz){
		return new ResponseEntity<>(bizService.addBussiness(biz) , HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/{bizId}")
	public ResponseEntity<Bussiness> getBizById(@PathVariable Long bizId){
		return new ResponseEntity<>(bizService.getBuzById(bizId) , HttpStatus.FOUND);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/{bizId}")
	public ResponseEntity<Void> deleteBizById(@PathVariable Long bizId){
		bizService.deleteBizById(bizId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/{biz_id}")
	public ResponseEntity<Bussiness> updateBiz(@PathVariable long biz_id , @RequestBody Bussiness bussiness){
		Bussiness biz = bizService.getBuzById(biz_id);
		bussiness.setBiz_id(biz.getBiz_id());
		return new ResponseEntity<>(bizService.addBussiness(bussiness), HttpStatus.CREATED);
	}
	
	
	
	
}
