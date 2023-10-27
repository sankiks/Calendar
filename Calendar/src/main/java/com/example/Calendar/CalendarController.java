package com.example.Calendar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // for http requests
@RequestMapping(path = "api/v1/Calendar")// specifing the url path
public class CalendarController {
	
	 

	
	private final CalendarService calendarService;

	@Autowired
	public CalendarController(CalendarService calendarService) {
		
		this.calendarService = calendarService;
	}
	
	
	@PostMapping
	public void addNewPerson(@RequestBody Person person) {
		System.out.print("Jag kommer till post");
		calendarService.addPerson(person);
	}
	
	@GetMapping

	public List<Person> getPerson() {
		System.out.println("Jag kommer till get");
		List<Person> persList= calendarService.getPersons();
		for(Person person : persList) {
			System.out.println(person.toString());
		}
		
		return persList ;
	}
	
	/*
	@PostMapping
	public String SetHello() {
		System.out.println("hej");
		return "";
		
	}*/
	
	@GetMapping("/hello")
	public String getHello() {
		return calendarService.getHello();
		
	}
}
