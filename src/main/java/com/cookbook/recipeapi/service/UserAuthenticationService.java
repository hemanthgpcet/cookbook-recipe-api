/**
 * 
 */
package com.cookbook.recipeapi.service;

import org.springframework.stereotype.Service;

import com.cookbook.recipeapi.dto.UsersDTO;
import com.cookbook.recipeapi.model.UserEntity;
import com.cookbook.recipeapi.repository.UserRepository;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * This class is service provider for user authentication
 * 
 * @author heman
 *
 */
@Service
public class UserAuthenticationService implements UserDetailsService {
	
	private static final Logger logger = LogManager.getLogger(UserAuthenticationService.class);

	@Autowired
	private UserRepository userRepository;
	
	/**
	 * This method is use to load user by username from database.
	 * 
	 * @return UserDetails
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.debug("Invoke loadUserByUsername() method with username:{}", () -> username);
		Optional<UserEntity> user = userRepository.findByUserName(username);
		user.orElseThrow(() -> new UsernameNotFoundException(username + "  Not found in Our records" ));
		logger.debug("Exit from loadUserByUsername() method.");
		return user.map(UsersDTO::new).get();
	}
	

}
