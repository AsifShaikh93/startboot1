package com.startboot1.controller;

import java.io.File;
//import java.io.File;
//import java.beans.XMLEncoder;
//import java.io.BufferedReader;
/*import java.io.DataOutputStream;*/
import java.io.IOException;
import java.io.InputStream;
/*import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;*/
import java.net.URI;
//import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Iterator;
//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.accept.MappingMediaTypeFileExtensionResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.startboot1.dao.PersonRepository;
import com.startboot1.entity.Person;

//import jakarta.persistence.criteria.Path;

@Controller
@CrossOrigin
public class MyController {

	@Autowired
	public PersonRepository personrepository;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	
	/*
	 * @PostMapping ("/person") public String formsubmit(@RequestParam("profile")
	 * MultipartFile profile, Model model) throws Exception, InterruptedException {
	 * System.out.println(profile.getName());
	 * System.out.println(profile.getOriginalFilename());
	 * System.out.println(profile.getSize()); System.out.println(profile.isEmpty());
	 * 
	 * Files.copy(profile.getInputStream(),
	 * java.nio.file.Path.of("D:\\ImagesUploadedFromBootApp\\"+profile.
	 * getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
	 * 
	 * return "about"; }
	 */
	    
	@RequestMapping("/test")
	public String loadTest() {
		
		return "test";
	}
	
	@RequestMapping("/login")
	public String getlogin() {
		return "login";
		}
	@RequestMapping("/home")
	public String gethome() {
		return "home";
		}
	 
		 
	  @PostMapping("/person") 
	  public String about(@ModelAttribute("myform") Person person,@RequestParam("profile") MultipartFile profile, Model model) throws
	  Exception, InterruptedException {
	  
	  System.out.println(person);
	  
	  if(person.getName().isBlank()||person.getSname().isBlank())
	  {
	  person.setName("test"); // personrepository.delete(person);
	  System.out.println("deleted from inside of if block"); 
	  } 
	  else {
	  person.setProfilename(profile.getOriginalFilename());	 
	  person.setPassword(encoder.encode(person.getPassword()));
		/* person.setRole("ROLE_USER"); */
	  personrepository.save(person); 
	  System.out.println(person); 
	  }
	  
	  
	  
	  
	/*
	 * 
	 * String oldir =
	 * "D:\\All-boot-projects\\startboot1\\src\\main\\resources\\static\\images";
	 * String nwdir = multi.getOriginalFilename();
	 * 
	 * java.nio.file.Path path = java.nio.file.Path.of(oldir+nwdir);
	 * 
	 * 
	 * Files.copy(multi.getInputStream(), path,
	 * StandardCopyOption.REPLACE_EXISTING);
	 * 
	 * 
	 * 
	 * 
	 * Files.copy(multi.getInputStream(),
	 * nwdir+File.separator+multi.getOriginalFilename(),
	 * StandardCopyOption.REPLACE_EXISTING );
	 */
	  
	  
	  // System.out.println(result); // model.addAttribute("person", result); //
	  model.addAttribute("greet","yes we have successfully implemented it");
	  
	  final String uploadurl1=new ClassPathResource("/static").getFile().getAbsolutePath();
	 //File file=new File("/home/ubuntu/deployed-proj-on-aws/BOOT-INF/classes/static");
	//  String uploadurl2 = file.getAbsolutePath();
	  //final String uploadurl2="/home/ubuntu/deployed-proj-on-aws/BOOT-INF/classes/static";
	 // D:\All-boot-projects\startboot1\target\classes\static\images
		/*
		 * Files.copy(profile.getInputStream(), java.nio.file.Path.of(
		 * "D:\\All-boot-projects\\startboot1\\src\\main\\resources\\static\\images\\"+
		 * profile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
		 * 
		 */ 
		/*
		 * InputStream is = profile.getInputStream(); byte[] data=new
		 * byte[is.available()]; is.read(data);
		 * 
		 * File file=new File(uploadurl+File.separator+profile.getOriginalFilename());
		 * try (FileOutputStream fos = new FileOutputStream(file)) { fos.write(data); }
		 * is.close();
		 */
		/* fos.close(); */
	  
	  
	  
		
		  System.out.println(profile); 
		  InputStream is = profile.getInputStream(); 
		  Path path1 =java.nio.file.Path.of(uploadurl1+File.separator+profile.getOriginalFilename()); 
		//  Path path2 =java.nio.file.Path.of(uploadurl2+File.separator+profile.getOriginalFilename()); 
		  Files.copy(is,path1,StandardCopyOption.REPLACE_EXISTING);
		 // Files.copy(is,path2,StandardCopyOption.REPLACE_EXISTING);
		   System.out.println(uploadurl1+File.separator+profile.getOriginalFilename());
		 // System.out.println(uploadurl2+File.separator+profile.getOriginalFilename());
		   System.out.println(path1); 
		  
		 // System.out.println(path2); 
		  is.close();
		 
	  //executeGet("http://localhost:8080/getallpersons", "");
	  
	  
		/*
		 * Files.deleteIfExists(java.nio.file.Path.of(
		 * "C:\\Users\\Admin\\AppData\\Local\\Temp\\"));
		 */
	  getfunction(model); 
	  
	  return "about"; 
	  }
	  
	 
	  
	 
	@GetMapping("/personforactions")
	public String personforactions(Model model) throws Exception, InterruptedException  {
	

		getfunction(model);
		return "about";
	}
	/*
	 * @RequestMapping(value = "/about") public String aboutabout() {
	 * 
	 * return "about"; }
	 */

	/*
	 * produces = "text/plain" produces = {"text/plain", "application/*"} produces =
	 * MediaType.TEXT_PLAIN_VALUE produces = "text/plain;charset=UTF-8"
	 */

	/* application/x-www-form-urlencoded;charset=UTF-8 */

	@GetMapping("/contact")
	public String contact() {

		/*
		 * Person person1= new Person(); person1.setName("abcdef");
		 * 
		 * Person person2= new Person(); person2.setName("sskjhas");
		 * 
		 * Person person3= new Person(); person3.setName("hhbfkj");
		 * 
		 * List<Person> persons= new ArrayList<>(); persons.add(person1);
		 * persons.add(person2); persons.add(person3); Iterable<Person> result =
		 * personrepository.saveAll(persons);
		 * 
		 * 
		 * result.forEach(p-> {
		 * 
		 * System.out.println(p); });
		 */

		return "contact";
	}

	/*
	 * @GetMapping("/person") public String savetodb(@RequestBody Person person) {
	 * 
	 * 
	 * Person result = personrepository.save(person); System.out.println(result);
	 * 
	 * return "about"; }
	 */
	/*
	 * public static String executeGet(String targetURL, String urlParameters) {
	 * HttpURLConnection connection = null;
	 * 
	 * try { // Create connection URL url = new URL(targetURL); connection =
	 * (HttpURLConnection) url.openConnection();
	 * 
	 * connection.setRequestMethod("GET");
	 * 
	 * connection.setRequestProperty("Content-Type", "text/plain");
	 * 
	 * 
	 * connection.setRequestProperty("Content-Length",
	 * Integer.toString(urlParameters.getBytes().length));
	 * connection.setRequestProperty("Content-Language", "en-US");
	 * 
	 * connection.setUseCaches(false);
	 * 
	 * connection.setDoOutput(true);
	 * 
	 * // Send request DataOutputStream wr = new
	 * DataOutputStream(connection.getOutputStream()); wr.writeBytes(urlParameters);
	 * wr.writeBytes(urlParameters); wr.close();
	 * 
	 * // Get Response InputStream is = connection.getInputStream(); BufferedReader
	 * rd = new BufferedReader(new InputStreamReader(is)); StringBuilder response =
	 * new StringBuilder(); // or StringBuffer if Java version 5+ String line; while
	 * ((line = rd.readLine()) != null) { response.append(line);
	 * response.append('\r'); } rd.close(); System.out.println(response); return
	 * response.toString(); } catch (Exception e) { e.printStackTrace(); return
	 * null; } finally { if (connection != null) { connection.disconnect(); } } } 
	 */


public void getfunction(Model model) throws IOException, InterruptedException {
	
	HttpRequest request = HttpRequest.newBuilder()
			.GET()
			.uri(URI.create("http://localhost:8080/getallpersons"))
			.build();

	        HttpResponse<String> response = HttpClient.newHttpClient()
			.send(request, HttpResponse.BodyHandlers.ofString());
			/* System.out.println(response.body()); */
	 ObjectMapper objectMapper = new ObjectMapper();
	 List<Person> allpersons = objectMapper.readerForListOf(Person.class).readValue(response.body());
		/* System.out.println(allpersons); */
		 int size = allpersons.size();
			 model.addAttribute("allpersons",allpersons); 
			 model.addAttribute("size",size); 
}

public List<Person> getfunctionforgmail(Model model) throws IOException, InterruptedException {
	
	HttpRequest request = HttpRequest.newBuilder()
			.GET()
			.uri(URI.create("http://localhost:8080/getallpersons"))
			.build();

	        HttpResponse<String> response = HttpClient.newHttpClient()
			.send(request, HttpResponse.BodyHandlers.ofString());
			/* System.out.println(response.body()); */
	 ObjectMapper objectMapper = new ObjectMapper();
	 List<Person> allpersons = objectMapper.readerForListOf(Person.class).readValue(response.body());
		/* System.out.println(allpersons); */
		 int size = allpersons.size();
			 model.addAttribute("allpersons",allpersons); 
			 model.addAttribute("size",size);
			return allpersons; 
}

//search controller
@GetMapping("/personsforsearchinput/{searchinput}")
public String personsforsearchinput(@PathVariable("searchinput") String pattern,Model model) throws IOException, InterruptedException { 
	List<Person> allpersonsbeforematch = (List<Person>) personrepository.findAll();
	List<Person> allpersonsaftermatch =new ArrayList<>();
	Iterator<Person> allpersonsiterator = allpersonsbeforematch.iterator();
	while(allpersonsiterator.hasNext()){
		Person prn = allpersonsiterator.next();
		if(prn.getName().contains(pattern)||prn.getSname().contains(pattern)) {
			allpersonsaftermatch.add(prn);
		}
	}
	int sizeofsearchresult= allpersonsaftermatch.size();
	model.addAttribute("sizeofsearchresult", sizeofsearchresult);
	model.addAttribute("allpersonsaftermatch", allpersonsaftermatch);
	
	getfunction(model);
	return "about"; 
}
}