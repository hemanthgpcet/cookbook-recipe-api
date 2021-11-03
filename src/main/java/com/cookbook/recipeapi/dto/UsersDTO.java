package com.cookbook.recipeapi.dto;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cookbook.recipeapi.model.UserEntity;
/**
 * This class containing Users related data members
 * 
 * @author heman
 *
 */
public class UsersDTO implements UserDetails {
	
	/**
	 * 
	 * serialVersionUID for UsersDTO
	 */
	private static final long serialVersionUID = 212332392254093128L;
	private String userName;
	private String password;
	private Boolean active;
	private List<GrantedAuthority> authorities;
	
	/**
	 * Default constructor
	 */
	public UsersDTO() {
	}

	/**
	 * Method to get userDetails
	 * 
	 */
	public UsersDTO(UserEntity user) {
		super();
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.active = user.getIsActive();
		this.authorities = Arrays.stream(user.getRoles().split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	/**
	 * @return the authorities
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	/**
	 * @return the password
	 */
	@Override
	public String getPassword() {
		return password;
	}

	/**
	 * @return the username
	 */
	@Override
	public String getUsername() {
		return userName;
	}

	/**
	 * @return the active
	 */
	@Override
	public boolean isAccountNonExpired() {
		return active;
	}

	/**
	 * @return the active
	 */
	@Override
	public boolean isAccountNonLocked() {
		return active;
	}

	/**
	 * @return the active
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return active;
	}

	/**
	 * @return the active
	 */
	@Override
	public boolean isEnabled() {
		return active;
	}

	

}
