package com.startboot1.customsecurity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.startboot1.entity.Person;

public class UserDetailImpl implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	
	private Person person;
	
	public UserDetailImpl(Person person) {
		super();
		this.person = person;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
		List<GrantedAuthority> list=new ArrayList<GrantedAuthority>();
		list.add(grantedAuthority);
		return list;
	}

	@Override
	public String getPassword() {
		
		return person.getPassword();
	}

	@Override
	public String getUsername() {
		
		return person.getEmailid();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		
		
		return true;
	}

}
