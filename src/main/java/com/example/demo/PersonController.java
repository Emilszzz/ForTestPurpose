package com.example.demo;

import com.example.demo.Person;


import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonController {
	//private final PersonService personService;
	@Autowired
	private PersonRepository personRepository; 
	
	
	@Autowired
	public PersonController(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	/* nav vajadzigs
	@RequestMapping(value="/createPerson", method = RequestMethod.GET)
    public ModelAndView createPerson(){
        ModelAndView modelAndView = new ModelAndView();
        Person p = new Person();
       modelAndView.addObject("user", p);
       modelAndView.setViewName("greeting");
       return modelAndView;
    }
*/
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String homePage(Model model) {
		model.addAttribute("person", new Person());
		return "greeting";
	}

	@RequestMapping(value = "/person", method = RequestMethod.POST)
	public String addPagePerson(@ModelAttribute Person person, Model model) {
		personRepository.save(person);
		return "redirect:person";
	}

	@RequestMapping(value = "/person", method = RequestMethod.GET)
	public String showallpersons(@ModelAttribute Person person, Model model) {
		model.addAttribute("persons", personRepository.findAll());
		return "person";
	}
	//@RequestMapping(value = "/Allpersons", method = RequestMethod.GET)
	@GetMapping(path="/allpersons")
	public  @ResponseBody Iterable<Person> getAllPersons(){
		return personRepository.findAll();
	}
	
	@RequestMapping(value = "/edit/{decisionIds}", method = RequestMethod.GET)// ieraksta laukos values
    public  String GetById( Model model, @PathVariable @ModelAttribute int decisionIds) {
           //System.out.println(decisionIds);
           Person p = personRepository.findById(decisionIds);
           model.addAttribute("persons", p);
           //System.out.println(p.getName());
           return "edit";
}
	/*
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
	public String saveUpdate(@PathVariable Integer id, @ModelAttribute("person") Person person) {
	    System.out.println(person.getName());
	    return "redirect:/edit/" + id;
	}*/
	
	@RequestMapping(value = "/edit/update", method = RequestMethod.POST) //update poga
	public  String UpdatePersonInfo(@ModelAttribute Person person, Model model) {
		//personRepository.deleteById(person.getId());
		System.out.println(person.getName());
		//personRepository.save(person);
		//personRepository.findAll();
		//model.addAttribute("persons",personRepository.findAll());
		 // System.out.println(person.getName());
		  //return "redirect:/"+person.getId()+"/"+"updated";
		return "edit";
} 
		
	
	/*
	
	@RequestMapping(value = "/{decisionIds}/updated", method = RequestMethod.GET)
    public  String UpdateById( Model model, @PathVariable  int decisionIds) {
           System.out.println(decisionIds);
           Person p = personRepository.findById(decisionIds);
           model.addAttribute("persons", p);
           System.out.println(p.getName());
           return " redirect:" +"/" + p.getId();
	}
	
	/*@RequestMapping(value = "/person/{personId}", method = RequestMethod.GET)
	public Person getPersonId(@PathVariable int personId) {
		System.out.println("id " + personId);
		return personRepository.findById(personId);
	} */
}