package com.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.services.bean.Patient;

@RestController
public class PatientController {

	@Autowired
	@Qualifier("myImplementation")
	PatientService patientService;

	@RequestMapping("/patients")
	public List<Patient> getPatients() {
		return patientService.getPatients();
	}

	@RequestMapping("/test")
	public String test() {
		return patientService.getTest();
	}

	@RequestMapping("/")
	public String home() {
		return "Hello World!";
	}

}