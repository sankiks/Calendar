package com.example.Calendar;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalendarService {
	
	private final CalendarRepo calendarRepo;

	
	@Autowired
	public CalendarService(CalendarRepo calendarRepo) {
		
		this.calendarRepo = calendarRepo;
	}
	
	
	public void addPerson(Person person) {
		System.out.print(person);
		Optional<Person> personTemp = calendarRepo.findById(person.getId());
		if (personTemp.isPresent()) {
			throw new IllegalStateException("User "+person.getName() + " with ID "+ person.getId()
			+ " already exists!");
		}
		calendarRepo.save(person);
	}


	public List<Person> getPersons() {
		List<Person> person= calendarRepo.findAll();
		
		return person;
	}


	public String getHello() {
		// TODO Auto-generated method stub
		return "helloWorld";
	}


	public void addPerson(long id, String name, String mailString) {
		Optional<Person> temp= calendarRepo.findById(id);
		if (temp.isPresent()) {
			throw new IllegalStateException("User "+name + " with ID "+ id
			+ " already exists!");
		}
		calendarRepo.save(new Person(id, name, mailString));
		
	}


	public void createMeeting(long meetingHolderId, long id, String placeString, LocalDate meetingTimeDate) {
		Optional<Person> personTemp= calendarRepo.findById(id);
		
		if (personTemp.isEmpty()) {
			throw new IllegalStateException("User  with ID "+ id
					+ " does not exists!");
		}
		if (personTemp.get().getMeetingDate().contains(meetingTimeDate)) {
			throw new IllegalStateException("User "+personTemp.get().getName() + " with ID "+ personTemp.get().getId()
					+ " Already have a meeting booked at this time");
		}
		
		calendarRepo.save(new Meeting(id, placeString, meetingTimeDate,meetingHolderId));
		
	}
	
	
	
	
	

}
