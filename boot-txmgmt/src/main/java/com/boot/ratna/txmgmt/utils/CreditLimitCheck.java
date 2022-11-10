package com.boot.ratna.txmgmt.utils;

import java.util.HashMap;
import java.util.Map;

import com.boot.ratna.txmgmt.exceptions.NoCreditAvailableException;

public class CreditLimitCheck {

	private static Map<String, Double> creditMap = new HashMap<>();
	static {
		creditMap.put("SBI", 12000d);
		creditMap.put("HDFC", 272000d);
		creditMap.put("SBH", 17000d);
		creditMap.put("ICICI", 14000d);

	}

	public static boolean validateCreditLimit(String accountNo, Double amount) {
		if (amount > creditMap.get(accountNo)) {
			throw new NoCreditAvailableException("No available amount");

		} else {
			return true;
		}

	}
}
