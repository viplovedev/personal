package dev.viplove.springbootstarter.service;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dev.viplove.springbootstarter.model.User;
import dev.viplove.springbootstarter.model.UserDetailsImpl;
import dev.viplove.springbootstarter.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Inject
	UserRepository uR;
	
	public User addUser(User u) {
		
		User saved = uR.save(u);
		return saved;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> findByUsername = uR.findByUsername(username);
		
		findByUsername.orElseThrow(()->new UsernameNotFoundException("Username not found"));
		return findByUsername.map(UserDetailsImpl::new).get();
	}
}
