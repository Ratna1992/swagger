package com.ratna.boot.secure.rest.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ratna.boot.secure.rest.model.Employee;
import com.ratna.boot.secure.rest.repository.EmployeeRepository;
import com.ratna.boot.secure.rest.service.CustomerUserDetails;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private EmployeeRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Employee user = userRepository.findByEmail(username);
		if (user != null) {
			CustomerUserDetails userDetails = new CustomerUserDetails();
			userDetails.setUser(user);
			return userDetails;
		} else {
			throw new UsernameNotFoundException("User Name is not Found");

		}

	}

}
