package com.web.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.web.services.bean.Patient;

@Service
@Qualifier("myImplementation")
public class PatientServiceImpl implements PatientService {

	Map<Long, Patient> patients = new HashMap<>();
	long id = 123;

	public PatientServiceImpl() {
		init();
	}

	void init() {

		Patient patient = new Patient();
		patient.setId(id);
		patient.setName("Swati Raghav");
		patients.put(patient.getId(), patient);
	}

	@Override
	public List<Patient> getPatients() {
		List<Patient> list = new ArrayList<>(patients.values());
		return list;
	}

	@Override
	public String getTest() {
		return "Swati Raghav";
	}

}
