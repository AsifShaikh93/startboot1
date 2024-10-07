
package com.startboot1.controller;

//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.startboot1.dao.PersonRepository;
import com.startboot1.entity.Person;

@Controller                        
public class ActionController {  

	@Autowired
	public PersonRepository personrepository;

	@GetMapping("/deleteentry/{prsnage}")
	public String deleteentry(@PathVariable("prsnage") int prsnage) {
		Optional<Person> per = personrepository.findById(prsnage);
		Person pern = per.get();
		System.out.println(pern);
	    personrepository.deleteById(prsnage); 
		System.out.println("deleted from action controller");
		System.out.println(pern.getAge());
		return "redirect:http://localhost:8080/personforactions";
	}


	
	@GetMapping("/updateentry/{prsnage}")
	public String updateentry(@PathVariable("prsnage") int prsnage) {
		/*
		 * List<Person> allpersonbefore = (List<Person>) personrepository.findAll();
		 * Iterator<Person> iterator = allpersonbefore.iterator(); List<Person>
		 * tempperson=new ArrayList<>(); while (iterator.hasNext()) { Person person =
		 * iterator.next();
		 * 
		 * if (person.getAge() == prsnage) { person.setName("updated name");
		 * person.setSname("updated sname"); } }
		 */
		Optional<Person> persontem = personrepository.findById(prsnage);
		Person person = persontem.get();
		person.setName("updated");
		personrepository.save(person);
		return "redirect:http://localhost:8080/personforactions";
	}
}
