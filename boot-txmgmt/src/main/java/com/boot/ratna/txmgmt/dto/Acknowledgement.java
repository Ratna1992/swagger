package com.boot.ratna.txmgmt.dto;

import com.boot.ratna.txmgmt.entity.PassengerInfoEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Acknowledgement {

	private String status;
	private double totalFare;
	private String uniqueNo;
	private PassengerInfoEntity passengerInfoEntity;

}
