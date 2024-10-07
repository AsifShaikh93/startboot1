package com.startboot1.customsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
//import org.springframework.boot.autoconfigure.security.oauth2.server.servlet.OAuth2AuthorizationServerProperties.Token;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin

public class JwtController {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private JwtUtil jwtutil;
	
	@PostMapping("/token")
	
	  public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest
	  request,Model model) {
	 
	/*public void login(@RequestBody JwtRequest request,Model model) {*/
		
		
	 this.doAuthenticate(request.getEmail(), request.getPassword()); 


        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        
        String token = this.jwtutil.generateToken(userDetails);
        
        //model.addAttribute(token, token);
        System.out.println(token);
       // modelSetter(model,token);
       // model.addAttribute(tokenExist);
        JwtResponse response = new JwtResponse();
        response.setJwtToken(token);
        response.setUsername(userDetails.getUsername());
        
        
        
        return new ResponseEntity<>(response, HttpStatus.OK);
       
    }
	
	private void doAuthenticate(String email, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);


        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }
	
	private void modelSetter(Model model,String token) {
		boolean tokenExist=false;
		System.out.println(token);
		model.addAttribute(token, token);
		model.addAttribute(tokenExist);
	}
	
	@RequestMapping("/dummy")
	public String loaddummy() {
		
		return "dummy";
	}

}
