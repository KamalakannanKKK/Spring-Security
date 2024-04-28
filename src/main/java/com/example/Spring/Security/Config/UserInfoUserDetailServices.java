package com.example.Spring.Security.Config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.Spring.Security.Controller.Repository.UserRepository;
import com.example.Spring.Security.Entity.UserEntity;

public class UserInfoUserDetailServices  implements UserDetailsService {

	@Autowired
	private UserRepository userrepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<UserEntity> userinfo=userrepo.findByUserName(username);
		return null;
	}



}
