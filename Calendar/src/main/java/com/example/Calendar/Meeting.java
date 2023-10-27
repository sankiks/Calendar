package com.example.Calendar;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table  
public class Meeting {

	

	@Id
	@SequenceGenerator(name="meeting_sequence", sequenceName = "meeting_sequence",
	allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@Column (name="placeStr")
	private String placeString;
	@Column (name="meetingTimeDate")
	private LocalDate meetingTimeDate;
	
	@ManyToMany(mappedBy = "meetingsList")
	private List<Person> attendees;
	private long meetingHolder;

	public Meeting(long id, String placeString, LocalDate meetingTimeDate, long meetingholder) {
		super();
		this.id = id;
		this.placeString = placeString;
		this.meetingTimeDate = meetingTimeDate;
		this.setMeetingHolder(meetingholder);
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlaceString() {
		return placeString;
	}

	public void setPlaceString(String placeString) {
		this.placeString = placeString;
	}

	public LocalDate getMeetingTimeDate() {
		return meetingTimeDate;
	}

	public void setMeetingTimeDate(LocalDate meetingTimeDate) {
		this.meetingTimeDate = meetingTimeDate;
	}


	public void setAttendees(List<Person> attendees) {
		if (attendees.isEmpty()) {
			this.attendees = attendees;
		}else {
			for (Person attendee : attendees) {
			    this.attendees.add(attendee);
			}
		}
		
	}
	
	public void setAttendee(Person attendees) {
		this.attendees.add(attendees);
	}

	public long getMeetingHolder() {
		return meetingHolder;
	}

	public void setMeetingHolder(long meetingHolder) {
		this.meetingHolder = meetingHolder;
	}
	
	
	@Override
	public String toString() {
		return "Meeting [id=" + id + ", placeString=" + placeString + ", meetingTimeDate=" + meetingTimeDate
				+ ", attendees=" + attendees + "]";
	}
	

}
