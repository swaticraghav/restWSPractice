package com.web.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.web.services.bean.Patient;

@Service
@Qualifier("myImplementation")
public class PatientService {

	Map<Long, Patient> patients = new HashMap<>();
	long id = 123;

	public PatientService() {
		init();
	}

	void init() {

		Patient patient = new Patient();
		patient.setId(id);
		patient.setName("Swati Raghav");
		patients.put(patient.getId(), patient);
	}

	public String getTest() {
		return "Swati Raghav";
	}

	/*
	 * GET with http://localhost:8080/patients
	 */
	public List<Patient> getPatients() {
		List<Patient> list = new ArrayList<>(patients.values());
		return list;
	}

	/*
	 * GET with http://localhost:8080/patients/123
	 */
	public Patient getPatient(long id) {
		if (patients.get(id) == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return patients.get(id);
	}

	/*
	 * POST with http://localhost:8080/patients
	 * 
	 * XML Request - <Patient> <name>Baigan Kam Bharta</name> </Patient>
	 *
	 * JSON REquest { "name": "Swati Raghav" }
	 */
	public String createPatient(Patient patient) {
		patient.setId(++id);
		patients.put(patient.getId(), patient);
		return "Patient - " + patient.getName() + " has been added Successfully. Please Note the ID - "
				+ patient.getId();
	}

	/*
	 * PUT with http://localhost:8080/patients
	 * 
	 * JSON REquest { "name": "Swati RaghavNew" , "id": 123 }
	 * 
	 */
	public String updatePatient(Patient patient) {

		Patient selectedPatient = patients.get(patient.getId());

		if (selectedPatient != null) {
			patients.put(patient.getId(), patient);
			return "Patient with ID - " + patient.getId() + " has been updated to " + patient.getName();
		} else {
			return "Entry not found with ID - " + patient.getId() + ", " + patient.getName();
		}
	}

	/*
	 * Delete with http://localhost:8080/patients/123
	 */
	public String deletePatient(long inputID) {

		Patient patient = patients.get(inputID);
		if (patient != null) {
			patients.remove(inputID);
			return patient.getName() + " has been deleted successfully.";
		} else {
			return "Entry with " + inputID + " does not exist";
		}

	}

}
