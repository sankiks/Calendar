package com.example.Calendar;

import java.time.LocalDate;
import java.util.List;


import javax.management.loading.PrivateClassLoader;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table
public class Person {
	
	@Id
	@SequenceGenerator(name="person_sequence", sequenceName = "person_sequence",
	allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	@ManyToMany
	@JoinTable(name = "Attendees", 
			joinColumns = @JoinColumn (name="person_id"),
			inverseJoinColumns = @JoinColumn(name = "meeting_id"))
	private List<Meeting> meetingsList;
	
	private String name;
	private String mailString;
	
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", meetinglist=" + meetingsList + ", name=" + name + ", mailString=" + mailString
				+ "]";
	}
	
	
	/*public Person(long id,  String name, String mailString, List<Meeting> meetinglist) {
		super();
		this.id = id;
		this.name = name;
		this.mailString = mailString;
		this.meetingsList=meetinglist;
	}*/
	
	public Person(long id,  String name, String mailString) {
		super();
		this.id = id;
		this.name = name;
		this.mailString = mailString;
		
	}
	
	public List<Meeting> getMeetinglist() {
		return meetingsList;
	}


	public void setMeetinglist(List<Meeting> meetinglist) {
		this.meetingsList = meetinglist;
	}
	 


	public String getMailString() {
		return mailString;
	}


	public void setMailString(String mailString) {
		this.mailString = mailString;
	}


	public List<Meeting> getMeetingDate() {
		return meetingsList;
	}


	public void setMeetingDate(List<Meeting> meetinglist) {
		this.meetingsList = meetinglist;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	

}
