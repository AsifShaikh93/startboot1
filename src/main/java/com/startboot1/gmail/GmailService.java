package com.startboot1.gmail;

import java.io.File;
import java.net.MalformedURLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.FileUrlResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.startboot1.entity.Person;

//import com.startboot1.controller.MyController;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class GmailService {
	
	@Autowired
    private JavaMailSenderImpl mailSender;
	
	@Autowired
	private TemplateEngine templateEngine;
	

	public void sendgmailfunc(List<Person> allpersons,String to,String subject,String templateName, Context context) throws MessagingException, Exception  {
		
		File file=new File("D:\\All-boot-projects\\startboot1\\src\\main\\resources\\static\\images\\2216490_498b96c_600x_.jpg");
	       
		FileSystemResource filesystemresource = new FileSystemResource(file);
		MimeMessage message = mailSender.createMimeMessage();
	   
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        
        helper.setTo(to);
        helper.setSubject(subject);
       
       // templateEngine.setLinkBuilder("https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css");
       // String htmlContent = templateEngine.process(templateName, context);
        String htmlContent="<html xmlns:th=\"http://www.thymeleaf.org\">\r\n"
        		+ "<head>\r\n"
        		+ "<meta charset=\"ISO-8859-1\">\r\n"
        		+ "<title>Insert title here</title>\r\n"
        		+ "<link href=\"cid:bootstrap-link\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">\r\n"
        		+ "<link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\r\n"
        		+ "      <!--Import materialize.css-->\r\n"
        		+ "<link type=\"text/css\" rel=\"stylesheet\" href=\"css/materialize.min.css\"  media=\"screen,projection\"/>\r\n"
        		+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"contact.css\"/>\r\n"
        		+ "<script src=\"https://kit.fontawesome.com/739f41e008.js\" crossorigin=\"anonymous\"></script>\r\n"
        		+ "<!-- <script type=\"text/javascript\" src=\"\" th:src=\"@{/js/our.min.js}\"></script> -->\r\n"
        		+ "<script src=\"https://kit.fontawesome.com/yourcode.js\" crossorigin=\"anonymous\"></script>\r\n"
        		+ "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js\"></script>\r\n"
        		+ "<script>\r\n"
        		+ "$(function(){\r\n"
        		+ "	$('#anchorlinktobeappended').click(function(){\r\n"
        		+ "		\r\n"
        		+ "		/* window.location=\"https://www.google.com\"; */\r\n"
        		+ "		window.location=$(this).attr('href')+$('#pattern').val();\r\n"
        		+ "		return false;\r\n"
        		+ "	});\r\n"
        		+ "	\r\n"
        		+ "}); \r\n"
        		+ "</script>\r\n"
        		+ "<style>"
        		+ ".btn {\r\n"
        		+ "	display: inline-block;\r\n"
        		+ "	font-weight: 400;\r\n"
        		+ "	line-height: 1.5;\r\n"
        		+ "	color: #212529;\r\n"
        		+ "	text-align: center;\r\n"
        		+ "	text-decoration: none;\r\n"
        		+ "	vertical-align: middle;\r\n"
        		+ "	cursor: pointer;\r\n"
        		+ "	-webkit-user-select: none;\r\n"
        		+ "	-moz-user-select: none;\r\n"
        		+ "	user-select: none;\r\n"
        		+ "	background-color: transparent;\r\n"
        		+ "	border: 1px solid transparent;\r\n"
        		+ "	padding: .375rem .75rem;\r\n"
        		+ "	font-size: 1rem;\r\n"
        		+ "	border-radius: .25rem;\r\n"
        		+ "	transition: color .15s ease-in-out, background-color .15s ease-in-out,\r\n"
        		+ "		border-color .15s ease-in-out, box-shadow .15s ease-in-out\r\n"
        		+ "}\r\n"
        		+ ".form-control {\r\n"
        		+ "	display: block;\r\n"
        		+ "	width: 100%;\r\n"
        		+ "	padding: .375rem .75rem;\r\n"
        		+ "	font-size: 1rem;\r\n"
        		+ "	font-weight: 400;\r\n"
        		+ "	line-height: 1.5;\r\n"
        		+ "	color: #212529;\r\n"
        		+ "	background-color: #fff;\r\n"
        		+ "	background-clip: padding-box;\r\n"
        		+ "	border: 1px solid #ced4da;\r\n"
        		+ "	-webkit-appearance: none;\r\n"
        		+ "	-moz-appearance: none;\r\n"
        		+ "	appearance: none;\r\n"
        		+ "	border-radius: .25rem;\r\n"
        		+ "	transition: border-color .15s ease-in-out, box-shadow .15s ease-in-out\r\n"
        		+ "}\r\n"
        		+ ".mb-3 {\r\n"
        		+ "	margin-bottom: 1rem !important\r\n"
        		+ "}\r\n"
        		+ ".form-text {\r\n"
        		+ "	margin-top: .25rem;\r\n"
        		+ "	font-size: .875em;\r\n"
        		+ "	color: #6c757d\r\n"
        		+ "}\r\n"
        		+ ".btn-primary {\r\n"
        		+ "	color: #fff;\r\n"
        		+ "	background-color: #0d6efd;\r\n"
        		+ "	border-color: #0d6efd\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ ".btn-primary:hover {\r\n"
        		+ "	color: #fff;\r\n"
        		+ "	background-color: #0b5ed7;\r\n"
        		+ "	border-color: #0a58ca\r\n"
        		+ "}\r\n"
        		+ "</style>\r\n"
        		+ "</head> \r\n"
        		+ "<body>\r\n"
        		+ "<div style=\"border:1px solid blue;height:600px;\" >\r\n"
        		+ "<img src=\"cid:mia\"/>\r\n"
        		+ "</div>  \r\n  "
        		+ "<div class=\"formm\" style=\"margin-top: 400px;\" \r\n "
        		+ "<form>\r\n"
        		+ "  <div class=\"mb-3\">\r\n"
        		+ "    <label for=\"exampleInputEmail1\" class=\"form-label\">Email address</label>\r\n"
        		+ "    <input type=\"email\" class=\"form-control\" id=\"exampleInputEmail1\" aria-describedby=\"emailHelp\">\r\n"
        		+ "    <div id=\"emailHelp\" class=\"form-text\">We'll never share your email with anyone else.</div>\r\n"
        		+ "  </div>\r\n"
        		+ "  <div class=\"mb-3\">\r\n"
        		+ "    <label for=\"exampleInputPassword1\" class=\"form-label\">Password</label>\r\n"
        		+ "    <input type=\"password\" class=\"form-control\" id=\"exampleInputPassword1\">\r\n"
        		+ "  </div>\r\n"
        		+ "  <button type=\"submit\" class=\"btn btn-primary\">Submit</button>\r\n"
        		+ "</form>\r\n"
        		+ "</div> \r\n"
        		+ "\r\n"
        		+ "\r\n"
        		+ " <a href=\"https://xhamster.desi/categories/anal\">GO to GooGle</a>   \r\n"
        		+ "\r\n"
        		+ "</body>\r\n"
        		+ "</html>";
        helper.setText(htmlContent, true);
        helper.addInline("bootstrap-link", new FileSystemResource("D:\\All-boot-projects\\startboot1\\src\\main\\resources\\static\\bootstrap.css"),"text/css");
        helper.addInline("mia",filesystemresource);
        
		  //helper.addAttachment(file.getName(), filesystemresource);
		 
        mailSender.send(message);
		
		System.out.println(allpersons);
		
		
	}
}
