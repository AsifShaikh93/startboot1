package com.startboot1.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
/*import java.util.ArrayList;
import java.util.Iterator;*/
/*import java.io.Writer;
import java.util.Collection;
import java.util.Iterator;*/
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;*/
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
/*import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.web.IWebExchange;*/

import com.startboot1.dao.PersonRepository;
import com.startboot1.entity.Person;

@RestController
/* @Controller */
@CrossOrigin
public class ReestController {

	@Autowired
	public PersonRepository personrepository;
	
	 @PostMapping("/testprsn")
	  public Person merntest(@RequestBody Person person) {
		  //person.setProfilename("test");
		  System.out.println(person);
		  Person savedprsn = personrepository.save(person);
		  return savedprsn;
	  }
	
	@GetMapping("/getallpersons")
	 public List<Person> getallpersons(Model model) throws IOException { 
			/* public void getallpersons(Model model){ */
		
		/*,final IWebExchange webExchange, 
		        final ITemplateEngine templateEngine, 
		        final Writer writer)
		        throws Exception*/ 
		
		List<Person> allpersons1 = (List<Person>) personrepository.findAll();
		/* System.out.println(allpersons1); */
		/*
		 * Iterator<Person> itr = allpersons1.iterator();
		 * 
		 * @SuppressWarnings("rawtypes") ArrayList allprofiles=new ArrayList();
		 * 
		 * 
		 * while(itr.hasNext()) {
		 * 
		 * Person personbefore=itr.next(); BufferedImage profile = ImageIO.read(new
		 * File("'D:\\ImagesUploadedFromBootApp\\'+personbefore.getProfilename()"));
		 * allprofiles.add(profile);
		 * 
		 * 
		 * }
		 * 
		 * 
		 * 
		 * model.addAttribute("allprofiles",allprofiles);
		 */
		model.addAttribute("person-sg","hello this is to check model attribute"); 
		
		
		Map<Person, String> umap=new HashMap<Person, String>();
		for(final Person prsn: allpersons1) {
			
			umap.put(prsn, "some text for "+prsn.getName());
		}
		
		/* System.out.println(size); */
			
		/*
		 * Iterator<Person> i = allpersons.iterator(); while(i.hasNext()){ Person
		 * personfromgetallpersons=i.next();
		 * model.addAttribute(personfromgetallpersons); }
		 */
		/*
		 * final WebContext ctx = new WebContext(webExchange, webExchange.getLocale());
		 * ctx.setVariable("prods", allpersons);
		 * 
		 * templateEngine.process("product/list", ctx);
		 */
		 return allpersons1; 
	}
	
	@GetMapping("/getaperson/{personid}")
	public Person getaperson(@PathVariable("personid") int personid) {
		
		Optional<Person> result = personrepository.findById(personid);
		Person resultperson = result.get();
		return resultperson;
	}
	
	/*
	 * @PutMapping("/updateaperson/{personid}") public Person
	 * updateaperson(@PathVariable("personid") int personid) {
	 * 
	 * Optional<Person> result = personrepository.findById(personid); Person
	 * resultperson = result.get(); resultperson.setName("this is updated"); Person
	 * updatedperson = personrepository.save(resultperson); return updatedperson; }
	 * 
	 * @DeleteMapping("/deleteaperson/{personid}") public void
	 * deleteaperson(@PathVariable("personid") int personid) {
	 * 
	 * Optional<Person> personoptional = personrepository.findById(personid); Person
	 * persontobedeleted = personoptional.get();
	 * personrepository.delete(persontobedeleted); return ; }
	 */
	
	@GetMapping("/deleteallpersons")
	public void deleteallpersons() {
		
		personrepository.deleteAll();
		
	}
}
