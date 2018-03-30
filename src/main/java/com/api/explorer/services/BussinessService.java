package com.api.explorer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.explorer.entity.Bussiness;
import com.api.explorer.respository.BussinessRepositoty;

@Service
public class BussinessService {

	@Autowired
	private BussinessRepositoty bizRepository;
	
	public List<Bussiness> getBussiness(){
		return (List<Bussiness>) bizRepository.findAll();
	}

	public Bussiness addBussiness(Bussiness biz) {
		// TODO Auto-generated method stub
		return bizRepository.save(biz);
	}
	
	public Bussiness getBuzById(Long id) {
		return bizRepository.getOne(id);
	}
	
	public void deleteBizById(Long id) {
		bizRepository.deleteById(id);
	}
	
}
