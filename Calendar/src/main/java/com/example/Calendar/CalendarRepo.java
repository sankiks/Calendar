package com.example.Calendar;

import java.util.Calendar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarRepo extends JpaRepository<Person, Long>{

	void save(Meeting meeting);

}
