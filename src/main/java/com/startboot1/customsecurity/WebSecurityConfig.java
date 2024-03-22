package com.startboot1.customsecurity;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.linkbuilder.ILinkBuilder;
import org.thymeleaf.spring6.SpringTemplateEngine;

import com.startboot1.gmail.Emailrequest;

@Configuration
@EnableWebSecurity
/* @EnableWebMvc */
public class WebSecurityConfig  {

    @Autowired  
	private JwtAuthenticationFilter filter;
    
    @Autowired
    private JwtAuthenticationEntryPoint point;
    
    
    

      
	  @Bean 
	  UserDetailsService getuderdetailservice() { 
		  UserDetailServiceImpl userDetailServiceImpl=new UserDetailServiceImpl();
		  return userDetailServiceImpl; 
		  }
	 
	  @Bean
		public AuthenticationManager authenticationManager(UserDetailsService userDetailsService,BCryptPasswordEncoder passwordEncoder) 
	    {
			DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
			authenticationProvider.setUserDetailsService(userDetailsService);
			authenticationProvider.setPasswordEncoder(passwordEncoder);

			return new ProviderManager(authenticationProvider);
		}
	
	/*
	 * @Autowired UserDetailServiceImpl userDetailServiceImpl;
	 * 
	 * @Autowired BCryptPasswordEncoder bCryptPasswordEncoder;
	 */
	 

	
	  @Bean BCryptPasswordEncoder getpasswordencoder() {
	  
	  return new BCryptPasswordEncoder(); 
	  }
	 
    
		/*
		 * @Bean DaoAuthenticationProvider getauthprovider() { DaoAuthenticationProvider
		 * daoAuthenticationProvider=new DaoAuthenticationProvider();
		 * daoAuthenticationProvider.setUserDetailsService(getuderdetailservice());
		 * daoAuthenticationProvider.setPasswordEncoder(getpasswordencoder()); return
		 * daoAuthenticationProvider; }
		 */
    
    
    
	/*
	 * @Bean AuthenticationManager getauthmanager(AuthenticationConfiguration
	 * configuration) throws Exception { AuthenticationManager authenticationManager
	 * = configuration.getAuthenticationManager();
	 * 
	 * return authenticationManager;
	 * 
	 * }
	 */
    
	/*
	 * .formLogin(login -> login.loginPage("/contact")); (requests ->
	 * requests.requestMatchers("/logout", "/sendMail",
	 * "/register","/contact","/person"). permitAll().
	 * 
	 * anyRequest().authenticated())
	 */
	/* formLogin(form-> form.loginPage("/login").successForwardUrl("/contact")) */
    
	@Bean
    SecurityFilterChain securityfilterchain(HttpSecurity http) throws Exception {

        
		/*
		 * .formLogin(t ->
		 * t.loginPage("/login").successForwardUrl("/contact").permitAll() );
		 */
        	
       
        /*.requestMatchers("/login","/person","/personforactions","/contact","/getallpersons","/personsforsearchinput/**","/deleteentry/**","/updateentry"	,"/getaperson/**","/deleteallpersons").permitAll())*/      
        
        
                
		 /*http.authenticationProvider(getauthprovider()); */
        
			/*
			 * DefaultSecurityFilterChain defaultSecurityFilterChain = http.build(); return
			 * defaultSecurityFilterChain;
			 */
			/* .httpBasic(Customizer.withDefaults())
			 * .formLogin(Customizer.withDefaults()) */
		/*formLogin(form->form.loginPage("/login").defaultSuccessUrl("/home", true).permitAll())*/
    	
    	return http
    			
    	        .csrf(csrf -> csrf.disable())
    	        .authorizeHttpRequests(auth -> auth
						/*
						 * .requestMatchers("/contact","/getallpersons","/getaperson/**").authenticated(
						 * )
						 */
    	        	.requestMatchers("/dummy").authenticated()	
    	            .anyRequest().permitAll() )
    	        .formLogin(form->form.loginPage("/login").defaultSuccessUrl("/home", true).permitAll())
    	        .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
    	        .exceptionHandling(ex->ex.authenticationEntryPoint(point))
    	        .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
    	        .build();
    	
    }
}
