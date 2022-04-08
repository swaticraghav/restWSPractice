package com.web.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.web.services.bean.Patient;

@Path("/patientservice")
public interface PatientService {

	@Path("/patients")
	@GET
	List<Patient> getPatients();

	String getTest();
}
