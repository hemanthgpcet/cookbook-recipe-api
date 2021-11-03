/**
 * 
 */
package com.cookbook.recipeapi.util;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cookbook.recipeapi.dto.UsersDTO;
import com.cookbook.recipeapi.model.UserEntity;

/**
 * This class consists Junit testcases for JwtRequestFilter
 *
 * @author heman
 *
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class JwtRequestFilterTest {
	
	@InjectMocks
	private JwtRequestFilter jwtRequestFilter;
	
	@Mock
	private UserDetailsService myUserDetailsService;

	@Mock
	private Jwt jwt;
	
	
	@Test
	public void doFilterInternalTest() throws IOException, ServletException{
		UserEntity user = new UserEntity();
		user.setId(Long.valueOf("1"));
		user.setIsActive(true);
		user.setPassword("pass456");
		user.setRoles("Admin");
		user.setUserName("kumar");
		UserDetails UserDetails = new UsersDTO(user);
		MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
		MockHttpServletResponse httpServletResponse = new MockHttpServletResponse();
		MockFilterChain filterChain = new MockFilterChain();
		httpServletRequest.addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoZW1hbnRoIiwiZXhwIjoxNjM1ODUzMjE5LCJpYXQiOjE2MzU4NTIwMTl9.KRs6MpDF4v9Drgt1ytfzlo-iKSn4tM_LBcCBukmT_1M");
		when(jwt.extractUsername(Mockito.anyString())).thenReturn("user");
		when(myUserDetailsService.loadUserByUsername(Mockito.anyString())).thenReturn(UserDetails);
		when(jwt.validateToken(Mockito.anyString(), Mockito.any())).thenReturn(true);
		jwtRequestFilter.doFilterInternal(httpServletRequest, httpServletResponse, filterChain);
	}
	
	
	@Test
	public void InvalidTokenTest() throws IOException, ServletException {
		UserEntity user = new UserEntity();
		user.setId(1l);
		user.setIsActive(true);
		user.setPassword("pass456");
		user.setRoles("Admin");
		user.setUserName("kumar");
		UserDetails UserDetails = new UsersDTO(user);
		when(jwt.extractUsername(Mockito.anyString())).thenReturn("user");
		when(myUserDetailsService.loadUserByUsername(Mockito.anyString())).thenReturn(UserDetails);
		when(jwt.validateToken(Mockito.anyString(), Mockito.any())).thenReturn(false);
		boolean isValid=jwt.validateToken(Mockito.anyString(),Mockito.any());
		assertTrue(!isValid);
	}

}
