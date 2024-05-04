package com.greatlearning.batch5Jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.batch5Jwt.entity.AuthenticationRequest;
import com.greatlearning.batch5Jwt.entity.AuthenticationResponse;
import com.greatlearning.batch5Jwt.service.MyUserDetailsService;
import com.greatlearning.batch5Jwt.util.JwtUtil;

@RestController
public class JwtController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	MyUserDetailsService userDetailsService;
	
	@Autowired
	JwtUtil jwtTokenUtil;

	 @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
	        try {
	            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
	        }
	        catch (BadCredentialsException e) {
	            throw new Exception("Incorrect username or password", e);
	        }

	        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

	        final String jwt = jwtTokenUtil.generateToken(userDetails);

	        return ResponseEntity.ok(new AuthenticationResponse(jwt));
	    }

	 @GetMapping("/one")        //Alice			Ben
	 public String welcome()
	 {
		 return "Welcome to JWT";
	 }
	 	
	 @GetMapping("/two")		//Alice
	 public String greet()
	 {
		 return "Greetings from Great Learning";
	 }
	 
	 @RequestMapping("/403")		//Alice
	 public String forbidden()
	 {
		 return "Sorry, You do not have access to this service";
	 }
}
