package com.chainsys.mavenlessons.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.chainsys.mavenlessons.entity.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer>{
	Appointment findById(int id);
	void deleteById(int id);
	List<Appointment> findAll();
	Appointment save(Appointment apt);
	// @Query(value ="select a from Appointment a where a.dr_id=?1")
	// jpql - java persistent query language
	// here 'a' is an instance of Appointment entity
    List<Appointment> findByDoctorId(int drId);
	
	
    
}
