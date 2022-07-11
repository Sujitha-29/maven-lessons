package com.chainsys.mavenlessons.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.chainsys.mavenlessons.entity.Appointment;
import com.chainsys.mavenlessons.entity.Doctor;
import com.chainsys.mavenlessons.repository.AppointmentRepository;
import org.springframework.web.servlet.view.RedirectView;

@RestController // This annotation is used at the class level and allows the class to handle the
				// requests made by the client.
public class AppointmentControl {
	@Autowired
	private AppointmentRepository aptrepo;
	
	@GetMapping(value ="/getdoctorbyappointmentid")
	public String getDoctorByAppointmentId(int id)
	{
		Appointment app=aptrepo.findById(id);
		Doctor doc=app.getDoctor();
		return doc.toString();
	}

	@GetMapping(value = "/getappointmentbyid")
	public Appointment getAppointmentById(int id) {
		return aptrepo.findById(id); // return object
	}
	
//	@GetMapping(value = "/getappointmentbyid")
//	public String getAppointmentById(int id) {
//		Appointment app= aptrepo.findById(id);
//		return app.toString(); // return string
//	}

	@GetMapping(value = "/getallappointments")
	public List<Appointment> getAppointments() {
		return aptrepo.findAll();
	}

	@GetMapping(value = "/appointmentbydoctorid")
	public List<Appointment> getAppointmentByDocId(int id) {
		return aptrepo.findByDoctorId(id);
	}

	@PostMapping(value = "/newappointment", consumes = "application/json")
	public RedirectView addAppointment(@RequestBody Appointment apt) {
		aptrepo.save(apt);
		return  new  RedirectView ("/getallappointments");
	}

	@PostMapping(value = "/modifyappointment", consumes = "application/json")
	public RedirectView modifyDoctor(@RequestBody Appointment apt) {
		aptrepo.save(apt);
		return  new  RedirectView ("/getallappointments");
	}

	@DeleteMapping(value = "/deleteappointment")
	public RedirectView deleteappointment(int id) {
		aptrepo.deleteById(id);
		return  new  RedirectView ("/getallappointments");
	}
}
