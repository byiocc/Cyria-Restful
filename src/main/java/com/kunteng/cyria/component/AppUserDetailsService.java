package com.kunteng.cyria.component;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.kunteng.cyria.repository.UserRepository;

@Component
public class AppUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository; 
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		com.kunteng.cyria.domain.User user = userRepository.findByUsername(username);
	    if(user == null) {
	      throw new UsernameNotFoundException("User not found");
	    }
	    
	    List<GrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role));
        });
	    return new User(user.getUsername(), user.getPassword(), authorities);
	}

}
