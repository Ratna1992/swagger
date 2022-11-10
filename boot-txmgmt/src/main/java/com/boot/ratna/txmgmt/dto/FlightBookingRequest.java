package com.boot.ratna.txmgmt.dto;

import com.boot.ratna.txmgmt.entity.PassengerInfoEntity;
import com.boot.ratna.txmgmt.entity.PaymentEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FlightBookingRequest {

	private PassengerInfoEntity passengerInfo;
	private PaymentEntity payment;
}
