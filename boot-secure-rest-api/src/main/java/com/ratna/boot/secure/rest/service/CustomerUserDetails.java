package com.ratna.boot.secure.rest.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ratna.boot.secure.rest.model.Employee;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerUserDetails implements UserDetails {
	private Employee user;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> listAuth = new ArrayList<SimpleGrantedAuthority>();
		List<String> list = user.getRole().stream().collect(Collectors.toList());
		for (String string : list) {
			listAuth.add(new SimpleGrantedAuthority("ROLE_" + string));
		}
		return listAuth;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
