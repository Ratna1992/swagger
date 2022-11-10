package com.boot.ratna.txmgmt.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.ratna.txmgmt.dto.Acknowledgement;
import com.boot.ratna.txmgmt.dto.FlightBookingRequest;
import com.boot.ratna.txmgmt.entity.PassengerInfoEntity;
import com.boot.ratna.txmgmt.entity.PaymentEntity;
import com.boot.ratna.txmgmt.repo.PassengerInfoRepository;
import com.boot.ratna.txmgmt.repo.PaymentInfoRepository;
import com.boot.ratna.txmgmt.utils.CreditLimitCheck;

@Service
public class FlightBookingService {

	@Autowired
	private PassengerInfoRepository passengerInfoRepository;

	@Autowired
	private PaymentInfoRepository paymentInfoRepository;

	@org.springframework.transaction.annotation.Transactional
	public Acknowledgement bookFlightTicket(FlightBookingRequest request) {

		PassengerInfoEntity passengerInfo = request.getPassengerInfo();
		passengerInfo = passengerInfoRepository.save(passengerInfo);

		PaymentEntity payment = request.getPayment();
		CreditLimitCheck.validateCreditLimit(payment.getAccountNo(), passengerInfo.getFare());
		payment.setPassengerId(passengerInfo.getPId());
		payment.setAmount(passengerInfo.getFare());
		paymentInfoRepository.save(payment);
		return new Acknowledgement("SUCCESS", passengerInfo.getFare(), UUID.randomUUID().toString(), passengerInfo);

	}

}
