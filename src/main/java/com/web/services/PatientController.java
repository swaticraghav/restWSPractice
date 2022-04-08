package com.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.services.bean.Patient;
import com.web.services.patient.PatientService;

@RestController
public class PatientController {

	@Autowired
	@Qualifier("projectHospital")
	PatientService patientService;

	/*
	 * Request URL - http://localhost:8080/patients
	 */
	@RequestMapping(value = "/patients", method = RequestMethod.GET)
	public List<Patient> getPatients() {
		return patientService.getPatients();
	}

	/*
	 * http://localhost:8080/patients/123
	 */
	@RequestMapping(value = "/patients/{id}", method = RequestMethod.GET)
	public Patient getPatient(@PathVariable("id") Long id) {
		return patientService.getPatient(Long.valueOf(id));
	}

	/*
	 * Below are some test scenarios
	 */

	/*
	 * This is for @PathVariable URL - http://localhost:8080/testOne/LifeIsAwesome
	 */
	@GetMapping("/testOne/{randomString}")
	public String testOne(@PathVariable String randomString) {
		return "Test One - " + randomString;
	}

	/*
	 * This is also for @PathVariable URL -
	 * http://localhost:8080/testTwo/LifeIsAmazing
	 */
	@GetMapping("/testTwo/{randomString}")
	public String testTwo(@PathVariable("randomString") String s) {
		return "Test Two - " + s;
	}

	/*
	 * This is for @RequestParam URL -
	 * http://localhost:8080/testThree?randomString=1000
	 */
	@GetMapping("/testThree")
	@ResponseBody
	public String testThree(@RequestParam(value = "randomString", required = true) String id) {
		return "Test Three - " + id;
	}

	/*
	 * http://localhost:8080/test
	 */
	@GetMapping("/test")
	public String test() {
		return patientService.getTest();
	}

	/*
	 * http://localhost:8080/hello
	 */
	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello World!";
	}

	/*
	 * http://localhost:8080
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String getAllOrders() {
		return "All orders";
	}

	/*
	 * http://localhost:8080/987
	 */
	@RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
	@ResponseBody
	public String getOrder(@PathVariable final String orderId) {
		return "Order ID: " + orderId;
	}

	/*
	 * http://localhost:8080/987/items
	 */
	@RequestMapping(value = "/{orderId}/items", method = RequestMethod.GET)
	@ResponseBody
	public String getItemsByOrder(@PathVariable final String orderId) {
		return "Items for Order ID " + orderId;
	}

	/*
	 * http://localhost:8080/987/items/4567
	 */
	@RequestMapping(value = "/{orderId}/items/{itemId}", method = RequestMethod.GET)
	@ResponseBody
	public String getItem(@PathVariable final String orderId, @PathVariable final String itemId) {
		return "Order ID: " + orderId + ", Item ID: " + itemId;
	}
}