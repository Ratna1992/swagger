package com.boot.ratna.txmgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.ratna.txmgmt.dto.Acknowledgement;
import com.boot.ratna.txmgmt.dto.FlightBookingRequest;
import com.boot.ratna.txmgmt.service.FlightBookingService;

@RestController
@RequestMapping("/book")
public class FlightBookingController {

	@Autowired
	private FlightBookingService flightBookingService;

	@PostMapping("/flight/ticket")
	public Acknowledgement bookFlightTicket(@RequestBody FlightBookingRequest request) {
		return flightBookingService.bookFlightTicket(request);
	}

}
