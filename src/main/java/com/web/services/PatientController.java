package com.web.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.web.services.bean.Patient;

@Consumes("application/xml, applicataion/json")
@Produces("application/xml, applicataion/json")
@RestController
public class PatientController {

	@Autowired
	@Qualifier("myImplementation")
	PatientService patientService;

	@GetMapping("/patients")
	public List<Patient> getPatients() {
		return patientService.getPatients();
	}

	@GetMapping("/patients/{id}")
	public Patient getPatient(@PathVariable("id") long id) {

		// Testing for Errors -
		if (id == 999) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		if (id == 998) {
			throw new WebApplicationException(Response.Status.BAD_GATEWAY);
		}
		if (id == 997) {
			throw new WebApplicationException(Response.Status.BAD_REQUEST);
		}
		if (id == 996) {
			throw new WebApplicationException(Response.Status.EXPECTATION_FAILED);
		}
		if (id == 995) {
			throw new WebApplicationException(Response.Status.SEE_OTHER);
		}
		if (id == 994) {
			throw new NotFoundException();
		}

		return patientService.getPatient(id);
	}

	@PostMapping(value = "/patients", consumes = MediaType.APPLICATION_JSON)
	@ResponseStatus(HttpStatus.OK)
	public String createPatient(@RequestBody Patient patient) {
		return patientService.createPatient(patient);
	}

	@PutMapping(value = "/patients", consumes = MediaType.APPLICATION_JSON)
	public String updatePatient(@RequestBody Patient patient) {
		return patientService.updatePatient(patient);
	}

	@DeleteMapping("/patients/{id}")
	public String deletePatient(@PathVariable("id") long id) {
		return patientService.deletePatient(id);
	}

}