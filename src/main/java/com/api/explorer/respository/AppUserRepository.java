package com.api.explorer.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.explorer.entity.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	public AppUser findOneByUsername(String username);
}
