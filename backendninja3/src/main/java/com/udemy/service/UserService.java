package com.udemy.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.udemy.entity.User;
import com.udemy.entity.UserRoles;
import com.udemy.repository.UserRepository;

@Service("userService")
public class UserService implements UserDetailsService{
	
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		return null;
	}
	
	private User builUser(User user, List<GrantedAuthority> autority) {
		
		return new User(user.getUserName(), user.getPassword(), user.isEnable(), userRoles);
	}
	
	
	private List<GrantedAuthority> buildAuthorities(Set<UserRoles> userRoles) {
		Set<GrantedAuthority> auth = new HashSet<GrantedAuthority>();
		for(UserRoles useRole : userRoles) {
			auth.add(new SimpleGrantedAuthority(useRole.getRole()));
		}
		return new ArrayList<GrantedAuthority>(auth);
	}
	

}
