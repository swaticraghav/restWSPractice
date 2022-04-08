package com.web.services.patient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.web.services.bean.Patient;

@Service
@Qualifier("projectHospital")
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

	public List<Patient> getPatients() {
		List<Patient> list = new ArrayList<>(patients.values());
		return list;
	}

	public Patient getPatient(Long userId) {
		return patients.get(userId);
	}

	public String getTest() {
		return "Swati Raghav Test";
	}

}
