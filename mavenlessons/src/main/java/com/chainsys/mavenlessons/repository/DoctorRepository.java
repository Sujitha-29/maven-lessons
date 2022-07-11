package com.chainsys.mavenlessons.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chainsys.mavenlessons.entity.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {
	Doctor findById(int id); //  findById method retrieves an entity by its id
    Doctor save(Doctor dr); // Used for adding a doctor and update the doctor.
    void deleteById(int id);
    List<Doctor> findAll();
}
// query is generated here(findById)