package com.startboot1.gmail;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;

import com.startboot1.controller.MyController;
import com.startboot1.entity.Person;

//import jakarta.mail.internet.MimeMessage;

@RestController
public class Gmailcontroller {
    
	@Autowired
	GmailService gmailService;
	
	@Autowired
	MyController mycontroller;
	 
    @PostMapping("/sendMail")
    public String sendingmail(@RequestBody Emailrequest emailRequest,Model model) throws Exception
    {
    	Context context = new Context();
        context.setVariable("message", emailRequest.getBody());
    	List<Person> allpersons = mycontroller.getfunctionforgmail(model);
		/*
		 * String principalname = princiapl.getName();
		 * System.out.println(principalname);
		 */
    	gmailService.sendgmailfunc(allpersons, emailRequest.getTo(), emailRequest.getSubject(),"htmlgmailcontent", context);
        return "OK";
    }
}

/*
 * spring.mail.host=smtp.gmail.com spring.mail.port=587
 * spring.mail.username=asifshaikh0393@gmail.com spring.mail.password=asif@1993
 * spring.mail.properties.mail.smtp.auth=true
 * spring.mail.properties.mail.smtp.starttls.enable=true
 */