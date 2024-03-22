package com.startboot1.customsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.startboot1.dao.PersonRepository;
import com.startboot1.entity.Person;


public class UserDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	PersonRepository personrepository;
	
	Model model;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Person person = personrepository.getUserByUserName(username);
		if(person==null) {
			
			boolean userexist=false;
			model.addAttribute("userexist", userexist);
		}
		UserDetailImpl userdetailimpl=new UserDetailImpl(person);
		return userdetailimpl;
	}

}
